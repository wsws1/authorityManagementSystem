package com.simo.meitan.service.serviceImpl;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simo.meitan.model.PtRole;
import com.simo.meitan.utils.UUIDUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.simo.meitan.mapper.PtDutyMapper;
import com.simo.meitan.model.PtDuty;
import com.simo.meitan.service.PtDutyService;
@Service
public class PtDutyServiceImpl implements PtDutyService{

    @Resource
    private PtDutyMapper ptDutyMapper;

    @Override
    public int deleteByPrimaryKey(String dutyid) {
        return ptDutyMapper.deleteByPrimaryKey(dutyid);
    }

    @Override
    public int insert(PtDuty record) {
        record.setDutyid(UUIDUtil.getUUID());
        return ptDutyMapper.insert(record);
    }

    @Override
    public int insertSelective(PtDuty record) {
        return ptDutyMapper.insertSelective(record);
    }

    @Override
    public PtDuty selectByPrimaryKey(String userId) {
        return ptDutyMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(PtDuty record) {
        return ptDutyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PtDuty record) {
        return ptDutyMapper.updateByPrimaryKey(record);
    }


    @Override
    public PageInfo<PtDuty> selectAllByNameLikeAndOrganUuidLikeAndRoleUuidLike(String likeName, String likeOrganUuid, String likeRoleUuid, Integer page, Integer size) {
        PageHelper pageHelper=new PageHelper();
        pageHelper.startPage(page,size);
        List<PtDuty> ptDutyList=null;

        ptDutyList=ptDutyMapper.selectAllByNameLikeAndOrganUuidLikeAndRoleUuidLike(
                likeName,
                likeOrganUuid,
                likeRoleUuid
        );
        return new PageInfo<>(ptDutyList);
    }

	@Override
	public List<PtDuty> selectAllByOrganUuid(String organUuid){
		 return ptDutyMapper.selectAllByOrganUuid(organUuid);
	}



}
