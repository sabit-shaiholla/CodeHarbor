package com.epam.rd.autocode.observer.git;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class GitWebHook implements WebHook {
    private String branch;
    private Event.Type type;
    private List<Event> events = new CopyOnWriteArrayList<>();

    public GitWebHook(String branch, Event.Type type) {
        this.branch = branch;
        this.type = type;
    }

    @Override
    public String branch() {
        return branch;
    }

    @Override
    public Event.Type type() {
        return type;
    }

    @Override
    public List<Event> caughtEvents() {
        return events.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public void onEvent(Event event) {
        events.add(event);
    }

    @Override
    public String toString() {
        return events.toString();
    }
}
