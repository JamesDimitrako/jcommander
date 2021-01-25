package com.beust.jcommander.ConverterProcessors;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.IStringConverterInstanceFactory;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameterized;

import java.util.List;

public interface ΙConvertMiddleware {
    public ConvertMiddleware linkWith(ConvertMiddleware next);
    public abstract IStringConverter process(final Parameterized parameterized, Class type, String optionName, String value, final Parameter annotation, List<IStringConverterInstanceFactory> options);

    }
