package com.cbse.realizator.api;


import com.cbse.exceptions.InstantiationException;

import java.util.Map;

/**
 * A classloader. Named in honour of DA's FreakyClassLoader
 */
public interface FreakyClassInstantiator
{
    /**
     * Intantiate a class.
     * @param kls
     * @param <T>
     * @return
     */
    <T> T instantiateClass(Class<T> kls, Map<Class<?>, Object> arguments) throws InstantiationException;
}
