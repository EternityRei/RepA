package com.example.repa.controller;

import com.example.repa.dto.UserDTO;
import com.example.repa.exception.AlreadyCreatedEntityException;
import com.example.repa.exception.EntityNotFoundException;
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
        User user = userService.getUserById(id);
        if (user == null){
            throw new EntityNotFoundException("user was not found");
        }
        return UserMapper.INSTANCE.userToUserDTO(user);
    }

    @GetMapping()
    public List<UserDTO> getAllUsers(){
        log.info("All users");
        return UserMapper.INSTANCE.toUserDTO(userService.getAllUsers());
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        log.info("User creating : " + userDTO);
        User user = userService.getUserById(userDTO.getId());
        if(user != null){
            throw new AlreadyCreatedEntityException("User has already exists");
        }
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
        if(user == null){
            throw new EntityNotFoundException("User has not exists already");
        }
        userService.deleteUser(user);
        log.info("User " + user.getId() + " with name " + user.getName() + " was deleted");
        return UserMapper.INSTANCE.userToUserDTO(user);
    }

}
