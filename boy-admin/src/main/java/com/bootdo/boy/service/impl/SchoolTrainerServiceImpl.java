package com.bootdo.boy.service.impl;

import com.bootdo.boy.dao.SchoolTrainerMapper;
import com.bootdo.boy.domain.SchoolTrainerDO;
import com.bootdo.boy.service.SchoolTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class SchoolTrainerServiceImpl implements SchoolTrainerService {
	@Autowired
	private SchoolTrainerMapper schoolTrainerMapper;
	
	@Override
	public SchoolTrainerDO get(Long schoolId){
		return schoolTrainerMapper.get(schoolId);
	}
	
	@Override
	public List<SchoolTrainerDO> list(Map<String, Object> map){
		return schoolTrainerMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return schoolTrainerMapper.count(map);
	}
	
	@Override
	public int save(SchoolTrainerDO schoolTrainer){
		return schoolTrainerMapper.save(schoolTrainer);
	}
	
	@Override
	public int update(SchoolTrainerDO schoolTrainer){
		return schoolTrainerMapper.update(schoolTrainer);
	}
	
	@Override
	public int remove(Long schoolId){
		return schoolTrainerMapper.remove(schoolId);
	}
	
	@Override
	public int batchRemove(Long[] schoolIds){
		return schoolTrainerMapper.batchRemove(schoolIds);
	}
	
}
