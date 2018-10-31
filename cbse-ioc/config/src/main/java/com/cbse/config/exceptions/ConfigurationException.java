package com.cbse.config.exceptions;

public class ConfigurationException extends Exception {
    /**
     * Default constructor.
     */
    public ConfigurationException()
    {
        super();
    }


    /**
     * Initialisation constructor.
     *
     * @param message the message
     */
    public ConfigurationException(final String message)
    {
        super(message);
    }


    /**
     * Initialisation constructor.
     *
     * @param message the message
     * @param cause the cause
     */
    public ConfigurationException(final String message, final Throwable cause)
    {
        super(message, cause);
    }


    /**
     * Initialisation constructor.
     *
     * @param cause the cause
     */
    public ConfigurationException(final Throwable cause)
    {
        super(cause);
    }
}
