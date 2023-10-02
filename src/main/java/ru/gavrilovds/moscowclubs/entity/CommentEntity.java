package ru.gavrilovds.moscowclubs.entity;


import jakarta.persistence.*;

@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne
    @JoinColumn(name="user_email")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="club_name")
    private ClubEntity club;

    public ClubEntity getClub() {
        return club;
    }

    public void setClub(ClubEntity club) {
        this.club = club;
    }

    public CommentEntity() {
    }

    public String getText() {
        return text;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
