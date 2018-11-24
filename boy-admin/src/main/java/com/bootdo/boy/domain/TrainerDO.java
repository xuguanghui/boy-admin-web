package com.bootdo.boy.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;


/**
 * 教练表
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-22 21:17:42
 */
public class TrainerDO extends BaseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String name;
	//
	private String shortDesc;
	//
	private String pic;
	//
	private Long userAdd;
	//
	private Long modify;
	//
	private String deleteIt;
	//教练手机
	private String mobile;
	private String schoolName;
	private Long schoolId;
	private List<Long> schoolIds;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	/**
	 * 获取：
	 */
	public String getShortDesc() {
		return shortDesc;
	}
	/**
	 * 设置：
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * 获取：
	 */
	public String getPic() {
		return pic;
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
	 * 设置：教练手机
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：教练手机
	 */
	public String getMobile() {
		return mobile;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("name", name)
				.append("shortDesc", shortDesc)
				.append("pic", pic)
				.append("userAdd", userAdd)
				.append("modify", modify)
				.append("deleteIt", deleteIt)
				.append("mobile", mobile)
				.append("schoolName", schoolName)
				.append("schoolId", schoolId)
				.toString();
	}

	public List<Long> getSchoolIds() {
		return schoolIds;
	}

	public void setSchoolIds(List<Long> schoolIds) {
		this.schoolIds = schoolIds;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}
