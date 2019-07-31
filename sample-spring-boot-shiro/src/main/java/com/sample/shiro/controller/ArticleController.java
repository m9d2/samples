package com.sample.shiro.controller;


import com.sample.shiro.common.model.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

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
public class ArticleController extends BaseController {

    /**
     * 获取文章
     * @return
     */
    @RequestMapping(value = "article", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getArticle() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "get article success!");
        return map;
    }

    /**
     * 添加文章
     * @return
     */
    @RequestMapping(value = "article", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("article:add")
    public Map<String, Object> addArticle() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "add article success!");
        return map;
    }

    /**
     * 编辑文章
     * @return
     */
    @RequestMapping(value = "article", method = RequestMethod.PUT)
    @ResponseBody
    @RequiresPermissions("article:edit")
    public Map<String, Object> editArticle() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "edit article success!");
        return map;
    }

    /**
     * 删除文章
     * @return
     */
    @RequestMapping(value = "article/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @RequiresPermissions("article:delete")
    public Map<String, Object> deleteArticle(@PathVariable("id") String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "delete article success!");
        return map;
    }

}
