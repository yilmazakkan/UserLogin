package com.yilmazakkan.UserAccount.service.impl;

import com.yilmazakkan.UserAccount.advice.IMExceptionHandler;
import com.yilmazakkan.UserAccount.dto.RegistrationRequest;
import com.yilmazakkan.UserAccount.dto.UserDTO;
import com.yilmazakkan.UserAccount.model.User;
import com.yilmazakkan.UserAccount.repository.UserDao;
import com.yilmazakkan.UserAccount.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private static final Logger LOGGER = LoggerFactory.getLogger(IMExceptionHandler.class);

    public UserServiceImpl(UserDao userDao, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDTO save(UserDTO user) {
        User u = modelMapper.map(user, User.class);
        u = userDao.save(u);
        user.setId(u.getId());
        return user;
    }

    public List<UserDTO> getAll() {
        List<User> data = userDao.findAll();
        return Arrays.asList(modelMapper.map(data, UserDTO[].class));
    }
    @Override
    public UserDTO getById(Long id) {
        User u = userDao.getOne(id);
        return modelMapper.map(u, UserDTO.class);
    }

    @Override
    public UserDTO getByUsername(String username) {
        User u = userDao.findByUsername(username);
        return modelMapper.map(u, UserDTO.class);
    }

    @Transactional
    public Boolean register(RegistrationRequest registrationRequest) {
        try {
            User user = new User();
            user.setEmail(registrationRequest.getEmail());
            user.setNameSurname(registrationRequest.getNameSurname());
            user.setPassword(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));
            user.setUsername(registrationRequest.getUsername());
            userDao.save(user);
            return Boolean.TRUE;
        } catch (Exception e) {
            LOGGER.error("REGISTRATION=>", e);
            return Boolean.FALSE;
        }
    }
}
