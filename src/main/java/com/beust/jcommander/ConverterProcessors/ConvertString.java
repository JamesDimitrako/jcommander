package com.beust.jcommander.ConverterProcessors;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.IStringConverterInstanceFactory;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameterized;
import com.beust.jcommander.converters.StringConverter;

import java.util.List;

public class ConvertString extends ConvertMiddleware{
    @Override
    public IStringConverter process(Parameterized parameterized, Class type, String optionName, String value, Parameter annotation, List<IStringConverterInstanceFactory> options) {
        return new StringConverter();
    }
}
