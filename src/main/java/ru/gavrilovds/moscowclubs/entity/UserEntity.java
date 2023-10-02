package ru.gavrilovds.moscowclubs.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String token;
    private String name;

    private boolean isAdmin = false;
    private String adminClubName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<CommentEntity> comments;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<ClubEntity> favouriteClubs;

    public UserEntity() {
    }



    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<ClubEntity> getFavouriteClubs() {
        return favouriteClubs;
    }

    public void setFavouriteClubs(List<ClubEntity> favouriteClubs) {
        this.favouriteClubs = favouriteClubs;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    public String getAdminClubName() {
        return adminClubName;
    }

    public void setAdminClubName(String adminClubName) {
        this.adminClubName = adminClubName;
    }
}
