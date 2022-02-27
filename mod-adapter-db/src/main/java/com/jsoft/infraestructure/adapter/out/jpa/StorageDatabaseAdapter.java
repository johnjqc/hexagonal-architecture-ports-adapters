package com.jsoft.infraestructure.adapter.out.jpa;

import com.jsoft.domain.dto.MessageDTO;
import com.jsoft.domain.dto.QueryMessageDTO;
import com.jsoft.domain.port.out.OutPortToStorage;
import com.jsoft.infraestructure.adapter.out.jpa.entity.MessageJpaEntity;
import com.jsoft.infraestructure.adapter.out.jpa.repository.MessageJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StorageDatabaseAdapter implements OutPortToStorage {

    private final MessageJpaRepository messageJpaRepository;

    public StorageDatabaseAdapter(MessageJpaRepository messageJpaRepository) {

        this.messageJpaRepository = messageJpaRepository;
    }

    @Override
    public MessageDTO getMessageToCore(QueryMessageDTO queryMessage) {

        log.info("Output Adapter given message: {}", queryMessage.getId());

        MessageJpaEntity messageJpaEntity = messageJpaRepository.getOne(queryMessage.getId());

        return MessageDTO.builder()
                .message(messageJpaEntity.getMessage())
                .build();
    }
}
