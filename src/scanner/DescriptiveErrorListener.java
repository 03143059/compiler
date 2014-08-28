package scanner;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class DescriptiveErrorListener extends BaseErrorListener {
    public static DescriptiveErrorListener INSTANCE = new DescriptiveErrorListener();
    public boolean result = true;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e)
    {

//        String sourceName = recognizer.getInputStream().getSourceName();
//        if (!sourceName.isEmpty()) {
//            sourceName = String.format("%s: warning at line %d, pos %d: ", sourceName, line, charPositionInLine);
//        }

        System.err.println(String.format("\rline %d:%d %s", line, charPositionInLine, msg));
        result = false;
    }
}
