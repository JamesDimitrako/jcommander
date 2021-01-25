package com.beust.jcommander.ConverterProcessors;

import com.beust.jcommander.*;
import com.beust.jcommander.converters.DefaultListConverter;
import com.beust.jcommander.converters.IParameterSplitter;
import java.lang.reflect.Type;
import java.util.List;

import static com.beust.jcommander.InstanceConverterHelper.tryInstantiateConverter;

public class ConverterNoList extends ConvertMiddleware {
    // No list converter: use the single value converter and pass each parsed value to it individually
    @Override
    public IStringConverter process(Parameterized parameterized, Class type, String optionName, String value, Parameter annotation,
                                    List<IStringConverterInstanceFactory> options) {

        if (type.isAssignableFrom(List.class)) {
            final IParameterSplitter splitter = tryInstantiateConverter(null, annotation.splitter());
            return new DefaultListConverter(splitter, new IStringConverter() {
                @Override
                public Object convert(String value) {
                    final Type genericType = parameterized.findFieldGenericType();
                    return new JCommander().convertValue(parameterized, genericType instanceof Class ? (Class) genericType : String.class, null, value);
                }
            });
        }

        return processNext(parameterized, type, optionName, value, annotation, options);
    }
}
