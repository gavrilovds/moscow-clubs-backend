package ru.gavrilovds.moscowclubs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.gavrilovds.moscowclubs.entity.ClubImagesEntity;
import ru.gavrilovds.moscowclubs.exception.NoClubWithSuchNameException;
import ru.gavrilovds.moscowclubs.service.ClubImagesService;

@RestController
@RequestMapping("/clubs/images")
public class ClubImagesController {

    @Autowired
    private ClubImagesService clubImagesService;

    @PostMapping
    public ResponseEntity addClubImage(@RequestParam String clubName,
                                       @RequestParam String url){
        try{
            return ResponseEntity.ok(clubImagesService.addClubImage(clubName, url));
        }
        catch (NoClubWithSuchNameException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
