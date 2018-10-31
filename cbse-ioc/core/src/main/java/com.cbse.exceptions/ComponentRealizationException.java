package com.cbse.exceptions;

/**
 * General component realization exception.
 */
public class ComponentRealizationException extends Exception
{

    /**
     * Default constructor.
     */
    public ComponentRealizationException()
    {
        super();
    }


    /**
     * Initialisation constructor.
     *
     * @param message the message
     */
    public ComponentRealizationException(final String message)
    {
        super(message);
    }


    /**
     * Initialisation constructor.
     *
     * @param message the message
     * @param cause the cause
     */
    public ComponentRealizationException(final String message, final Throwable cause)
    {
        super(message, cause);
    }


    /**
     * Initialisation constructor.
     *
     * @param cause the cause
     */
    public ComponentRealizationException(final Throwable cause)
    {
        super(cause);
    }
}
