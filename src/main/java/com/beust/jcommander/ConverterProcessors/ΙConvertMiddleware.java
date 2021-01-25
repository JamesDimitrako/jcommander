package com.beust.jcommander.ConverterProcessors;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.IStringConverterInstanceFactory;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameterized;

import java.util.List;

public interface ΙConvertMiddleware {
     ConvertMiddleware linkWith(ConvertMiddleware next);

     IStringConverter process(final Parameterized parameterized, Class type, String optionName, String value,
                              final Parameter annotation, List<IStringConverterInstanceFactory> options);
}
