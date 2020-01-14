package com.yilmazakkan.UserAccount.controller;

import com.yilmazakkan.UserAccount.dto.LoginRequest;
import com.yilmazakkan.UserAccount.dto.RegistrationRequest;
import com.yilmazakkan.UserAccount.dto.TokenResponse;
import com.yilmazakkan.UserAccount.model.User;
import com.yilmazakkan.UserAccount.repository.UserDao;
import com.yilmazakkan.UserAccount.security.JwtTokenUtil;
import com.yilmazakkan.UserAccount.service.impl.UserServiceImpl;
import com.yilmazakkan.UserAccount.util.ControllerPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping(ControllerPaths.TokenCtrl.CTRL)
@RestController
public class AccountController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        final User user = userDao.findByUsername(request.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new TokenResponse(user.getUsername(), token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Boolean> register(@RequestBody RegistrationRequest registrationRequest) throws AuthenticationException {
        Boolean response = userService.register(registrationRequest);
        return ResponseEntity.ok(response);
    }

}
