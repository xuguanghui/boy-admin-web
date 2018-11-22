package com.bootdo.boy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.boy.dao.TrainerMapper;
import com.bootdo.boy.domain.TrainerDO;
import com.bootdo.boy.service.TrainerService;



@Service
public class TrainerServiceImpl implements TrainerService {
	@Autowired
	private TrainerMapper trainerMapper;
	
	@Override
	public TrainerDO get(Long id){
		return trainerMapper.get(id);
	}
	
	@Override
	public List<TrainerDO> list(Map<String, Object> map){
		return trainerMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return trainerMapper.count(map);
	}
	
	@Override
	public int save(TrainerDO trainer){
		return trainerMapper.save(trainer);
	}
	
	@Override
	public int update(TrainerDO trainer){
		return trainerMapper.update(trainer);
	}
	
	@Override
	public int remove(Long id){
		return trainerMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return trainerMapper.batchRemove(ids);
	}
	
}
