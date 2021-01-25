package com.beust.jcommander.ConverterProcessors;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.IStringConverterInstanceFactory;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameterized;
import com.beust.jcommander.converters.EnumConverter;

import java.util.List;

public class ConvertEnum extends ConvertMiddleware{
    @Override
    public IStringConverter process(Parameterized parameterized, Class type, String optionName, String value,
                                    Parameter annotation, List<IStringConverterInstanceFactory> options) {
        IStringConverter<?> converter = null;
        converter = new EnumConverter(optionName, type);

        return converter != null ? converter :  processNext(parameterized, type,
                optionName, value, annotation, options);
    }
}
