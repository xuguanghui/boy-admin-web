package com.bootdo.boy.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.boy.domain.TrainerDO;
import com.bootdo.boy.service.TrainerService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;




/**
 * 教练表
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-22 21:17:42
 */
@Controller
@RequestMapping("/boy/trainer")
public class TrainerController {
	@Autowired
	private TrainerService trainerService;
	
	@GetMapping()
	String Trainer(){
	    return "boy/trainer/trainer";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TrainerDO> trainerList = trainerService.list(query);
		int total = trainerService.count(query);
		PageUtils pageUtils = new PageUtils(trainerList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "boy/trainer/add";
	}
	@GetMapping("/edit")
	String edit(Long id , Model model){
		TrainerDO trainer = trainerService.get(id);
		model.addAttribute("Trainer", trainer);
	    return "boy/trainer/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		TrainerDO trainer = trainerService.get(id);
		return R.ok().put("trainer", trainer);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( TrainerDO trainer){
		if(trainerService.save(trainer)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody TrainerDO trainer){
		trainerService.update(trainer);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(trainerService.remove(id)>0){
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
		trainerService.batchRemove(ids);
		
		return R.ok();
	}
	
}
