package com.beust.jcommander.ConverterProcessors;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.IStringConverterInstanceFactory;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameterized;

import java.util.List;

import static com.beust.jcommander.InstanceConverterHelper.findConverterInstance;

public class ConvertFindInstance extends ConvertMiddleware{
    @Override
    public IStringConverter process(Parameterized parameterized, Class type, String optionName, String value, Parameter annotation, List<IStringConverterInstanceFactory> options) {
        return findConverterInstance(annotation, type, optionName, options) != null ? findConverterInstance(annotation, type, optionName, options) :  processNext(parameterized, type, optionName, value, annotation, options);
    }
}
