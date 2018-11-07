package com.cbse.realizator.impl;

import com.cbse.exceptions.ComponentRealizationException;
import com.cbse.exceptions.InstantiationException;
import com.cbse.global.GlobalContext;
import com.cbse.model.Attribute;
import com.cbse.model.Component;
import com.cbse.model.ReferenceValue;
import com.cbse.realizator.api.ComponentRealizator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComponentRealizatorImpl implements ComponentRealizator
{
    @Override
    public <T> T resolveComponent(Component component, GlobalContext context) throws ComponentRealizationException {
        String className = component.getType();
        try {
            Class<?> klz = Class.forName(className);
            T instance = (T) klz.newInstance();
            Map<String, Object> arguments = new HashMap<>();
            for(Attribute att : component.getAttributes()) {
                Object value = null;
                if(isRef(att)) {
                    String attValue = (String) att.getValue().getValue();
                    for(Component cmp : context.getSolvedComponents().keySet()) {
                        if(cmp.getId().equals(attValue)) {
                            value = context.getSolvedComponents().get(cmp);
                            break;
                        }
                    }
                    if(value == null) {
                        Component ref = context.getComponent(attValue);
                        value = resolveComponent(ref, context);
                    }
                } else {
                    value = att.getValue().getValue();
                }
                arguments.put(att.getId(), value);
            }
            setFields(instance, arguments);
            return instance;
        } catch (ClassNotFoundException| java.lang.InstantiationException|IllegalAccessException|NoSuchFieldException e) {
            throw new InstantiationException(e);
        }
    }

    public <T> void setFields(T object, Map<String, Object> arguments) throws NoSuchFieldException, IllegalAccessException
    {
        for(String field : arguments.keySet()) {
            Field declaredField = object.getClass().getDeclaredField(field);
            boolean accessible = declaredField.isAccessible();
            declaredField.setAccessible(true);

            Class<?> type = declaredField.getType();
            Object value = toActualType(type, arguments.get(field));

            declaredField.set(object, value);

            declaredField.setAccessible(accessible);
        }
    }

    public Object toActualType( Class clazz, Object value ) {
        if( Boolean.class == clazz || Boolean.TYPE == clazz ) return Boolean.parseBoolean( (String)value );
        else if( Byte.class == clazz || Byte.TYPE == clazz ) return Byte.parseByte( (String)value );
        else if( Short.class == clazz || Short.TYPE == clazz ) return Short.parseShort( (String)value );
        else if( Integer.class == clazz || Integer.TYPE == clazz ) return Integer.parseInt( (String)value );
        else if( Long.class == clazz || Long.TYPE == clazz ) return Long.parseLong( (String)value );
        else if( Float.class == clazz || Float.TYPE == clazz ) return Float.parseFloat( (String)value );
        else if( Double.class == clazz || Double.TYPE == clazz ) return Double.parseDouble( (String)value );
        return value;
    }

    public boolean isRef(Attribute attribute)
    {
        if(attribute.getValue() instanceof ReferenceValue)
            return true;

        return false;
    }

}
