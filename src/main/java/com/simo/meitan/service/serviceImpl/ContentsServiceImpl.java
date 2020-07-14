package com.simo.meitan.service.serviceImpl;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.simo.meitan.model.Contents;
import com.simo.meitan.mapper.ContentsMapper;
import com.simo.meitan.service.ContentsService;

@Service
public class ContentsServiceImpl implements ContentsService {

    @Resource
    private ContentsMapper contentsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return contentsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Contents record) {
        return contentsMapper.insert(record);
    }

    @Override
    public int insertSelective(Contents record) {
        return contentsMapper.insertSelective(record);
    }

    @Override
    public Contents selectByPrimaryKey(Integer id) {
        return contentsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Contents record) {
        return contentsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Contents record) {
        return contentsMapper.updateByPrimaryKey(record);
    }

	@Override
	public List<Contents> selectAllByBookid(Integer bookid){
		 return contentsMapper.selectAllByBookid(bookid);
	}




}




