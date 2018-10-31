package com.cbse.realizator.impl;

import com.cbse.exceptions.InstantiationException;
import com.cbse.exceptions.NoMatchingConstructorException;
import com.cbse.realizator.api.FreakyClassInstantiator;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class FreakyClassInstantiatorImpl implements FreakyClassInstantiator
{
    @Override
    public <T> T instantiateClass(Class<T> kls, Map<Class<?>, Object> arguments) throws InstantiationException {
        Class<?> argTypes[] = arguments.keySet().toArray(new Class<?>[arguments.keySet().size()]);
        try {
            return kls.getDeclaredConstructor(argTypes).newInstance(arguments.values());
        } catch (NoSuchMethodException e) {
            throw new NoMatchingConstructorException(e);
        } catch (IllegalAccessException| InvocationTargetException| java.lang.InstantiationException e) {
            throw new InstantiationException(e);
        }
    }
}
