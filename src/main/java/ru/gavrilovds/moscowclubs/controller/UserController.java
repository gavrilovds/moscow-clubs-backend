package ru.gavrilovds.moscowclubs.controller;

import ru.gavrilovds.moscowclubs.entity.UserEntity;
import ru.gavrilovds.moscowclubs.exception.*;
import ru.gavrilovds.moscowclubs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {

        try {
            userService.registration(user);
            return ResponseEntity.ok(user.getToken());
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/sign-in")
    public ResponseEntity signIn(@RequestParam String email, @RequestParam String password) {
        try {
            return ResponseEntity.ok(userService.signIn(email, password));
        } catch (WrongPasswordException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoUserWithSuchEmailException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getUser(@RequestParam String token) {
        try {
            return ResponseEntity.ok(userService.getUser(token));
        } catch (NoUserWithSuchEmailException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error.");
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity deleteUser(@PathVariable String email) {
        try {
            return ResponseEntity.ok(userService.removeUser(email));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/favourites")
    public ResponseEntity addClubToFavourites(@RequestParam String token, @RequestParam String clubName) {
        try {
            userService.addClubToFavourites(token, clubName);
            return ResponseEntity.ok("Club " + clubName + " is added to favourites");
        } catch (NoClubWithSuchNameException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoUserWithSuchEmailException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/favourites")
    public ResponseEntity deleteClubFromFavourites(@RequestParam String token, @RequestParam String clubName) {
        try {
            userService.deleteClubFromFavourites(token, clubName);
            return ResponseEntity.ok("Club " + clubName + "has been deleted from favourites");
        } catch (NoUserWithSuchEmailException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoClubWithSuchNameException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/set-admin")
    public ResponseEntity setAdmin(@RequestParam String token, @RequestParam String clubName) {
        try {
            userService.setAdmin(token, clubName);
            return ResponseEntity.ok("User with token " + token + " is now admin of club " + clubName);
        } catch (NoUserWithSuchTokenException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/change-name")
    public ResponseEntity changeName(@RequestParam String token, @RequestParam String newName){
        try{
            userService.changeName(token, newName);
            return ResponseEntity.ok("Name has changed to " + newName);
        }
        catch (NoUserWithSuchTokenException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
