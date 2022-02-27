package com.jsoft.infraestructure.adapter.in.rest;

import com.jsoft.domain.dto.MessageDTO;
import com.jsoft.domain.dto.QueryMessageDTO;
import com.jsoft.domain.port.in.InPortUseCase;
import com.jsoft.infraestructure.adapter.in.rest.api.TemplateApi;
import com.jsoft.infraestructure.adapter.in.rest.model.Notification;
import com.jsoft.infraestructure.adapter.in.rest.model.RequetsBodyTemplate;
import com.jsoft.infraestructure.adapter.in.rest.model.ResponseBody;
import com.jsoft.infraestructure.adapter.in.rest.model.ResponseBodyTemplate;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@Validated
@RestController
public class TemplateController implements TemplateApi {

    private final InPortUseCase inPortUseCase;

    @Autowired
    public TemplateController(InPortUseCase inPortUseCase) {

        this.inPortUseCase = inPortUseCase;
    }

    @Override
    public ResponseEntity<ResponseBody> templateExample(
            @ApiParam(required=true )  @Valid @RequestBody RequetsBodyTemplate requetsBodyTemplate
    ) {

        log.info("Incomming request con adapter Rest on infra-estructure layer");

        QueryMessageDTO queryMessageDTO = QueryMessageDTO.builder()
                .id(Long.valueOf(requetsBodyTemplate.getValue()))
                .build();

        MessageDTO messageDTO = inPortUseCase.sendMessageToCore(queryMessageDTO);

        ResponseBodyTemplate responseBody = new ResponseBodyTemplate()
                .value(messageDTO.getMessage());

        Notification notification = new Notification()
                .description("Success response")
                .code("SCS-00");

        ResponseBody apiResponseDF = new ResponseBody()
            .data(responseBody)
            .notification(notification);

        return  ResponseEntity.ok(apiResponseDF);
    }
}
