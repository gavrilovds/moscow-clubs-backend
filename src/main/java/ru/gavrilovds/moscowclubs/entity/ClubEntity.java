package ru.gavrilovds.moscowclubs.entity;


import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
public class ClubEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String address;
    private String closestUnderground;
    private String workTime;
    private String webSite;
    private String phoneNumber;
    private Long peopleAmount;
    private Long meanPrice;
    private Double latitude;
    private Double longitude;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<UserEntity> users;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "club")
    private List<ClubImagesEntity> clubImages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "club")
    private List<CommentEntity> clubComments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "club")
    private List<EventEntity> clubEvents;

    public List<CommentEntity> getClubComments() {
        return clubComments;
    }

    public void setClubComments(List<CommentEntity> clubComments) {
        this.clubComments = clubComments;
    }

    public ClubEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ClubImagesEntity> getClubImages() {
        return clubImages;
    }

    public void setClubImages(List<ClubImagesEntity> clubImages) {
        this.clubImages = clubImages;
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

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public List<EventEntity> getClubEvents() {
        return clubEvents;
    }

    public void setClubEvents(List<EventEntity> clubEvents) {
        this.clubEvents = clubEvents;
    }
}
