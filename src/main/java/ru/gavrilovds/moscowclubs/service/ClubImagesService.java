package ru.gavrilovds.moscowclubs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.gavrilovds.moscowclubs.entity.ClubEntity;
import ru.gavrilovds.moscowclubs.entity.ClubImagesEntity;
import ru.gavrilovds.moscowclubs.exception.EmptyFileException;
import ru.gavrilovds.moscowclubs.exception.NoClubWithSuchNameException;
import ru.gavrilovds.moscowclubs.repository.ClubImagesRepository;
import ru.gavrilovds.moscowclubs.repository.ClubRepository;

import java.io.IOException;

@Service
public class ClubImagesService {
    @Autowired
    private ClubImagesRepository clubImagesRepository;
    @Autowired
    private ClubRepository clubRepository;

    public String addClubImage(String clubName, String url) throws NoClubWithSuchNameException, EmptyFileException, IOException {
        ClubEntity club = clubRepository.findByName(clubName);
        if (club==null){
            throw new NoClubWithSuchNameException("No club with such name.");
        }
        ClubImagesEntity clubImagesEntity = new ClubImagesEntity();
        clubImagesEntity.setUrl(url);
        clubImagesEntity.setClub(club);
        clubImagesRepository.save(clubImagesEntity);
        return String.format("Image is added to club %s", clubName);
    }

}
