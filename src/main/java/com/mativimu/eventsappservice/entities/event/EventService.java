package com.mativimu.eventsappservice.entities.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public Event getEventByCode(String code) {
        return eventRepository.findEventByCode(code);
    }
    
    public void deleteEvent(Long id) {
        
    }
}