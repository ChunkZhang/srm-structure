package com.nwpu.bishe.core.service;

import com.nwpu.bishe.common.enumeration.LoginStatus;
import com.nwpu.bishe.common.utils.MD5Utils;
import com.nwpu.bishe.core.jpa.entity.User;
import com.nwpu.bishe.core.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by chunk on 2017/10/31.
 */
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void creatUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user){
        User old = userRepository.findByUserName(user.getUserName());

        if (old == null){
            creatUser(user);
        }else {
            old.setUpdated(new Date());
            old.setPassword(MD5Utils.MD5Encode(user.getPassword()));
            old.setPhone(user.getPhone());
            old.setEmail(user.getEmail());
            userRepository.save(old);
        }
    }

    public LoginStatus login(String userName, String password){
        User user = userRepository.findByUserName(userName);
        if (user == null){
            return LoginStatus.NO_USER;
        }
        if (!user.getPassword().equals(MD5Utils.MD5Encode(password))){
            return LoginStatus.PASSWORD_WRONG;
        }
        return LoginStatus.SUCCESSED;
    }

    public LoginStatus exit(String userName){
        return LoginStatus.EXIT;
    }

}
