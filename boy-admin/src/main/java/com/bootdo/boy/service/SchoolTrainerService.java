package com.bootdo.boy.service;

import com.bootdo.boy.domain.SchoolTrainerDO;

import java.util.List;
import java.util.Map;

/**
 * 学校教练关联表
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-23 12:50:01
 */
public interface SchoolTrainerService {
	
	SchoolTrainerDO get(Long schoolId);
	
	List<SchoolTrainerDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SchoolTrainerDO schoolTrainer);
	
	int update(SchoolTrainerDO schoolTrainer);
	
	int remove(Long schoolId);
	
	int batchRemove(Long[] schoolIds);
	int removeByTrainerId(Long trainerId);
}
