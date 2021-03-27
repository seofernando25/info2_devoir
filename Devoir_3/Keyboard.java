package Devoir_3;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.InputStreamReader;

public class Keyboard {
    private static String line = null; // line read from input.
    private static int pos = 0; // Position of next char in input line, not processed yet.
    private final static Pattern integerRegex = Pattern.compile("(\\+|-)?[0-9]+");

    private static int inErrorCount; // Number of consecutive errors on standard input; reset to 0 when a successful
                                     // read occurs.
    private final static BufferedReader standardIn = new BufferedReader(new InputStreamReader(System.in)); // wraps
                                                                                                           // standard
                                                                                                           // input
                                                                                                           // stream
    private final static PrintWriter standardOut = new PrintWriter(System.out); // wraps standard output stream
    private static boolean readingStandardIn = true;
    private static boolean writingStandardOut = true;

    private static BufferedReader in = standardIn; // Stream that data is read from.
    private static PrintWriter out = standardOut; // Stream that data is written to.

    private static Matcher integerMatcher; // For reading integer numbers; created from the integer Regex Pattern.

    /**
     * Skips whitespace characters and then reads a value of type char from input,
     * discarding the rest of the current line of input.
     */
    public static char getlnChar() {
        char ch = getChar();
        emptyLine();
        return ch;
    }

    /**
     * discard the rest of the current line of input
     */
    private static void emptyLine() {
        line = null;
    }

    /**
     * Skips whitespace characters and then reads a single non-whitespace character
     * from input.
     */
    public static char getChar() {
        skipWhitespace();
        return readChar();
    }

    /**
     * Skips over any whitespace characters, including for end-of-lines.
     */
    private static void skipWhitespace() {
        char ch = nextChar();
        while (Character.isWhitespace(ch)) {
            readChar();
            if (ch == '\n' && readingStandardIn && writingStandardOut) {
                out.print("? ");
                out.flush();
            }
            ch = nextChar();
        }
    }

    /**
     * return next character from input
     */
    private static char nextChar() {
        if (line == null || pos > line.length())
            fillLine();

        if (pos == line.length())
            return '\n';
        else
            return line.charAt(pos);
    }

    /**
     * returns and discards next character from input
     */
    private static char readChar() {
        char ch = nextChar();
        if (line == null) {
            if (readingStandardIn)
                throw new IllegalArgumentException("Illegal Argument");

        }
        pos++;
        return ch;
    }

    /**
     * Type a line and return,
     */
    private static void fillLine() {
        try {
            line = in.readLine();
        } catch (Exception e) {
            if (readingStandardIn)
                throw new IllegalArgumentException("Standard input error");
        }
        pos = 0;
        integerMatcher = null;
    }

    /**
     * Skips whitespace characters and then reads a value of type int from input,
     * discarding the rest of the current line of input (including the next
     * end-of-line character, if any).
     */
    public static int getlnInt() {
        int n = getInt();
        emptyLine();
        return n;
    }

    /**
     * Skips whitespace characters and then reads a value of type int from input.
     */
    public static int getInt() {
        return (int) readInteger(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static long readInteger(long min, long max) { // read integer in specified range
        long k = 0;
        while (true) {
            String s = readIntegerString();
            if (s == null) {
                errorMessage("Input value not found.", "Integer in the range " + min + " to " + max);
            } else {
                String str = s.toString();
                try {
                    k = Long.parseLong(str);
                } catch (NumberFormatException e) {
                    errorMessage("Illegal input, " + str + ".", "Integer in the range " + min + " to " + max);
                    continue;
                }
                if (k < min || k > max) {
                    errorMessage("Input out off range, " + str + ".", "Integer in the range " + min + " to " + max);
                    continue;
                }
                break;
            }
        }
        inErrorCount = 0;
        return k;
    }

    /**
     * read chars from input following syntax of integers
     */
    private static String readIntegerString() {
        skipWhitespace();

        if (integerMatcher == null)
            integerMatcher = integerRegex.matcher(line);
        integerMatcher.region(pos, line.length());
        if (integerMatcher.lookingAt()) {
            String str = integerMatcher.group();
            pos = integerMatcher.end();
            return str;
        } else
            return null;
    }

    /**
     * Report error on input.
     */
    private static void errorMessage(String message, String wanted) {
        if (readingStandardIn && writingStandardOut) {
            // inform user of error and ask user to re-enter.
            out.println();
            out.print("  *** Input error : " + message + "\n");
            out.print("  *** Wanted: " + wanted + "\n");
            if (nextChar() == '\n')
                out.print("(end-of-line)\n\n");
            else {
                while (nextChar() != '\n') // Discard and echo remaining chars on the current line of input.
                    out.print(readChar());
                out.print("\n\n");
            }
            out.print("Please re-enter: ");
            out.flush();
            readChar(); // discard the end-of-line character
            inErrorCount++;
            if (inErrorCount >= 10)
                throw new IllegalArgumentException("Standard input errors.");
        }

        else
            throw new IllegalArgumentException("Input stream error:\n" + message + "\nWanted " + wanted);
    }

}
