package com.simo.meitan.service;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.simo.meitan.model.PtOrgan;
import org.springframework.web.bind.annotation.RequestParam;

public interface PtOrganService {


    int addOrgan(PtOrgan record);

    int insertSelective(PtOrgan record);

    PtOrgan getOrganTree();

    int updateByPrimaryKeySelective(PtOrgan record);

    int updateByPrimaryKey(PtOrgan record);

    PtOrgan selectByPrimaryKey(String organUuid);

    int deleteOrgan(String organUUID);

    PageInfo<PtOrgan> selectAllByOrganNameLikeAndAccountCodeLikeAndInUse(
            String organName,
            String accountCode,
            Boolean inUse,
            String sort,
            Integer page,
            Integer size
    );
}

