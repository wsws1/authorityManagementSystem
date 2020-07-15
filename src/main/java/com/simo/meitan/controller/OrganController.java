package com.simo.meitan.controller;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.dto.PtOrganDTO;
import com.simo.meitan.model.PtOrgan;
import com.simo.meitan.service.PtOrganService;
import com.simo.meitan.utils.RestResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RequestMapping("/organ")
@RestController
public class OrganController {

    @Autowired
    PtOrganService ptOrganService;

    @GetMapping("/query")
    public RestResponse queryOrgan(){
        PtOrgan ptOrgan=ptOrganService.getOrganTree();
        if (ptOrgan==null){
            return RestResponse.fail("请检查根组织uuid");
        }else {
            return RestResponse.succuess(ptOrgan,"组织树查询成功");
        }
    }

    @PostMapping("/add")
    public RestResponse addPtOrgan(@RequestBody PtOrganDTO ptOrganDTO){
        if(ptOrganDTO!=null){
            PtOrgan ptOrgan=new PtOrgan();
            BeanUtils.copyProperties(ptOrganDTO,ptOrgan);
            ptOrgan.setModtime(LocalDateTime.now());
            ptOrgan.setIsParent(false);
            int recode=ptOrganService.addOrgan(ptOrgan);
            if (recode>0){
                return RestResponse.succuess("添加组织成功");
            }
        }
        return RestResponse.fail("检查组织信息");
    }

    @GetMapping("/delete")
    public RestResponse deleteOrgan(@RequestParam("organId") String organId){
        if (StringUtils.isEmpty(organId)){
            return RestResponse.fail("请输入正确的组织id");
        }else{
            int recode=ptOrganService.deleteOrgan(organId);
            if (recode>0){
                return RestResponse.succuess("删除组织成功");
            }else {
                return RestResponse.fail("为父组织，或不存在");
            }
        }
    }

    @PostMapping("/update")
    public RestResponse updateOrgan(@RequestBody PtOrganDTO ptOrganDTO){
        if (ptOrganDTO==null || StringUtils.isEmpty(ptOrganDTO.getOrganUuid())){
            return RestResponse.fail("请检查组织信息");
        }

        int recode1 =ptOrganService.deleteOrgan(ptOrganDTO.getOrganUuid());
        PtOrgan ptOrgan=new PtOrgan();
        BeanUtils.copyProperties(ptOrganDTO,ptOrgan);
        int recode2=ptOrganService.addOrgan(ptOrgan);
        if (recode1==0||recode2==0){
            return RestResponse.fail("修改组织信息失败");
        }

        return RestResponse.succuess(ptOrgan,"修改组织信息成功");
    }

    @GetMapping("/list")
    public RestResponse getOrganList(@RequestParam(value = "organName",required = false) String organName,
                                     @RequestParam(value ="accountCode",required = false) String accountCode,
                                     @RequestParam(value="inUse",required = false) Boolean inUse,
                                     @RequestParam(value="sort",required = false) String sort,
                                     @RequestParam("page") Integer page,
                                     @RequestParam("size") Integer size){


        PageInfo<PtOrgan> pageInfo=ptOrganService.selectAllByOrganNameLikeAndAccountCodeLikeAndInUse(
                organName,
                accountCode,
                inUse,
                sort,
                page,
                size
        );

        return RestResponse.succuess(pageInfo," 组织列表查询成功");

    }
    @GetMapping("/get")
    public RestResponse getOrgan(@RequestParam("organId") String organId){
        if(!StringUtils.isEmpty(organId)){
            return RestResponse.succuess(ptOrganService.selectByPrimaryKey(organId));
        }else{
            return RestResponse.fail("请检查组织Id");
        }
    }

}
