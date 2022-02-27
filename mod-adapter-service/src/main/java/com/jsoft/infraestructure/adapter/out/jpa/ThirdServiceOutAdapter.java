package com.jsoft.infraestructure.adapter.out.jpa;

import com.jsoft.domain.dto.MessageDTO;
import com.jsoft.domain.dto.QueryMessageDTO;
import com.jsoft.domain.port.out.OutPortToService;
import com.jsoft.common.annotation.ApplicationService;

@ApplicationService
public class ThirdServiceOutAdapter implements OutPortToService {

    @Override
    public MessageDTO getMessageToCore(QueryMessageDTO queryMessageDTO) {

        return MessageDTO.builder()
                .message("Message from third service via http connection")
                .build();
    }
}
