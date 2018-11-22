package com.bootdo.boy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.boy.dao.SchoolMapper;
import com.bootdo.boy.domain.SchoolDO;
import com.bootdo.boy.service.SchoolService;



@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolMapper schoolMapper;
	
	@Override
	public SchoolDO get(Long id){
		return schoolMapper.get(id);
	}
	
	@Override
	public List<SchoolDO> list(Map<String, Object> map){
		return schoolMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return schoolMapper.count(map);
	}
	
	@Override
	public int save(SchoolDO school){
		return schoolMapper.save(school);
	}
	
	@Override
	public int update(SchoolDO school){
		return schoolMapper.update(school);
	}
	
	@Override
	public int remove(Long id){
		return schoolMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return schoolMapper.batchRemove(ids);
	}
	
}
