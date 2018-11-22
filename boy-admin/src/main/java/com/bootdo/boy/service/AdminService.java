package com.bootdo.boy.service;

import com.bootdo.boy.domain.AdminDO;

import java.util.List;
import java.util.Map;

/**
 * 后台管理员账号
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-20 13:05:37
 */
public interface AdminService {
	
	AdminDO get(Long id);
	
	List<AdminDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AdminDO admin);
	
	int update(AdminDO admin);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	boolean exit(Map<String, Object> params);
}
