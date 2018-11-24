package com.bootdo.boy.service.impl;

import com.bootdo.boy.domain.SchoolTrainerDO;
import com.bootdo.boy.service.SchoolTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.boy.dao.TrainerMapper;
import com.bootdo.boy.domain.TrainerDO;
import com.bootdo.boy.service.TrainerService;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TrainerServiceImpl implements TrainerService {
	@Autowired
	private TrainerMapper trainerMapper;
	@Autowired
	private SchoolTrainerService schoolTrainerService;
	@Override
	public TrainerDO get(Long id){
		TrainerDO trainerDO = trainerMapper.get(id);
		//获取绑定学校列表
		Map<String,Object> param = new HashMap<>();
		param.put("trainerId",id);
		List<SchoolTrainerDO> stList = schoolTrainerService.list(param);
		List<Long> schoolIds = new ArrayList<>();
		if(stList != null && stList.size() > 0){
			for (SchoolTrainerDO record:stList
				 ) {
				schoolIds.add(record.getSchoolId());
			}
		}
		trainerDO.setSchoolIds(schoolIds);

		return trainerDO;


	}
	
	@Override
	public List<TrainerDO> list(Map<String, Object> map){
		return trainerMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return trainerMapper.count(map);
	}
	@Transactional
	@Override
	public int save(TrainerDO trainer){
		int result = trainerMapper.save(trainer);
		//关联表新增记录
		SchoolTrainerDO schoolTrainerDO = new SchoolTrainerDO();
		schoolTrainerDO.setSchoolId(trainer.getSchoolId());
		schoolTrainerDO.setTrainerId(trainer.getId());
		schoolTrainerDO.setUserAdd(trainer.getUserAdd());
		result += schoolTrainerService.save(schoolTrainerDO);
		return result;
	}
	@Transactional
	@Override
	public int update(TrainerDO trainer){
		int result =  trainerMapper.update(trainer);
		schoolTrainerService.removeByTrainerId(trainer.getId());
		SchoolTrainerDO schoolTrainerDO = new SchoolTrainerDO();
		schoolTrainerDO.setSchoolId(trainer.getSchoolId());
		schoolTrainerDO.setTrainerId(trainer.getId());
		schoolTrainerDO.setUserAdd(trainer.getUserAdd());
		result += schoolTrainerService.save(schoolTrainerDO);
		return result;
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
