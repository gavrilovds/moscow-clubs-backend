package ru.gavrilovds.moscowclubs.model;

import ru.gavrilovds.moscowclubs.entity.CommentEntity;

public class Comment {

    private String text;
    private String owner;
    private String clubName;
    private Long id;
    public Comment() {
    }

    public static Comment toModel(CommentEntity entity){
        Comment model = new Comment();
        model.setText(entity.getText());
        model.setOwner(entity.getUser().getName());
        model.setClubName(entity.getClub().getName());
        model.setId(entity.getId());
        return model;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
