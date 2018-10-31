package com.cbse.exceptions;

public class InstantiationException extends ComponentRealizationException
{
    /**
     * Default constructor.
     */
    public InstantiationException()
    {
        super();
    }


    /**
     * Initialisation constructor.
     *
     * @param message the message
     */
    public InstantiationException(final String message)
    {
        super(message);
    }


    /**
     * Initialisation constructor.
     *
     * @param message the message
     * @param cause the cause
     */
    public InstantiationException(final String message, final Throwable cause)
    {
        super(message, cause);
    }


    /**
     * Initialisation constructor.
     *
     * @param cause the cause
     */
    public InstantiationException(final Throwable cause)
    {
        super(cause);
    }
}
