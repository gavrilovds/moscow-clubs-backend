package ru.gavrilovds.moscowclubs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gavrilovds.moscowclubs.entity.ClubEntity;
import ru.gavrilovds.moscowclubs.entity.EventEntity;
import ru.gavrilovds.moscowclubs.exception.ClubAlreadyExistsException;
import ru.gavrilovds.moscowclubs.exception.NoClubWithSuchNameException;
import ru.gavrilovds.moscowclubs.service.ClubService;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @PostMapping
    public ResponseEntity addClub(@RequestBody ClubEntity club) {
        try {
            return ResponseEntity.ok(clubService.addClub(club));
        } catch (ClubAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getClub(@RequestParam String name) {
        try {
            return ResponseEntity.ok(clubService.getClub(name));
        } catch (NoClubWithSuchNameException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity getAllClubs() {
        try {
            return ResponseEntity.ok(clubService.getAllClubs());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteClub(@PathVariable String name) {
        try {
            return ResponseEntity.ok(clubService.deleteClub(name));
        } catch (NoClubWithSuchNameException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/change-description")
    public ResponseEntity changeDescription(@RequestParam String newDescription,
                                            @RequestParam String clubName) {
        try {
            return ResponseEntity.ok(clubService.changeDescription(newDescription, clubName));
        } catch (NoClubWithSuchNameException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add-event")
    public ResponseEntity addEvent(@RequestParam String clubName, @RequestBody EventEntity entity){
        try {
            clubService.addEvent(clubName, entity);
            return ResponseEntity.ok("Event is added to club " + clubName);
        }
        catch (NoClubWithSuchNameException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
