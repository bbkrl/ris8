package com.example.springrest1.service;

import com.example.springrest1.model.User;
import com.example.springrest1.model.UserDTO;
import com.example.springrest1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(UserDTO userDTO) {
        User user = User.builder()
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .age(userDTO.getAge())
                .build();
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findUserById(id);
        optionalUser.ifPresent(userRepository::delete);
    }

    public void updateUser(UserDTO userDTO, Long id) {
        User user = User.builder()
                .id(id)
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .age(userDTO.getAge())
                .build();
        userRepository.save(user);
    }
}
