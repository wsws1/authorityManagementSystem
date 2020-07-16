package com.simo.meitan.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simo.meitan.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.simo.meitan.mapper.PtResMapper;
import com.simo.meitan.model.PtRes;
import com.simo.meitan.service.PtResService;

@Service
public class PtResServiceImpl implements PtResService{
    @Value("${sql.res.root.uuid}")
    private String resRootUUID;

    @Resource
    private PtResMapper ptResMapper;

    @Override
    public int deleteByPrimaryKey(String resUuid) {
        int recode=0;
        Map<String,Object> map=new HashMap<>();
        map.put("resId",resUuid);
        map.put("recode",recode);
        ptResMapper.deleteRes(map);
        recode=(Integer) map.get("recode");
        return recode;
    }

    @Override
    public int insertSelective(PtRes record) {
        return ptResMapper.insertSelective(record);
    }

    @Override
    public PtRes selectByPrimaryKey(String resUuid) {
        return ptResMapper.selectByPrimaryKey(resUuid);
    }

    @Override
    public int updateByPrimaryKeySelective(PtRes record) {
        return ptResMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PtRes record) {
        return ptResMapper.updateByPrimaryKey(record);
    }

    @Override
    public int addRes(PtRes record) {
        //step1 查询父ID 是否存在
        // 若不在，则错误
        // 若在，更新isParent true
        System.out.println("parent uuid "+record.getParentUuid());
        PtRes feather=ptResMapper.selectByPrimaryKey(record.getParentUuid());
        if (feather==null){
            return 0;
        }
        //step2 插入子组织
        record.setResUuid(UUIDUtil.getUUID());
        return ptResMapper.insert(record);
    }

    @Override
    public PtRes getResTree() {
        return ptResMapper.selectPtResTressByParentUUID(resRootUUID);
    }

    @Override
    public PageInfo<PtRes> selectAllByResNameLikeAndResUrlLikeAndResType(String resName, String resUrl, String type, Integer page, Integer size) {
        PageHelper pageHelper=new PageHelper();
        pageHelper.startPage(page,size);
        List<PtRes> ptResList=null;
        ptResList=ptResMapper.selectAllByResNameLikeAndResUrlLikeAndResType(
                resName,
                resUrl,
                type
        );
        return new PageInfo<>(ptResList);
    }
}
