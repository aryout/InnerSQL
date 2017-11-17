package com.aryout.text;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;

/**
 * Created by 97390 on 11/14/2017.
 */
public class Scanner {
    private Token currentToken  = new SimpleToken(""); // BeginToken
    private BufferedReader inputReader = null;

    private int inputLineNumber = 0;
    private String inputLine = null;
    private int inputPosition = 0;

    private TokenSet tokens;

    public Scanner(TokenSet tokens, String input){
        this(tokens, new StringReader(input));
    }

    public Scanner(TokenSet tokens, Reader inputReader){
        this.tokens = tokens;
        this.inputReader = (inputReader instanceof BufferedReader ? (BufferedReader) inputReader : new BufferedReader(inputReader));
        loadLine();
    }

    private boolean loadLine(){

        try {
            inputLine = inputReader.readLine();
            if (inputLine != null){
                ++inputLineNumber;
                inputPosition = 0;
            }
            return inputLine != null;
        }catch (IOException e){
            return false;
        }
    }

    public boolean match(Token candidate){
        return currentToken == candidate;
    }

    public  Token advance()throws ParseFailure{
        try {
            if (currentToken != null){
                inputPosition += currentToken.lexeme().length();
                currentToken = null;

                if (inputPosition == inputLine.length()){
                    if (!loadLine()){
                        return null;
                    }
                }

                while (Character.isWhitespace(inputLine.charAt(inputPosition))){

                    if (++inputPosition == inputLine.length()){
                        if (!loadLine()){
                            return null;
                        }
                    }
                }

                for (Iterator i = tokens.iterator(); i.hasNext();) {
                    Token t = (Token)(i.next());
                    if (t.match(inputLine, inputPosition)){
                        currentToken = t;
                        break;
                    }
                }

                if (currentToken == null){
                    throw failure("Unrecognized Input");
                }
            }
        }catch (IndexOutOfBoundsException e){

        }
        return currentToken;
    }

    public ParseFailure failure(String message){
        return new ParseFailure(message, inputLine, inputPosition, inputLineNumber);
    }

    public String matchAdvance(Token candidate) throws ParseFailure{
        if (match(candidate)){
            String lexeme = currentToken.lexeme();
            System.out.println(currentToken);
            advance();
            return lexeme;
        }
        return null;
    }

    public final String required(Token candidate) throws ParseFailure{
        String lexeme = matchAdvance(candidate);
        if (lexeme == null){
            throw failure("\"" + candidate.toString() + "\" expected.");
        }
        return lexeme;
    }

    public static class Test{
        private static TokenSet tokens = new TokenSet();

        private static final Token
                COMMA = tokens.create("',"),
                IN = tokens.create("'IN'"),
                INPUT = tokens.create("INPUT"),
                IDENTIFIER = tokens.create("[a-z_][a-z_0-9]*");

        public static void main(String[] args) throws ParseFailure{
            assert COMMA instanceof SimpleToken : "Factory Failure 1";
            assert IN instanceof WordToken : "Factory Failure 2";
            assert INPUT instanceof WordToken : "Factory Failure 3";
            assert IDENTIFIER instanceof RegexToken: "Factory Failure 4";

            Scanner analyzer = new Scanner(tokens, ",aBc In input inputted");

            assert analyzer.advance() == COMMA : "COMMA unrecognized";
            assert analyzer.advance() == IDENTIFIER : "ID unrecognized";
            assert analyzer.advance() == IN : "IN unrecognized";
            assert analyzer.advance() == INPUT : "INPUT unrecognized";
            assert analyzer.advance() == IDENTIFIER : "ID unrecognized";

            analyzer = new Scanner(tokens, "Abc IN\nCde");
            analyzer.advance();

            assert (analyzer.matchAdvance(IDENTIFIER).equals("Abc"));
            assert (analyzer.matchAdvance(IN).equals("in"));
            assert (analyzer.matchAdvance(IDENTIFIER).equals("Cde"));

            analyzer = new Scanner(tokens, "xyz\nabc + def");
            analyzer.advance();
            analyzer.advance();
            try {
                analyzer.advance();
                assert false: "Error Detection Failure";
            }catch (ParseFailure e){
                assert e.getErrorReport().equals("Line 2:\nabc + def\n____^\n");
            }
            System.out.println("Scanner PASSED");
            System.exit(0);
        }
    }
}
