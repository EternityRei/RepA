package com.example.repa.dto;

import com.example.repa.model.Role;
import com.example.repa.validator.PasswordValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long id;
    @NotBlank
    @Email
    private String email;
    @NotNull
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;
    @PasswordValidation()
    private String password;
    private float money;
    private Role role;
}
