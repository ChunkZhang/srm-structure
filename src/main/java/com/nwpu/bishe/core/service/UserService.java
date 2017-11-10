package com.nwpu.bishe.core.service;

import com.nwpu.bishe.common.cookie.CookieUserContext;
import com.nwpu.bishe.common.enumeration.LoginStatus;
import com.nwpu.bishe.common.utils.MD5Utils;
import com.nwpu.bishe.core.jpa.entity.User;
import com.nwpu.bishe.core.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by chunk on 2017/10/31.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CookieUserContext cookieUserContext;

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

    public LoginStatus login(HttpServletResponse response,String userName, String password){
        User user = userRepository.findByUserName(userName);
        if (user == null){
            return LoginStatus.NO_USER;
        }
        if (!user.getPassword().equals(MD5Utils.MD5Encode(password))){
            return LoginStatus.PASSWORD_WRONG;
        }
        cookieUserContext.addLoginCookie(response,userName);
        return LoginStatus.SUCCESSED;
    }

    public LoginStatus exit(HttpServletResponse response, String userName){
        cookieUserContext.deleteLoginCookie(response);
        return LoginStatus.EXIT;
    }

}
