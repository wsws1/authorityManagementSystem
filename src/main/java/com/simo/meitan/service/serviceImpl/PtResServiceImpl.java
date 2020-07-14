package com.simo.meitan.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.simo.meitan.mapper.PtResMapper;
import com.simo.meitan.model.PtRes;
import com.simo.meitan.service.PtResService;
@Service
public class PtResServiceImpl implements PtResService{

    @Resource
    private PtResMapper ptResMapper;

    @Override
    public int deleteByPrimaryKey(String resUuid) {
        return ptResMapper.deleteByPrimaryKey(resUuid);
    }

    @Override
    public int insert(PtRes record) {
        return ptResMapper.insert(record);
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

}
