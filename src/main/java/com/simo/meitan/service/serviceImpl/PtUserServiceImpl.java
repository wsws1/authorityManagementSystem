package com.simo.meitan.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simo.meitan.model.PtRole;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.simo.meitan.mapper.PtUserMapper;
import com.simo.meitan.model.PtUser;
import com.simo.meitan.service.PtUserService;

import java.util.List;

@Service
public class PtUserServiceImpl implements PtUserService{

    @Resource
    private PtUserMapper ptUserMapper;

    @Override
    public int deleteByPrimaryKey(String userUuid) {
        return ptUserMapper.deleteByPrimaryKey(userUuid);
    }

    @Override
    public int insert(PtUser record) {
        return ptUserMapper.insert(record);
    }

    @Override
    public int insertSelective(PtUser record) {
        return ptUserMapper.insertSelective(record);
    }

    @Override
    public PtUser selectByPrimaryKey(String userUuid) {
        return ptUserMapper.selectByPrimaryKey(userUuid);
    }

    @Override
    public int updateByPrimaryKeySelective(PtUser record) {
        return ptUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PtUser record) {
        return ptUserMapper.updateByPrimaryKey(record);
    }


    @Override
    public PageInfo<PtUser> selectAllByUserNameLikeAndOrganUuidLikeAndDutyUuidLike(String userName, String organUuid, String dutyUuid, Integer page, Integer size) {
        PageHelper pageHelper=new PageHelper();
        pageHelper.startPage(page,size);
        List<PtUser> ptUserList=null;

        ptUserList=ptUserMapper.selectAllByUsernameLikeAndOrganUuidLikeAndDutyUuidLike(
                userName,
                organUuid,
                dutyUuid
        );
        return new PageInfo<>(ptUserList);
    }
}
