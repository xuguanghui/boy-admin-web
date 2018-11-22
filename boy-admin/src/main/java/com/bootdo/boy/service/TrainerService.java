package com.bootdo.boy.service;

import com.bootdo.boy.domain.TrainerDO;

import java.util.List;
import java.util.Map;

/**
 * 教练表
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-22 21:17:42
 */
public interface TrainerService {
	
	TrainerDO get(Long id);
	
	List<TrainerDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TrainerDO trainer);
	
	int update(TrainerDO trainer);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
