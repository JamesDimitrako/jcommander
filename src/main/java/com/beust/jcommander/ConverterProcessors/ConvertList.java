package com.beust.jcommander.ConverterProcessors;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.IStringConverterInstanceFactory;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameterized;

import java.util.List;

import static com.beust.jcommander.InstanceConverterHelper.tryInstantiateConverter;


public class ConvertList extends ConvertMiddleware {
    // If a list converter was specified, pass the value to it for direct conversion
    @Override
    public IStringConverter process(Parameterized parameterized, Class type, String optionName, String value, Parameter annotation,
                                    List<IStringConverterInstanceFactory> options) {
        IStringConverter<?> converter = null;

        if (type.isAssignableFrom(List.class))
            converter = tryInstantiateConverter(optionName, annotation.listConverter());

        if (converter != null)
            return converter;

        return processNext(parameterized, type, optionName, value, annotation, options);
    }
}
