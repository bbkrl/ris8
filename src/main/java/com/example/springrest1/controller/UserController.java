package com.example.springrest1.controller;

import com.example.springrest1.Message;
import com.example.springrest1.model.User;
import com.example.springrest1.model.UserDTO;
import com.example.springrest1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("addUser")
    public ResponseEntity<Message> addUser(@Valid @RequestBody UserDTO userDTO,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new Message(bindingResult.getAllErrors().get(0).getDefaultMessage()));
        } else {
            userService.addUser(userDTO);
            return ResponseEntity.ok(new Message("User successfully added!"));
        }
    }

    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("updateUser/{id}")
    public ResponseEntity<Message> updateUser(@PathVariable("id") Long id,
                                              @Valid @RequestBody UserDTO userDTO,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new Message(bindingResult.getAllErrors().get(0).getDefaultMessage()));
        } else {
            userService.updateUser(userDTO, id);
            return ResponseEntity.ok(new Message("User successfully updated!"));
        }
    }
}

