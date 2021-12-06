package com.xyc.wms.controller;

import com.xyc.wms.entity.User;
import com.xyc.wms.exception.APIException;
import com.xyc.wms.service.UserService;
import com.xyc.wms.utils.ApiResult;
import com.xyc.wms.utils.Code;
import com.xyc.wms.validator.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
//@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<Object> login(@Valid @RequestBody LoginUser loginUser) {
        User user = userService.selectLoginUser(loginUser.getUserName(), loginUser.getPassWord());
        if (user == null || user.getId() == 0) {
            throw new APIException(Code.CLIENT_ERROR);
        }
        return ApiResult.getInstance(Code.Sucess, "");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<Object> register(@Valid @RequestBody LoginUser loginUser) {
        User user = userService.selectLoginUser(loginUser.getUserName());
        if (user != null && user.getId() != null) {
            throw new APIException(Code.CLIENT_ERROR);
        }
        User registerUser = new User();
        registerUser.setUserName(loginUser.getUserName());
        registerUser.setPassWord(loginUser.getPassWord());
        registerUser.setRealName("ddddddddd");
        User save = userService.save(registerUser);
        if (save == null) {
            throw new APIException(Code.CLIENT_ERROR);
        }
        return ApiResult.getInstance(Code.Sucess, save);
    }


//    //通过用户id获取用户所有信息
//    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
//    public String GetUser(@RequestParam int id) {
//        return userService.getUserInfo(id).toString();
//    }
//
//
//    //通过用户id删除用户
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public String delete(int id) {
//        int result = userService.deleteById(id);
//        if (result >= 1) {
//            return "删除成功";
//        } else {
//            return "删除失败";
//        }
//    }
//
//    //根据用户id更新用户信息
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String update(User user) {
//        int result = userService.Update(user);
//        if (result >= 1) {
//            return "修改成功";
//        } else {
//            return "修改失败";
//        }
//    }
//
//    //插入新用户
//    @RequestMapping(value = "/insert", method = RequestMethod.POST)
//    public User insert(User user) {
//        return userService.save(user);
//    }
//
//    //打印所有用户信息
//    @RequestMapping("/selectAll")
//
//    public List<User> ListUser() {
//        return userService.selectAll();
//    }

}
