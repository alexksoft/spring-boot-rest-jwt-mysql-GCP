package com.ak.eventapi.db.domain.mapper;

import org.mapstruct.Mapper;

import com.ak.eventapi.db.domain.EventEntity;
import com.ak.eventapi.dto.EventDTO;

@Mapper
public interface EntEventMapper {
	EventDTO enttoDTO(EventEntity event);
}
