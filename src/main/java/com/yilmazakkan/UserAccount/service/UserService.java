package com.yilmazakkan.UserAccount.service;

import com.yilmazakkan.UserAccount.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO save(UserDTO user);

    UserDTO getById(Long id);

    UserDTO getByUsername(String username);

    List<UserDTO> getAll();
}
