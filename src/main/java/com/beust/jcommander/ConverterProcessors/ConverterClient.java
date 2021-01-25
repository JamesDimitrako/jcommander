package com.beust.jcommander.ConverterProcessors;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.IStringConverterInstanceFactory;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameterized;

import java.util.List;

public class ConverterClient {
    private ConvertMiddleware middleware;

    public void setMiddleware(ConvertMiddleware middleware) {
        this.middleware = middleware;
    }

    public IStringConverter convert(final Parameterized parameterized, Class type,
                                    String optionName, String value, final Parameter annotation, List<IStringConverterInstanceFactory> options) {
        return middleware.process(parameterized, type, optionName, value, annotation, options);
    }

}
