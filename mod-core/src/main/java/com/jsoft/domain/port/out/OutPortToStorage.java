package com.jsoft.domain.port.out;

import com.jsoft.domain.dto.MessageDTO;
import com.jsoft.domain.dto.QueryMessageDTO;

public interface OutPortToStorage {

    MessageDTO getMessageToCore(QueryMessageDTO queryMessageDTO);
}
