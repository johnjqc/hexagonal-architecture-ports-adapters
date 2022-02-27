package com.jsoft.common.exception;

public abstract class AbstractDomainException extends RuntimeException {

    private static final long serialVersionUID = -2158099659916632057L;

    /**
     * Constructs a new runtime exception.
     */
    public AbstractDomainException(String message) {

        super(message);
    }

    /**
     * Constructs a new runtime exception.
     *
     * @param message the message exception
     * @param cause the root cause
     */
    public AbstractDomainException(String message, Throwable cause) {

        super(message, cause);
    }

    /**
     * Gets the associated {@link ResponseCode}.
     *
     * @return the associated {@link ResponseCode}.
     */
    public abstract ResponseCode getApiResponseCode();

}
