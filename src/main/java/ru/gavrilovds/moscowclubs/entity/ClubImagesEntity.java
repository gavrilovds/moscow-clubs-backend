package ru.gavrilovds.moscowclubs.entity;


import jakarta.persistence.*;

@Entity
public class ClubImagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "club_name")
    private ClubEntity club;

    public ClubImagesEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClubEntity getClub() {
        return club;
    }

    public void setClub(ClubEntity club) {
        this.club = club;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
