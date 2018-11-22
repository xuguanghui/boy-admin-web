package com.bootdo.boy.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;



/**
 * 学校表
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-20 13:05:37
 */
public class SchoolDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Double longitude;
	//
	private Double latitude;
	//
	private String name;
	//
	private String address;
	//
	private String deleteIt;
	//添加人
	private Long userAdd;
	//添加人名称
	private String userAddname;
	//修改人
	private Long modify;

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
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：
	 */
	public Double getLongitude() {
		return longitude;
	}
	/**
	 * 设置：
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：
	 */
	public Double getLatitude() {
		return latitude;
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
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：
	 */
	public String getAddress() {
		return address;
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
	 * 设置：添加人
	 */
	public void setUserAdd(Long userAdd) {
		this.userAdd = userAdd;
	}
	/**
	 * 获取：添加人
	 */
	public Long getUserAdd() {
		return userAdd;
	}
	/**
	 * 设置：修改人
	 */
	public void setModify(Long modify) {
		this.modify = modify;
	}
	/**
	 * 获取：修改人
	 */
	public Long getModify() {
		return modify;
	}

	public String getUserAddname() {
		return userAddname;
	}

	public void setUserAddname(String userAddname) {
		this.userAddname = userAddname;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("longitude", longitude)
				.append("latitude", latitude)
				.append("name", name)
				.append("address", address)
				.append("deleteIt", deleteIt)
				.append("userAdd", userAdd)
				.append("userAddname", userAddname)
				.append("modify", modify)
				.toString();
	}
}
