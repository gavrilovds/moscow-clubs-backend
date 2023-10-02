package ru.gavrilovds.moscowclubs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gavrilovds.moscowclubs.entity.ClubEntity;
import ru.gavrilovds.moscowclubs.entity.CommentEntity;
import ru.gavrilovds.moscowclubs.entity.UserEntity;
import ru.gavrilovds.moscowclubs.model.Comment;
import ru.gavrilovds.moscowclubs.repository.ClubRepository;
import ru.gavrilovds.moscowclubs.repository.CommentRepository;
import ru.gavrilovds.moscowclubs.repository.UserRepository;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClubRepository clubRepository;

    public void addComment(String text, String token, String clubName){
        UserEntity user = userRepository.findByToken(token);
        ClubEntity club = clubRepository.findByName(clubName);
        CommentEntity comment = new CommentEntity();
        comment.setText(text);
        comment.setUser(user);
        comment.setClub(club);
        List<CommentEntity> clubComments = club.getClubComments();
        clubComments.add(comment);
        List<CommentEntity> userComments = user.getComments();
        userComments.add(comment);
        commentRepository.save(comment);
    }

    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }
}
