package com.simo.meitan.controller;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.dto.PtDutyDTO;
import com.simo.meitan.model.PtDuty;
import com.simo.meitan.service.PtDutyService;
import com.simo.meitan.utils.RestResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/duty")
@RestController
public class DutyController {
    
    @Autowired
    PtDutyService ptDutyService;

    @PostMapping("/add")
    public RestResponse addPtDuty(@RequestBody PtDutyDTO ptDutyDTO){
        if(ptDutyDTO!=null){
            PtDuty ptDuty=new PtDuty();
            BeanUtils.copyProperties(ptDutyDTO,ptDuty);
            
            int recode=ptDutyService.insert(ptDuty);
            if (recode>0){
                return RestResponse.succuess("添加岗位成功");
            }
        }
        return RestResponse.fail("检查岗位信息");
    }

    @GetMapping("/delete")
    public RestResponse deleteDuty(@RequestParam("dutyId") String dutyId){
        if (StringUtils.isEmpty(dutyId)){
            return RestResponse.fail("请输入正确的岗位id");
        }else{
            int recode=ptDutyService.deleteByPrimaryKey(dutyId);
            if (recode>0){
                return RestResponse.succuess("删除岗位成功");
            }else {
                return RestResponse.fail("删除岗位失败");
            }
        }
    }

    @PostMapping("/update")
    public RestResponse updateDuty(@RequestBody PtDutyDTO ptDutyDTO){
        if (ptDutyDTO==null || StringUtils.isEmpty(ptDutyDTO.getDutyid())){
            return RestResponse.fail("请检查岗位信息");
        }

        PtDuty ptDuty=new PtDuty();
        BeanUtils.copyProperties(ptDutyDTO,ptDuty);
        int recode =ptDutyService.updateByPrimaryKeySelective(ptDuty);
        if (recode==0){
            return RestResponse.fail("修改岗位信息失败");
        }

        return RestResponse.succuess(ptDuty,"修改岗位信息成功");
    }

    @GetMapping("/list")
    public RestResponse getDutyList(@RequestParam(value = "dutyName",required = false) String dutyName,
                                     @RequestParam(value ="organUuid",required = false) String organUuid,
                                    @RequestParam(value ="roleUuid",required = false) String roleUuid,
                                     @RequestParam("page") Integer page,
                                     @RequestParam("size") Integer size){


        PageInfo<PtDuty> pageInfo=ptDutyService.selectAllByNameLikeAndOrganUuidLikeAndRoleUuidLike(
                dutyName,
                organUuid,
                roleUuid,
                page,
                size
        );

        return RestResponse.succuess(pageInfo," 岗位列表查询成功");

    }
    @GetMapping("/get")
    public RestResponse getDuty(@RequestParam("dutyId") String dutyId){
        if(!StringUtils.isEmpty(dutyId)){
            PtDuty ptDuty=ptDutyService.selectByPrimaryKey(dutyId);
            return RestResponse.succuess(ptDuty);
        }else{
            return RestResponse.fail("请检查岗位Id");
        }
    }

    @GetMapping("/getlistbyorganid")
    public RestResponse getDutyListByOrganId(@RequestParam("organId") String organId){
        if(!StringUtils.isEmpty(organId)){
            List<PtDuty> ptDutyList=ptDutyService.selectAllByOrganUuid(organId);
            return RestResponse.succuess(ptDutyList);
        }else{
            return RestResponse.fail("请检查组织Id");
        }
    }
}
