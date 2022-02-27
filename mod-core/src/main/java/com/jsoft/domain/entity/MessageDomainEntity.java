package com.jsoft.domain.entity;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MessageDomainEntity {

    private Long id;

    private String message;
}
