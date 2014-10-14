package parser; /***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import org.antlr.v4.runtime.*;
public class MyErrorStrategy extends DefaultErrorStrategy {

    public Boolean result = true;

    @Override
    public void reportMissingToken(org.antlr.v4.runtime.Parser recognizer) {
        String msg = "syntax error"; // nonstandard msg

        String sourceName = recognizer.getInputStream().getSourceName();
        Token t = recognizer.getCurrentToken();
        if (!sourceName.isEmpty()) {
            msg = String.format("%s: %s at line %d, pos %d, near '%s'",
                    sourceName, msg, t.getLine(), t.getCharPositionInLine(), t.getText());
        }

        System.err.println(msg);
        System.exit(1);
    }

    @Override
    public void reportError(org.antlr.v4.runtime.Parser recognizer, org.antlr.v4.runtime.RecognitionException e)
        throws RecognitionException
    {
        // ANTLR generates Parser subclasses from grammars and
        // Parser extends Recognizer. Parameter parser is a
        // pointer to the parser that detected the error

        String msg = "syntax warning"; // nonstandard msg

        String sourceName = recognizer.getInputStream().getSourceName();
        Token t = e.getOffendingToken();
        if (!sourceName.isEmpty()) {
            msg = String.format("%s: %s at line %d, pos %d, near '%s'",
                    sourceName, msg, t.getLine(), t.getCharPositionInLine(), t.getText());
        }

        System.err.println(msg);
        //recognizer.notifyErrorListeners(e.getOffendingToken(), null, null);
//        recognizer.notifyErrorListeners(msg);
        //throw new RecognitionException(msg, null, null, null);
      //  System.exit(1);
    }

}
