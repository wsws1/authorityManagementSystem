package com.simo.meitan.controller;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.dto.PtUserDTO;
import com.simo.meitan.model.PtUser;
import com.simo.meitan.service.PtUserService;
import com.simo.meitan.utils.RestResponse;
import com.simo.meitan.utils.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ptuser")
@RestController
public class PtUserController {
    
    @Autowired
    PtUserService ptUserService;
    
    @PostMapping("/add")
    public RestResponse addPtUser(@RequestBody PtUserDTO ptUserDTO){
        if(ptUserDTO!=null){
            PtUser ptUser=new PtUser();
            ptUserDTO.setUserUuid(UUIDUtil.getUUID());
            BeanUtils.copyProperties(ptUserDTO,ptUser);

            int recode=ptUserService.insert(ptUser);
            if (recode>0){
                return RestResponse.succuess("添加用户成功");
            }
        }
        return RestResponse.fail("检查用户信息");
    }

    @GetMapping("/delete")
    public RestResponse deleteUser(@RequestParam("userId") String userId){
        if (StringUtils.isEmpty(userId)){
            return RestResponse.fail("请输入正确的用户id");
        }else{
            int recode=ptUserService.deleteByPrimaryKey(userId);
            if (recode>0){
                return RestResponse.succuess("删除用户成功");
            }else {
                return RestResponse.fail("删除用户失败");
            }
        }
    }

    @PostMapping("/update")
    public RestResponse updateUser(@RequestBody PtUserDTO ptUserDTO){
        if (ptUserDTO==null || StringUtils.isEmpty(ptUserDTO.getUserUuid())){
            return RestResponse.fail("请检查用户信息");
        }

        PtUser ptUser=new PtUser();
        BeanUtils.copyProperties(ptUserDTO,ptUser);
        int recode =ptUserService.updateByPrimaryKeySelective(ptUser);
        if (recode==0){
            return RestResponse.fail("修改用户信息失败");
        }

        return RestResponse.succuess(ptUser,"修改用户信息成功");
    }

    @GetMapping("/list")
    public RestResponse getUserList(@RequestParam(value = "userName",required = false) String userName,
                                     @RequestParam(value ="organUuid",required = false) String organUuid,
                                    @RequestParam(value ="dutyUuid",required = false) String dutyUuid,
                                     @RequestParam("page") Integer page,
                                     @RequestParam("size") Integer size){


        PageInfo<PtUser> pageInfo=ptUserService.selectAllByUserNameLikeAndOrganUuidLikeAndDutyUuidLike(
                userName,
                organUuid,
                dutyUuid,
                page,
                size
        );

        return RestResponse.succuess(pageInfo," 用户列表查询成功");
    }
    
    @GetMapping("/get")
    public RestResponse getUser(@RequestParam("userId") String userId){
        if(!StringUtils.isEmpty(userId)){
            PtUserDTO ptUserDTO=new PtUserDTO();
            PtUser ptUser=ptUserService.selectByPrimaryKey(userId);
            BeanUtils.copyProperties(ptUser,ptUserDTO);
            return RestResponse.succuess(ptUserDTO);
        }else{
            return RestResponse.fail("请检查用户Id");
        }
    }
}
