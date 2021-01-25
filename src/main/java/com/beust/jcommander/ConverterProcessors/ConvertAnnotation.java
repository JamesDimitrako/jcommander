package com.beust.jcommander.ConverterProcessors;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.IStringConverterInstanceFactory;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameterized;

import java.util.List;

import static com.beust.jcommander.InstanceConverterHelper.tryInstantiateConverter;

public class ConvertAnnotation extends ConvertMiddleware {
    @Override
    public IStringConverter process(Parameterized parameterized, Class type, String optionName, String value, Parameter annotation, List<IStringConverterInstanceFactory> options) {
        return tryInstantiateConverter(optionName, annotation.converter()) != null ? tryInstantiateConverter(optionName, annotation.converter()) :  processNext(parameterized, type, optionName, value, annotation, options);
    }
}
