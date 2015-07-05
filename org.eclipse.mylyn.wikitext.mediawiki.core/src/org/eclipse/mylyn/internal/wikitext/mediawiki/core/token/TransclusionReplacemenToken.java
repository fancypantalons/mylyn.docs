package org.eclipse.mylyn.internal.wikitext.mediawiki.core.token;

import org.eclipse.mylyn.wikitext.core.parser.Attributes;
import org.eclipse.mylyn.wikitext.core.parser.DocumentBuilder;
import org.eclipse.mylyn.wikitext.core.parser.markup.PatternBasedElement;
import org.eclipse.mylyn.wikitext.core.parser.markup.PatternBasedElementProcessor;

public class TransclusionReplacemenToken extends PatternBasedElement
{
    @Override
    protected String getPattern(int groupOffset)
    {
        return "(?:\\{\\[([^:=]*[^=]*)\\]\\})"; //$NON-NLS-1$
    }

    @Override
    protected int getPatternGroupCount()
    {
        return 1;
    }

    @Override
    protected PatternBasedElementProcessor newProcessor()
    {
        return new TransclusionReplacementTokenProcessor();
    }

    private static class TransclusionReplacementTokenProcessor extends PatternBasedElementProcessor
    {
        @Override
        public void emit()
        {
            builder.beginSpan(
                DocumentBuilder.SpanType.SPAN,
                new Attributes(null, "transclusion", null, null)
            );

            builder.charactersUnescaped(group(1));

            builder.endSpan();
        }
    }
}
