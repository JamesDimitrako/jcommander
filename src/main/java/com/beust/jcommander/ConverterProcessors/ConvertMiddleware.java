package com.beust.jcommander.ConverterProcessors;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.IStringConverterInstanceFactory;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameterized;

import java.util.List;

public abstract class ConvertMiddleware implements ΙConvertMiddleware {
    private ConvertMiddleware next;

    /**
     * Builds chains of middleware objects.
     */
    public ConvertMiddleware linkWith(ConvertMiddleware next) {
        this.next = next;
        return next;
    }

    /**
     * Subclasses will implement this method with concrete checks.
     */
    public abstract IStringConverter process(final Parameterized parameterized, Class type, String optionName, String value, final Parameter annotation, List<IStringConverterInstanceFactory> options);

    /**
     * Runs check on the next object in chain or ends traversing if we're in
     * last object in chain.
     */
    protected IStringConverter processNext(final Parameterized parameterized, Class type, String optionName, String value, final Parameter annotation,List<IStringConverterInstanceFactory> options) {
        ConvertMiddleware lastMiddleware = this;
        if (next == null)
            return null;
        return next.process(parameterized, type, optionName, value, annotation, options);
    }
}
