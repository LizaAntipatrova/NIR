package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.auth.exceptions.data.ExistingUserWithThatUsernameException;
import com.strongkittens.nirstorage.auth.exceptions.data.UserNotFoundException;
import com.strongkittens.nirstorage.data.entity.Role;
import com.strongkittens.nirstorage.data.entity.User;
import com.strongkittens.nirstorage.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final StudentService studentService;
    private final TeacherService teacherService;

    private User save(User user) {
        return userRepository.save(user);
    }

    public User createUser(String login, String password, Role role) {

        if (userRepository.findUserByLogin(login) != null) {
            throw new ExistingUserWithThatUsernameException();
        }
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);
        if (role.equals(Role.STUDENT)){
            studentService.createEmptyStudent(user);
        }else if(role.equals(Role.TEACHER)){
            teacherService.createEmptyTeacher(user);
        }

        return save(user);
    }

    public User findUserById(long id) {
        return userRepository.findUserById(id);
    }

    public User findUserByLogin(String login) {
        User findUser = userRepository.findUserByLogin(login);
        if (findUser == null) {
            throw new UserNotFoundException();
        }
        return userRepository.findUserByLogin(login);
    }
}
