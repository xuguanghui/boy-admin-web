package com.bootdo.boy.controller;

import com.bootdo.boy.domain.AdminDO;
import com.bootdo.boy.domain.SchoolDO;
import com.bootdo.boy.domain.SchoolTrainerDO;
import com.bootdo.boy.domain.TrainerDO;
import com.bootdo.boy.service.SchoolService;
import com.bootdo.boy.service.TrainerService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
	private static final Logger logger = LoggerFactory.getLogger(TrainerController.class);
	@Autowired
	private TrainerService trainerService;
	@Autowired
	private SchoolService schoolService;
	
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
	String add(Model model){
		Map<String,Object> param = new HashMap<>();

		List<SchoolDO> schoolList = schoolService.list(param);
		model.addAttribute("schoolList",schoolList);
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
		try{
			AdminDO currUser = ShiroUtils.getUser();
			SchoolTrainerDO schoolTrainerDO = new SchoolTrainerDO();
			trainer.setUserAdd((currUser == null)?0L:currUser.getId());
			if(trainerService.save(trainer)>0){
				return R.ok();
			}
		}catch (Exception e){
			logger.error(" TrainerDO save error" + e.getMessage());
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
