package com.ybl.studyflow.service.impl;

import com.ybl.studyflow.dto.LoginDTO;
import com.ybl.studyflow.dto.RegisterDTO;
import com.ybl.studyflow.entity.User;
import com.ybl.studyflow.exception.BusinessException;
import com.ybl.studyflow.mapper.UserMapper;
import com.ybl.studyflow.service.UserService;
import com.ybl.studyflow.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAll(){
        return  userMapper.findAll();
    }

    @Override
    public void register(RegisterDTO dto){
        User user = userMapper.findByUsername(dto.getUsername());

        if(user != null){
            throw new BusinessException("用户已经存在！");
        }

        User newUser = new User();
        newUser.setUsername(dto.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));

        userMapper.insert(newUser);
    }

    @Override
    public LoginVO login(LoginDTO dto){
        User user = userMapper.findByUsername(dto.getUsername());

        if(user == null){
            throw new BusinessException("用户不存在，请先注册！");
        }

        if(!bCryptPasswordEncoder.matches(dto.getPassword(),user.getPassword())){
            throw new BusinessException("用户密码错误！");
        }

        LoginVO loginVO = new LoginVO();

        loginVO.setUsername(user.getUsername());

        return loginVO;
    }
}
