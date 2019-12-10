package com.qf.oa.controller;

import com.google.gson.Gson;
import com.qf.oa.common.Page;
import com.qf.oa.common.SysResult;
import com.qf.oa.entity.SysRole;
import com.qf.oa.entity.SysUser;
import com.qf.oa.service.ISysMenuService;
import com.qf.oa.service.ISysRoleService;
import com.qf.oa.service.ISysUserService;
import com.qf.oa.vo.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO:实现权限管理的controller
 * @author weimin
 * @date 2019/9/27
 */
@Controller
@RequestMapping("auth")
public class AuthorizationController {
    @Autowired
    private ISysRoleService sysRoleService;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysMenuService sysMenuService;

    @RequestMapping("showAuthPage")
    public String toAuthPage(ModelMap map){
        List<SysRole> roleList = sysRoleService.getRoleList();
        System.out.println("---->"+roleList.get(1).getRoleName());
        map.put("roleList",roleList);
        return "auth/authorization";
    }
    @RequestMapping("getUserListByRoleId")
    public String getUserListByRoleId(Page<SysUser> page, Long roleId, Model model){
        page = sysUserService.getUserListByRoleId(page,roleId);
        page.setUrl("auth/getUserListByRoleId");
        Map<String ,Object> map = new HashMap<>();
        map.put("roleId",roleId);
        model.addAttribute("conditions",new Gson().toJson(map));
        model.addAttribute("page",page);
        return "auth/auth_user";
    }

    @RequestMapping("getNoAuthUserByRoleId")
    public String getNoAuthUserByRoleId(Page<SysUser> page,Long roleId,String userName,Model model){
        page = sysUserService.getNoAuthUserByRoleId(page,roleId,userName);
        page.setUrl("auth/getNoAuthUserByRoleId");
        Map<String ,Object> map = new HashMap<>();
        map.put("userName",userName);
        map.put("roleId",roleId);
        model.addAttribute("conditions",new Gson().toJson(map));
        model.addAttribute("page",page);
        return "auth/no_auth_user";
    }

    @RequestMapping("batchAddAuthorization")
    @ResponseBody
    public SysResult batchAddAuthorization(@RequestParam List<Long> itm,String roleId){
        return sysRoleService.batchAddAuthorization(itm,roleId);
    }

    @RequestMapping("delAuthUser")
    @ResponseBody
    public SysResult delAuthUser(Long userId,Long roleId){
        System.out.println("删除："+userId+"--->"+roleId);
        return sysRoleService.delAuthUser(userId,roleId);
    }


    @RequestMapping("getMenuListByRoleId")
    public String getMenuListByRoleId(Long roleId,Model model){
        List<SysMenuVo> list = sysMenuService.getMenuListByRoleId(roleId);
        model.addAttribute("sysMenuVoList",new Gson().toJson(list));
        model.addAttribute("roleId",roleId);
        return "auth/auth_menu";
    }
    @RequestMapping("refreshAuthMenu")
    @ResponseBody
    public SysResult refreshAuthMenu(@RequestParam List<Long> ids,Long roleId,Model model){
        return sysMenuService.refreshAuthMenu(ids,roleId);
    }
}