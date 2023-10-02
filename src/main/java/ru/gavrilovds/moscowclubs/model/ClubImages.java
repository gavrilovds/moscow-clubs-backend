package ru.gavrilovds.moscowclubs.model;

import ru.gavrilovds.moscowclubs.entity.ClubImagesEntity;

public class ClubImages {

    private String url;

    public ClubImages() {
    }

    public static ClubImages toModel(ClubImagesEntity entity) {
        ClubImages model = new ClubImages();
        model.setUrl(entity.getUrl());
        return model;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
