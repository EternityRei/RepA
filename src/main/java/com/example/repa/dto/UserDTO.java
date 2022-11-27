package com.example.repa.dto;

import com.example.repa.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long id;
    private String email;
    private String name;
    private String password;
    private float money;
    private Role role;
}
