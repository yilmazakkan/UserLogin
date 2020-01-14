package com.yilmazakkan.UserAccount.controller;

import com.yilmazakkan.UserAccount.dto.UserDTO;
import com.yilmazakkan.UserAccount.service.impl.UserServiceImpl;
import com.yilmazakkan.UserAccount.util.ControllerPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(ControllerPaths.UserCtrl.CTRL)
@CrossOrigin
public class UserController {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> data = userServiceImpl.getAll();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable(value = "id", required = true) Long id) {
        UserDTO user = userServiceImpl.getById(id);
        return ResponseEntity.ok(user);
    }

}
