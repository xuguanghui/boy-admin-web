package com.bootdo.boy.service;

import com.bootdo.boy.domain.SchoolDO;

import java.util.List;
import java.util.Map;

/**
 * 学校表
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-20 13:05:37
 */
public interface SchoolService {
	
	SchoolDO get(Long id);
	
	List<SchoolDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SchoolDO school);
	
	int update(SchoolDO school);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
