package ru.gavrilovds.moscowclubs.model;

import ru.gavrilovds.moscowclubs.entity.CommentEntity;
import ru.gavrilovds.moscowclubs.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String email;
    private String name;
    private String token;
    private List<Comment> comments;
    private List<Club> favouriteClubs;
    private boolean isAdmin = false;
    private String adminClubName;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setEmail(entity.getEmail());
        model.setName(entity.getName());
        model.setToken(entity.getToken());
        model.setAdmin(entity.isAdmin());
        model.setAdminClubName(entity.getAdminClubName());
        if (entity.getFavouriteClubs() != null)
            model.setFavouriteClubs(entity.getFavouriteClubs().stream().map(Club::toModel).collect(Collectors.toList()));
        if (entity.getComments() != null)
            model.setComments(entity.getComments().stream().map(Comment::toModel).collect(Collectors.toList()));
        return model;
    }


    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Club> getFavouriteClubs() {
        return favouriteClubs;
    }

    public void setFavouriteClubs(List<Club> favouriteClubs) {
        this.favouriteClubs = favouriteClubs;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getAdminClubName() {
        return adminClubName;
    }

    public void setAdminClubName(String adminClubName) {
        this.adminClubName = adminClubName;
    }
}
