package com.jsoft.domain.exception;

import com.jsoft.common.exception.ResponseCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DomainResponseCode implements ResponseCode {

    SUCCESS("SCS-00", "Success"),

    ERROR("ERR-01", "Error on business layer");

    private final String code;

    private final String description;

}