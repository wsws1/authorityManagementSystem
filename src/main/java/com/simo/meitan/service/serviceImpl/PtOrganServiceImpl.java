package com.simo.meitan.service.serviceImpl;
import java.time.LocalDateTime;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simo.meitan.controller.OrganController;
import com.simo.meitan.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.simo.meitan.mapper.PtOrganMapper;
import com.simo.meitan.model.PtOrgan;
import com.simo.meitan.service.PtOrganService;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class PtOrganServiceImpl implements PtOrganService {
    @Value("${sql.oragn.root.uuid}")
    private String organRootUUID;

    @Resource
    private PtOrganMapper ptOrganMapper;



    @Override
    public int addOrgan(PtOrgan record) {

        record.setOrganUuid(UUIDUtil.getUUID());
        record.setModtime(LocalDateTime.now());
        return ptOrganMapper.insert(record);
    }

    @Override
    public int insertSelective(PtOrgan record) {
        return ptOrganMapper.insertSelective(record);
    }

    @Override
    public PtOrgan getOrganTree() {
        return ptOrganMapper.selectPtOrganTressByParentUUID(organRootUUID);
    }

    @Override
    public PtOrgan selectByPrimaryKey(String organUuid) {
        return ptOrganMapper.selectOneByOrganUuid(organUuid);
    }

    @Override
    public int updateByPrimaryKeySelective(PtOrgan record) {
        return ptOrganMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PtOrgan record) {
        return ptOrganMapper.updateByPrimaryKey(record);
    }


    @Override
    public int deleteOrgan(String organUUID) {
        int recode=0;
        Map<String,Object> map=new HashMap<>();
        map.put("organUUID",organUUID);
        map.put("recode",recode);
        ptOrganMapper.deleteOrgan(map);
        recode=(Integer) map.get("recode");
        return recode;
    }


    @Override
    public PageInfo<PtOrgan> selectAllByOrganNameLikeAndAccountCodeLikeAndInUse(
            String organName,
            String accountCode,
            Boolean inUse,
            String sort,
            Integer page,
            Integer size) {

        PageHelper pageHelper=new PageHelper();
        pageHelper.startPage(page,size);
        List<PtOrgan> ptOrganList=null;
        if (StringUtils.isEmpty(sort)||sort.indexOf('+')>0){
            ptOrganList=ptOrganMapper.selectAllByOrganNameLikeAndAccountCodeLikeAndInUseOrderByModtimeAsc(
                    organName,
                    accountCode,
                    inUse
            );
        }
        return new PageInfo<>(ptOrganList);
    }
}

