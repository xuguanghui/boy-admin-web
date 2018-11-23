package com.bootdo.boy.domain;

import java.io.Serializable;



/**
 * 学校教练关联表
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-23 12:50:01
 */
public class SchoolTrainerDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long schoolId;
	//
	private Long trainerId;
	//
	private String deleteIt;
	//
	private Long userAdd;
	//
	private Long modify;
   private  String SchoolName ;
	/**
	 * 设置：
	 */
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	/**
	 * 获取：
	 */
	public Long getSchoolId() {
		return schoolId;
	}
	/**
	 * 设置：
	 */
	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}
	/**
	 * 获取：
	 */
	public Long getTrainerId() {
		return trainerId;
	}
	/**
	 * 设置：
	 */
	public void setDeleteIt(String deleteIt) {
		this.deleteIt = deleteIt;
	}
	/**
	 * 获取：
	 */
	public String getDeleteIt() {
		return deleteIt;
	}
	/**
	 * 设置：
	 */
	public void setUserAdd(Long userAdd) {
		this.userAdd = userAdd;
	}
	/**
	 * 获取：
	 */
	public Long getUserAdd() {
		return userAdd;
	}
	/**
	 * 设置：
	 */
	public void setModify(Long modify) {
		this.modify = modify;
	}
	/**
	 * 获取：
	 */
	public Long getModify() {
		return modify;
	}

	public String getSchoolName() {
		return SchoolName;
	}

	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}
}
