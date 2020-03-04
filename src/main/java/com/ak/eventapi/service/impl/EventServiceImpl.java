package com.ak.eventapi.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak.eventapi.dao.EventDao;
import com.ak.eventapi.db.domain.EventEntity;
import com.ak.eventapi.dto.EventDTO;
import com.ak.eventapi.service.EventService;

@Service
public class EventServiceImpl implements EventService {
    
	@Autowired
    EventDao eventDao;
    
    @Transactional(readOnly = true)
    @Override
	public List<EventDTO> getEventList() {
        final List<EventDTO> eventDataList = new LinkedList<EventDTO>();
        final List<EventEntity> entEventList = this.eventDao.getEventList();
        for (final EventEntity entEvent : entEventList) {
            eventDataList.add(entEvent.getAsDto());
        }
        return eventDataList;
	}

}
