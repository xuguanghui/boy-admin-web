package com.bootdo.boy.controller;

import com.bootdo.boy.domain.AdminDO;
import com.bootdo.boy.domain.SchoolDO;
import com.bootdo.boy.service.SchoolService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;




/**
 * 学校表
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-20 13:05:37
 */
@Controller
@RequestMapping("/boy/school")
public class SchoolController {
	@Autowired
	private SchoolService schoolService;
	
	@GetMapping()
	String School(){
	    return "boy/school/school";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SchoolDO> schoolList = schoolService.list(query);
		int total = schoolService.count(query);
		PageUtils pageUtils = new PageUtils(schoolList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "boy/school/add";
	}
	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id")Long id, Model model){
		SchoolDO school = schoolService.get(id);
		model.addAttribute("School", school);
	    return "boy/school/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		SchoolDO school = schoolService.get(id);
		return R.ok().put("school", school);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( SchoolDO school){
		AdminDO currUser = ShiroUtils.getUser();
		school.setUserAdd((currUser == null)?0L:currUser.getId());
		school.setDeleteIt("N");
		school.setModify(0L);
		if(schoolService.save(school)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public R update(SchoolDO school){

		AdminDO currUser = ShiroUtils.getUser();
		school.setModify((currUser == null)?0L:currUser.getId());
		schoolService.update(school);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(schoolService.remove(id)>0){
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
		schoolService.batchRemove(ids);
		
		return R.ok();
	}
	
}
