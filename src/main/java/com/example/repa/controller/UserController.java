package com.example.repa.controller;

import com.example.repa.dto.UserDTO;
import com.example.repa.mapper.UserMapper;
import com.example.repa.model.User;
import com.example.repa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/id={id}")
    public UserDTO getUserById(@PathVariable("id") long id){
        log.info("User " + id);
        return UserMapper.INSTANCE.userToUserDTO(userService.getUserById(id));
    }

    @GetMapping()
    public List<UserDTO> getAllUsers(){
        log.info("All users");
        return UserMapper.INSTANCE.toUserDTO(userService.getAllUsers());
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        log.info("User creating : " + userDTO);
        return UserMapper.INSTANCE.userToUserDTO(userService.createUser(UserMapper.INSTANCE.userDTOtoUser(userDTO)));
    }

    @PutMapping()
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        log.info("User updating : " + userDTO);
        return UserMapper.INSTANCE.userToUserDTO(userService.updateUser(UserMapper.INSTANCE.userDTOtoUser(userDTO)));
    }

    @DeleteMapping("/id={id}")
    public UserDTO deleteUser(@PathVariable("id") long id){
        log.info("User " + id + " deleting");
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        log.info("User " + user.getId() + " with name " + user.getName() + " was deleted");
        return UserMapper.INSTANCE.userToUserDTO(user);
    }

}
