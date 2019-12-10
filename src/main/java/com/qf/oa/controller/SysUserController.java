package com.qf.oa.controller;

import com.google.gson.Gson;
import com.qf.oa.common.Page;
import com.qf.oa.entity.SysMenu;
import com.qf.oa.entity.SysUser;
import com.qf.oa.service.ISysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO:用户controller
 * @author weimin
 * @date 2019/9/29
 */
@Controller
@RequestMapping("sysUser")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("getById")
    @ResponseBody
    public SysUser getById(Long id){
        SysUser sysUser = sysUserService.selectByPrimaryKey(id);
        return sysUser;
    }

    @RequestMapping("getUserListByCondition")
    public String getUserListByCondition(Page<SysUser> page, String userName, Model model){
        page = sysUserService.getUserListByCondition(page,userName);
        page.setUrl("sysUser/getUserListByCondition");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userName",userName);
        model.addAttribute("userName",userName);
        model.addAttribute("conditions",new Gson().toJson(map));
        model.addAttribute("page",page);
        System.out.println(new Gson().toJson(map));
        return "user/userList";
    }

    @RequestMapping("checkLogin")
    public String checkLogin(SysUser sysUser,Model model){
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUserName(),sysUser.getUserPassword());
            try {
                currentUser.login(token);
            }catch (AuthenticationException e){
                return "login";
            }
        }
        sysUser  = (SysUser) currentUser.getPrincipal();
        List<SysMenu> menuList = sysUserService.getUserMenu(sysUser.getUserId());
        model.addAttribute("menuList",menuList);
        return "forward:/index.jsp";
    }

    @RequestMapping("toAdd")
    @RequiresPermissions("user:add")
    public String toAdd(){
        System.out.println("添加");
        return "user/add";
    }

    @RequestMapping("toUpdate")
    @RequiresPermissions("user:update")
    public String toUpdate(){
        System.out.println("编辑");
        return "user/update";
    }
}
