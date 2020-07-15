package com.simo.meitan.controller;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.dto.PtResDTO;
import com.simo.meitan.model.PtRes;
import com.simo.meitan.service.PtResService;
import com.simo.meitan.utils.RestResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/res")
@RestController
public class ResController {
    
    @Autowired
    PtResService ptResService;

    @GetMapping("/query")
    public RestResponse queryRes(){
        PtRes ptRes=ptResService.getResTree();
        if (ptRes==null){
            return RestResponse.fail("请检查根资源uuid");
        }else {
            return RestResponse.succuess(ptRes,"资源树查询成功");
        }
    }

    @PostMapping("/add")
    public RestResponse addptRes(@RequestBody PtResDTO ptResDTO){
        if(ptResDTO!=null){
            PtRes ptRes=new PtRes();
            BeanUtils.copyProperties(ptResDTO,ptRes);
            int recode=ptResService.addRes(ptRes);
            if (recode>0){
                return RestResponse.succuess("添加资源成功");
            }
        }
        return RestResponse.fail("检查资源信息");
    }

    @GetMapping("/delete")
    public RestResponse deleteRes(@RequestParam("resId") String resId){
        if (StringUtils.isEmpty(resId)){
            return RestResponse.fail("请输入正确的资源id");
        }else{
            int recode=ptResService.deleteByPrimaryKey(resId);
            if (recode>0){
                return RestResponse.succuess("删除资源成功");
            }else {
                return RestResponse.fail("为父资源，或不存在");
            }
        }
    }

    @PostMapping("/update")
    public RestResponse updateRes(@RequestBody PtResDTO ptResDTO){
        if (ptResDTO==null || StringUtils.isEmpty(ptResDTO.getResUuid())){
            return RestResponse.fail("请检查资源信息");
        }
        PtRes ptRes=new PtRes();
        BeanUtils.copyProperties(ptResDTO,ptRes);
        int recode=ptResService.updateByPrimaryKeySelective(ptRes);
        if (recode==0){
            return RestResponse.fail("修改资源信息失败");
        }

        return RestResponse.succuess(ptRes,"修改资源信息成功");
    }

    @GetMapping("/list")
    public RestResponse getResList(@RequestParam(value = "resName",required = false) String resName,
                                     @RequestParam(value ="resUrl",required = false) String resUrl,
                                     @RequestParam(value="resType",required = false) String resType,
                                     @RequestParam(value="sort",required = false) String sort,
                                     @RequestParam("page") Integer page,
                                     @RequestParam("size") Integer size){


        PageInfo<PtRes> pageInfo=ptResService.selectAllByResNameLikeAndResUrlLikeAndResType(
                resName,
                resUrl,
                resType,
                page,
                size
        );

        return RestResponse.succuess(pageInfo," 资源列表查询成功");

    }
    @GetMapping("/get")
    public RestResponse getRes(@RequestParam("resId") String resId){
        if(!StringUtils.isEmpty(resId)){
            return RestResponse.succuess(ptResService.selectByPrimaryKey(resId));
        }else{
            return RestResponse.fail("请检查资源Id");
        }
    }
    
}
