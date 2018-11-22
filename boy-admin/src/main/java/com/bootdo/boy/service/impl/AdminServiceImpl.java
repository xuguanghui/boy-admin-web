package com.bootdo.boy.service.impl;

import com.bootdo.boy.dao.AdminMapper;
import com.bootdo.boy.domain.AdminDO;
import com.bootdo.boy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public AdminDO get(Long id){
		return adminMapper.get(id);
	}
	
	@Override
	public List<AdminDO> list(Map<String, Object> map){
		return adminMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return adminMapper.count(map);
	}
	
	@Override
	public int save(AdminDO admin){
		return adminMapper.save(admin);
	}
	
	@Override
	public int update(AdminDO admin){
		return adminMapper.update(admin);
	}
	
	@Override
	public int remove(Long id){
		return adminMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return adminMapper.batchRemove(ids);
	}

	@Override
	public boolean exit(Map<String, Object> params) {
		boolean exit;
		exit = adminMapper.list(params).size() > 0;
		return exit;
	}

}
