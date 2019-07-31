package com.sample.shiro.controller;


import com.sample.shiro.common.model.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaoy
 * @since 2019-06-22
 */
@RestController
@RequestMapping("/")
public class MessageController extends BaseController {

    @RequestMapping(value = "admin/message", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getMessageForAdmin() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "admin message");
        return map;
    }

    @RequestMapping(value = "teacher/message", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getMessageForTeacher() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "teacher message");
        return map;
    }
}
