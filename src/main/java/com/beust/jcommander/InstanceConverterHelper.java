package com.beust.jcommander;

import com.beust.jcommander.converters.NoConverter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public  class InstanceConverterHelper {
    public static <T> T tryInstantiateConverter(String optionName, Class<T> converterClass) {
        if (converterClass == NoConverter.class || converterClass == null) {
            return null;
        }
        try {
            return instantiateConverter(optionName, converterClass);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException ignore) {
            return null;
        }
    }

    public static <T> T instantiateConverter(String optionName, Class<? extends T> converterClass)
            throws InstantiationException, IllegalAccessException,
            InvocationTargetException {
        Constructor<T> ctor = null;
        Constructor<T> stringCtor = null;
        for (Constructor<T> c : (Constructor<T>[]) converterClass.getDeclaredConstructors()) {
            c.setAccessible(true);
            Class<?>[] types = c.getParameterTypes();
            if (types.length == 1 && types[0].equals(String.class)) {
                stringCtor = c;
            } else if (types.length == 0) {
                ctor = c;
            }
        }

        return stringCtor != null
                ? stringCtor.newInstance(optionName)
                : ctor != null
                ? ctor.newInstance()
                : null;
    }

    public static IStringConverter<?> findConverterInstance(Parameter parameter, Class<?> forType, String optionName, List<IStringConverterInstanceFactory> options) {
        for (IStringConverterInstanceFactory f : options) {
            IStringConverter<?> result = f.getConverterInstance(parameter, forType, optionName);
            if (result != null) return result;
        }

        return null;
    }
}
