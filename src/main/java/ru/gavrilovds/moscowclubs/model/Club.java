package ru.gavrilovds.moscowclubs.model;

import ru.gavrilovds.moscowclubs.entity.ClubEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Club {
    private String name;
    private String description;

    private List<Comment> comments;
    private List<ClubImages> images;
    private List<Event> events;

    private Double latitude;
    private Double longitude;
    private String address;
    private String closestUnderground;
    private String workTime;
    private Long peopleAmount;
    private Long meanPrice;
    private String webSite;
    private String phoneNumber;


    public Club() {
    }

    public static Club toModel(ClubEntity entity) {
        Club model = new Club();
        model.setDescription(entity.getDescription());
        model.setName(entity.getName());
        model.setLatitude(entity.getLatitude());
        model.setLongitude(entity.getLongitude());
        model.setAddress(entity.getAddress());
        model.setClosestUnderground(entity.getClosestUnderground());
        model.setMeanPrice(entity.getMeanPrice());
        model.setWorkTime(entity.getWorkTime());
        model.setWebSite(entity.getWebSite());
        model.setPhoneNumber(entity.getPhoneNumber());
        model.setPeopleAmount(entity.getPeopleAmount());
        if (entity.getClubComments() != null)
            model.setComments(entity.getClubComments().stream().map(Comment::toModel).collect(Collectors.toList()));
        if (entity.getClubImages() != null)
            model.setImages(entity.getClubImages().stream().map(ClubImages::toModel).collect(Collectors.toList()));
        if (entity.getClubEvents() != null)
            model.setEvents(entity.getClubEvents().stream().map(Event::toModel).collect(Collectors.toList()));
        return model;
    }

    public List<ClubImages> getImages() {
        return images;
    }

    public void setImages(List<ClubImages> images) {
        this.images = images;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClosestUnderground() {
        return closestUnderground;
    }

    public void setClosestUnderground(String closestUnderground) {
        this.closestUnderground = closestUnderground;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public Long getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(Long peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public Long getMeanPrice() {
        return meanPrice;
    }

    public void setMeanPrice(Long meanPrice) {
        this.meanPrice = meanPrice;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
