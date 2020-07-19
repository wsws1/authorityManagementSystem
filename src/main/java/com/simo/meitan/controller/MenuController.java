package com.simo.meitan.controller;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.dto.PtMenuDTO;
import com.simo.meitan.model.PtDuty;
import com.simo.meitan.model.PtMenu;
import com.simo.meitan.model.PtUser;
import com.simo.meitan.service.PtDutyService;
import com.simo.meitan.service.PtMenuService;
import com.simo.meitan.service.PtUserService;
import com.simo.meitan.utils.RestResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    PtMenuService ptMenuService;

    @Autowired
    PtUserService ptUserService;

    @Autowired
    PtDutyService ptDutyService;



    @GetMapping("/build")
    public RestResponse buildMenus(){
        String username= (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PtUser ptUser = ptUserService.selectOneByUsername(username);
        List<PtMenu> ptMenuList=new ArrayList<>();
        if(ptUser.getDutyUuid()!=null){
            PtDuty ptDuty=ptDutyService.selectByPrimaryKey(ptUser.getDutyUuid());
            if(ptDuty!=null&&ptDuty.getRoleUuid()!=null){
                ptMenuList=ptMenuService.getRoleSelectedMenuForest(ptDuty.getRoleUuid());
            }
        }

        return RestResponse.succuess(ptMenuList);
    }



    @GetMapping("/query")
    public RestResponse queryMenu(){
        List<PtMenu> ptMenuList=ptMenuService.selectPtResTressByParentUUID();
        if (ptMenuList==null||ptMenuList.size()==0){
            return RestResponse.fail("请检查根菜单uuid");
        }else {
            return RestResponse.succuess(ptMenuList,"菜单树查询成功");
        }
    }

    @PostMapping("/add")
    public RestResponse addptRes(@RequestBody PtMenuDTO ptMenuDTO){
        if(ptMenuDTO!=null){
            PtMenu ptMenu=new PtMenu();
            BeanUtils.copyProperties(ptMenuDTO,ptMenu);
            int recode=ptMenuService.addMenu(ptMenu);
            if (recode>0){
                return RestResponse.succuess("添加菜单成功");
            }
        }
        return RestResponse.fail("检查菜单信息");
    }

    @GetMapping("/delete")
    public RestResponse deleteMenu(@RequestParam("menuId") String menuId){
        if (StringUtils.isEmpty(menuId)){
            return RestResponse.fail("请输入正确的菜单id");
        }else{
            int recode=ptMenuService.deleteByPrimaryKey(menuId);
            if (recode>0){
                return RestResponse.succuess("删除菜单成功");
            }else {
                return RestResponse.fail("为父菜单，或不存在");
            }
        }
    }

    @PostMapping("/update")
    public RestResponse updateMenu(@RequestBody PtMenuDTO ptMenuDTO){
        if (ptMenuDTO==null || StringUtils.isEmpty(ptMenuDTO.getMenuUuid())){
            return RestResponse.fail("请检查菜单信息");
        }
        PtMenu ptMenu=new PtMenu();
        BeanUtils.copyProperties(ptMenuDTO,ptMenu);
        int recode=ptMenuService.updateByPrimaryKeySelective(ptMenu);
        if (recode==0){
            return RestResponse.fail("修改菜单信息失败");
        }

        return RestResponse.succuess(ptMenu,"修改菜单信息成功");
    }

    @GetMapping("/list")
    public RestResponse getMenuList(@RequestParam(value = "menuTitle",required = false) String menuTitle,
                                   @RequestParam(value ="menuType",required = false) Integer menuType,
                                   @RequestParam("page") Integer page,
                                   @RequestParam("size") Integer size){


        PageInfo<PtMenu> pageInfo=ptMenuService.selectPtMenuByTitleLikeAndType(
                menuTitle,
                menuType,
                page,
                size
        );

        return RestResponse.succuess(pageInfo," 菜单列表查询成功");

    }
    @GetMapping("/get")
    public RestResponse getMenu(@RequestParam("menuId") String menuId){
        if(!StringUtils.isEmpty(menuId)){
            return RestResponse.succuess(ptMenuService.selectByPrimaryKey(menuId));
        }else{
            return RestResponse.fail("请检查菜单Id");
        }
    }
}
