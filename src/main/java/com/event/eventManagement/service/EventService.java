package com.event.eventManagement.service;

import com.event.eventManagement.entity.Event;

import java.util.List;

public interface EventService {
    Event create(Event event);

    List<Event> getAllEvent();

    Event getEventById(Long id);

    Event updateEvent(Event event,Long id);

    void deleteEvent(Long id);

}
