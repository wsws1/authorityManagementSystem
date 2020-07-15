package com.simo.meitan.controller;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.dto.PtRoleDTO;
import com.simo.meitan.model.PtRole;
import com.simo.meitan.service.PtRoleResService;
import com.simo.meitan.service.PtRoleService;
import com.simo.meitan.utils.RestResponse;
import com.simo.meitan.utils.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/role")
@RestController
public class RoleController {
    @Autowired
    PtRoleService ptRoleService;
    @Autowired
    PtRoleResService ptRoleResService;

    

    @PostMapping("/add")
    public RestResponse addPtRole(@RequestBody PtRoleDTO ptRoleDTO){
        if(ptRoleDTO!=null){
            PtRole ptRole=new PtRole();
            ptRoleDTO.setRoleUuid(UUIDUtil.getUUID());
            BeanUtils.copyProperties(ptRoleDTO,ptRole);

            int recode1=ptRoleService.insert(ptRole);
            int recode2=ptRoleResService.addResListByRoleUuid(ptRoleDTO);
            if (recode1>0&&(ptRoleDTO.getResList()==null||recode2==ptRoleDTO.getResList().size())){
                return RestResponse.succuess("添加角色成功");
            }
        }
        return RestResponse.fail("检查角色信息");
    }

    @GetMapping("/delete")
    public RestResponse deleteOrgan(@RequestParam("roleId") String roleId){
        if (StringUtils.isEmpty(roleId)){
            return RestResponse.fail("请输入正确的角色id");
        }else{
            int recode=ptRoleService.deleteByPrimaryKey(roleId);
            ptRoleResService.deleteByRoleUuid(roleId);
            if (recode>0){
                return RestResponse.succuess("删除角色成功");
            }else {
                return RestResponse.fail("删除角色失败");
            }
        }
    }

    @PostMapping("/update")
    public RestResponse updateOrgan(@RequestBody PtRoleDTO ptRoleDTO){
        if (ptRoleDTO==null || StringUtils.isEmpty(ptRoleDTO.getRoleUuid())){
            return RestResponse.fail("请检查角色信息");
        }

        PtRole ptRole=new PtRole();
        BeanUtils.copyProperties(ptRoleDTO,ptRole);
        int recode1 =ptRoleService.updateByPrimaryKeySelective(ptRole);
        int recode2=0;
        if(ptRoleDTO.getResList()!=null&&ptRoleDTO.getResList().size()>0){
            recode2=ptRoleResService.addResListByRoleUuid(ptRoleDTO);
        }
        if (recode1==0||(ptRoleDTO.getResList()!=null&&ptRoleDTO.getResList().size()!=recode2)){
            return RestResponse.fail("修改角色信息失败");
        }

        return RestResponse.succuess(ptRole,"修改角色信息成功");
    }

    @GetMapping("/list")
    public RestResponse getOrganList(@RequestParam(value = "roleName",required = false) String roleName,
                                     @RequestParam(value ="roleId",required = false) String roleId,
                                     @RequestParam("page") Integer page,
                                     @RequestParam("size") Integer size){


        PageInfo<PtRole> pageInfo=ptRoleService.selectAllByRoleNameLikeAndRoleIdLike(
                roleName,
                roleId,
                page,
                size
        );

        return RestResponse.succuess(pageInfo," 角色列表查询成功");

    }
    @GetMapping("/get")
    public RestResponse getOrgan(@RequestParam("roleId") String roleId){
        if(!StringUtils.isEmpty(roleId)){
            PtRoleDTO ptRoleDTO=new PtRoleDTO();
            PtRole ptRole=ptRoleService.selectByPrimaryKey(roleId);
            BeanUtils.copyProperties(ptRole,ptRoleDTO);
            ptRoleDTO.setResList(ptRoleResService.selectAllByRoleUuid(roleId));
            return RestResponse.succuess(ptRoleDTO);
        }else{
            return RestResponse.fail("请检查角色Id");
        }
    }
}
