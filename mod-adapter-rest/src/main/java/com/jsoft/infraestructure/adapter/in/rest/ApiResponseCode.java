package com.jsoft.infraestructure.adapter.in.rest;

import com.jsoft.common.exception.ResponseCode;
import com.jsoft.domain.exception.DomainResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
@AllArgsConstructor
public class ApiResponseCode implements ResponseCode {

    static Map<String, HttpStatus> httpStatusMap = new HashMap<>();
    static {
        httpStatusMap.put("SCS-00", HttpStatus.OK);
        httpStatusMap.put("ERR-01", HttpStatus.INTERNAL_SERVER_ERROR);
        httpStatusMap.put("ERR-02", HttpStatus.BAD_REQUEST);
    }

    private final String code;

    private final String description;

    private final HttpStatus httpStatus;

    public static ApiResponseCode of (DomainResponseCode domainResponseCode) {

        Optional<HttpStatus> httpStatus = getHttpStatus(domainResponseCode.getCode());

        return new ApiResponseCode(
            domainResponseCode.getCode(),
            domainResponseCode.getDescription(),
            httpStatus.orElse(HttpStatus.INTERNAL_SERVER_ERROR)
        );
    }

    public static ApiResponseCode of (String errorCode, String description) {

        Optional<HttpStatus> httpStatus = getHttpStatus(errorCode);

        return new ApiResponseCode(
            errorCode,
            description,
            httpStatus.orElse(HttpStatus.INTERNAL_SERVER_ERROR)
        );
    }

    private static Optional<HttpStatus> getHttpStatus(String code) {
        return Optional.ofNullable(httpStatusMap.get(code));
    }
}
