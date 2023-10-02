package ru.gavrilovds.moscowclubs.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.geo.Shape;
import ru.gavrilovds.moscowclubs.model.Club;

import java.util.Date;

@Entity
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private String date;
    private String url;
    private String imageUrl;
    @ManyToOne
    private ClubEntity club;

    public EventEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ClubEntity getClub() {
        return club;
    }

    public void setClub(ClubEntity club) {
        this.club = club;
    }
}
