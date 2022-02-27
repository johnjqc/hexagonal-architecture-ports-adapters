package com.jsoft.domain.exception;

import com.jsoft.common.exception.AbstractDomainException;
import com.jsoft.common.exception.ResponseCode;

public class BusinessException extends AbstractDomainException {

    public BusinessException(String message) {
        super(message);
    }

    @Override
    public ResponseCode getApiResponseCode() {

        return DomainResponseCode.ERROR;
    }
}
