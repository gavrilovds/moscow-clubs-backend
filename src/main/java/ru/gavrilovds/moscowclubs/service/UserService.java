package ru.gavrilovds.moscowclubs.service;


import org.apache.commons.codec.digest.DigestUtils;
import ru.gavrilovds.moscowclubs.entity.ClubEntity;
import ru.gavrilovds.moscowclubs.entity.UserEntity;
import ru.gavrilovds.moscowclubs.exception.*;
import ru.gavrilovds.moscowclubs.model.User;
import ru.gavrilovds.moscowclubs.repository.ClubRepository;
import ru.gavrilovds.moscowclubs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClubRepository clubRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException("User already exists.");
        }
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        user.setToken(DigestUtils.md5Hex(String.valueOf(user.getPassword().hashCode() + user.getEmail().hashCode())));
        return userRepository.save(user);
    }

    public User getUser(String token) throws NoUserWithSuchEmailException {
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            throw new NoUserWithSuchEmailException("No user with such token.");
        }
        return User.toModel(user);
    }

    public String removeUser(String email) throws NoUserWithSuchEmailException {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new NoUserWithSuchEmailException("No user with such email.");
        }
        userRepository.delete(user);
        return email;
    }

    public String getUserToken(String email) throws NoUserWithSuchEmailException {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new NoUserWithSuchEmailException("No user with such email.");
        }
        return user.getToken();
    }

    public void addClubToFavourites(String token, String clubName) throws NoUserWithSuchEmailException, NoClubWithSuchNameException {
        UserEntity user = userRepository.findByToken(token);
        if (user == null) {
            throw new NoUserWithSuchEmailException("No user with such email.");
        }
        ClubEntity club = clubRepository.findByName(clubName);
        if (club == null) {
            throw new NoClubWithSuchNameException("No club with such name.");
        }
        List<ClubEntity> favouriteClubs = user.getFavouriteClubs();
        List<UserEntity> userEntities = club.getUsers();
        favouriteClubs.add(club);
        user.setFavouriteClubs(favouriteClubs);
        userEntities.add(user);
        club.setUsers(userEntities);
        clubRepository.save(club);
        userRepository.save(user);
    }

    public void deleteClubFromFavourites(String token, String clubName) throws NoUserWithSuchEmailException, NoClubWithSuchNameException {
        UserEntity user = userRepository.findByToken(token);
        if (user == null)
            throw new NoUserWithSuchEmailException("No user with such email.");
        ClubEntity club = clubRepository.findByName(clubName);
        if (club == null)
            throw new NoClubWithSuchNameException("No club with such name.");
        user.setFavouriteClubs(user.getFavouriteClubs().stream().filter(clubEntity -> !clubEntity.getName().equals(clubName)).collect(Collectors.toList()));
        club.setUsers(club.getUsers().stream().filter(userEntity -> !userEntity.getToken().equals(token)).collect(Collectors.toList()));
        clubRepository.save(club);
        userRepository.save(user);
    }

    public String signIn(String email, String password) throws NoUserWithSuchEmailException, WrongPasswordException {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null)
            throw new NoUserWithSuchEmailException("No user with such email.");
        if (!user.getPassword().equals(DigestUtils.md5Hex(password)))
            throw new WrongPasswordException("Wrong password");
        return user.getToken();
    }

    public void setAdmin(String token, String clubName) throws NoUserWithSuchTokenException {
        UserEntity user = userRepository.findByToken(token);
        if (user == null)
            throw new NoUserWithSuchTokenException("No user with such token");
        user.setAdmin(true);
        user.setAdminClubName(clubName);
        userRepository.save(user);
    }

    public void changeName(String token, String newName) throws NoUserWithSuchTokenException {
        UserEntity user = userRepository.findByToken(token);
        if (user == null)
            throw new NoUserWithSuchTokenException("No user with such token");
        user.setName(newName);
        userRepository.save(user);
    }

}
