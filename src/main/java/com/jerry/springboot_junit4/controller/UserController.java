package com.jerry.springboot_junit4.controller;

import com.jerry.springboot_junit4.base.controller.BaseController;
import com.jerry.springboot_junit4.base.utils.StateParameter;
import com.jerry.springboot_junit4.entity.User;
import com.jerry.springboot_junit4.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Slf4j
@RequestMapping(value = "/user")
@Controller
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ModelMap add(User user) {
        try {
            if (StringUtils.isEmpty(user.getId())) {
                user.setId(getUuid());
            } else {
                user.setUpdateDate(new Date());
            }
            userService.save(user);
            log.info("save successfully");
            return getModelMap(StateParameter.SUCCESS, user, "success");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "fail");
        }
    }
        @RequestMapping(value = "/delete",method = RequestMethod.GET)
        @ResponseBody
        public ModelMap delete(String id)
        {

        try{
            User user=userService.findById(id);
            if(user==null)
            {
                return getModelMap(StateParameter.FAULT,user,"cannot find user");
            }
            userService.delete(user);
            log.info("success");
            return getModelMap(StateParameter.SUCCESS,user,"delete successfully");
        }catch (Exception e)
        {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT,null,"fail");
        }
    }
    @RequestMapping("/list")

    public String list(HttpServletRequest request)
    {
        List<User> list=userService.findAll();
        request.setAttribute("list",list);
        log.info("return to listPage");
        return "listPage";
    }
}
