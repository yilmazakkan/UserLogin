package com.yilmazakkan.UserAccount.repository;

import com.yilmazakkan.UserAccount.dto.UserDTO;
import com.yilmazakkan.UserAccount.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long>  {


        User findByUsername(String username);

}

