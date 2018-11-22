package com.bootdo.boy.controller;

import com.bootdo.boy.domain.AdminDO;
import com.bootdo.boy.service.AdminService;
import com.bootdo.common.utils.MD5Utils;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 后台管理员账号
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-20 13:05:37
 */
@Controller
@RequestMapping("/boy/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping()
	//@RequiresPermissions("boy:admin")
	String Admin(){
	    return "boy/admin/admin";
	}
	
	@ResponseBody
	@GetMapping("/list")

	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AdminDO> adminList = adminService.list(query);
		int total = adminService.count(query);
		PageUtils pageUtils = new PageUtils(adminList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "boy/admin/add";
	}
	@GetMapping("/edit")
	String edit(Long id, Model model){
		AdminDO admin = adminService.get(id);
		model.addAttribute("Admin", admin);
	    return "boy/admin/edit";
	}
	/**
	 * 判断重复
	 */
	@PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
		// Query query = new Query(params);
		return !adminService.exit(params);// 存在，不通过，false
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		AdminDO admin = adminService.get(id);
		return R.ok().put("admin", admin);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	//@RequiresPermissions("boy:save")
	public R save( AdminDO admin){
		admin.setPwd(MD5Utils.encrypt(admin.getUsername(), admin.getPwd()));
		if(adminService.save(admin)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody AdminDO admin){
		adminService.update(admin);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(adminService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Long[] ids){
		adminService.batchRemove(ids);
		
		return R.ok();
	}
	
}
