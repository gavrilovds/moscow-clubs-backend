package ru.gavrilovds.moscowclubs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gavrilovds.moscowclubs.entity.CommentEntity;
import ru.gavrilovds.moscowclubs.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity addComment(@RequestParam String text,
                                     @RequestParam String token,
                                     @RequestParam String clubName){
        try{
            commentService.addComment(text, token, clubName);
            return ResponseEntity.ok("Comment is added");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity deleteComment(@RequestParam Long id){
        try{
            commentService.deleteComment(id);
            return ResponseEntity.ok("Comment has been deleted");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
