package com.jsoft.application.service;

import com.jsoft.common.annotation.ApplicationService;
import com.jsoft.domain.aggregate.AggregateTemplate;
import com.jsoft.domain.dto.MessageDTO;
import com.jsoft.domain.dto.QueryMessageDTO;
import com.jsoft.domain.port.in.InPortUseCase;

@ApplicationService
public class InPortService implements InPortUseCase {

    private final AggregateTemplate aggregateTemplate;

    public InPortService(AggregateTemplate aggregateTemplate) {

        this.aggregateTemplate = aggregateTemplate;
    }

    @Override
    public MessageDTO sendMessageToCore(QueryMessageDTO queryMessageDTO) {

        return aggregateTemplate.getMessageById(queryMessageDTO);
    }
}
