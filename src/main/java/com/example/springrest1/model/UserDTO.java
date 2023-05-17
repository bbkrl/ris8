package com.example.springrest1.model;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserDTO {
    @NotEmpty(message = "Enter name!")
    private String name;

    @NotEmpty(message = "Enter surname!")
    private String surname;

    @NotNull(message = "Enter age!")
    private int age;
}
