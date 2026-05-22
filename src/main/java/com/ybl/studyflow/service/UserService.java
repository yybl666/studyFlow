package com.ybl.studyflow.service;

import com.ybl.studyflow.dto.LoginDTO;
import com.ybl.studyflow.dto.RegisterDTO;
import com.ybl.studyflow.entity.User;
import com.ybl.studyflow.vo.LoginVO;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void register(RegisterDTO dto);
    LoginVO login(LoginDTO dto);
}
