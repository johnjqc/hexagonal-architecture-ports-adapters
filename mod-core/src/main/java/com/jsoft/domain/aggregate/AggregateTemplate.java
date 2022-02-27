package com.jsoft.domain.aggregate;

import com.jsoft.common.annotation.Aggregate;
import com.jsoft.domain.dto.MessageDTO;
import com.jsoft.domain.dto.QueryMessageDTO;
import com.jsoft.domain.port.out.OutPortToService;
import com.jsoft.domain.port.out.OutPortToStorage;

import java.util.logging.Logger;

@Aggregate
public final class AggregateTemplate {

    private final static Logger LOGGER = Logger.getLogger(AggregateTemplate.class.getName());

    private final OutPortToStorage outPortToDB;

    private final OutPortToService outPortToService;

    public AggregateTemplate(OutPortToStorage outPortToDB, OutPortToService outPortToService) {

        this.outPortToDB = outPortToDB;
        this.outPortToService = outPortToService;
    }


    public MessageDTO getMessageById(QueryMessageDTO queryMessageDTO) {

        LOGGER.info(String.format("Query from third service: %s", outPortToService.getMessageToCore(queryMessageDTO)));



        return outPortToDB.getMessageToCore(queryMessageDTO);
    }
}
