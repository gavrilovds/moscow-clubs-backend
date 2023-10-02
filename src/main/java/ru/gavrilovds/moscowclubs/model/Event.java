package ru.gavrilovds.moscowclubs.model;

import ru.gavrilovds.moscowclubs.entity.EventEntity;

import java.util.Date;

public class Event {
    private String eventName;
    private String date;
    private String url;
    private String imageUrl;
    private String clubName;

    public Event() {
    }

    public static Event toModel(EventEntity entity){
        Event model = new Event();
        model.setClubName(entity.getClub().getName());
        model.setDate(entity.getDate());
        model.setUrl(entity.getUrl());
        model.setImageUrl(entity.getImageUrl());
        model.setEventName(entity.getEventName());
        return model;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
