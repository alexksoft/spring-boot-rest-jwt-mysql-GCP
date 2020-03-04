package com.ak.eventapi.service;

import java.util.List;

import com.ak.eventapi.dto.EventDTO;

public interface EventService
{
    List<EventDTO> getEventList();
}
