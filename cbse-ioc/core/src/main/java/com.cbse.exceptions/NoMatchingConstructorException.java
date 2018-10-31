package com.cbse.exceptions;

public class NoMatchingConstructorException extends InstantiationException
{
    /**
     * Default constructor.
     */
    public NoMatchingConstructorException()
    {
        super();
    }


    /**
     * Initialisation constructor.
     *
     * @param message the message
     */
    public NoMatchingConstructorException(final String message)
    {
        super(message);
    }


    /**
     * Initialisation constructor.
     *
     * @param message the message
     * @param cause the cause
     */
    public NoMatchingConstructorException(final String message, final Throwable cause)
    {
        super(message, cause);
    }


    /**
     * Initialisation constructor.
     *
     * @param cause the cause
     */
    public NoMatchingConstructorException(final Throwable cause)
    {
        super(cause);
    }
}
