package com.jsoft.domain.port.in;

import com.jsoft.domain.dto.MessageDTO;
import com.jsoft.domain.dto.QueryMessageDTO;

public interface InPortUseCase {

    MessageDTO sendMessageToCore(QueryMessageDTO queryMessageDTO);
}
