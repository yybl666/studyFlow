package com.ybl.studyflow.controller;

import com.ybl.studyflow.common.Result;
import com.ybl.studyflow.dto.LoginDTO;
import com.ybl.studyflow.dto.RegisterDTO;
import com.ybl.studyflow.entity.User;
import com.ybl.studyflow.service.UserService;
import com.ybl.studyflow.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/register")
    public Result<Void> register(@RequestBody RegisterDTO registerDTO){
        userService.register(registerDTO);

        return Result.success();
    }

    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody LoginDTO loginDTO){
        LoginVO loginVO = userService.login(loginDTO);

        return Result.success(loginVO);
    }
}
