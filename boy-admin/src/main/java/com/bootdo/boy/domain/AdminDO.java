package com.bootdo.boy.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;



/**
 * 后台管理员账号
 * 
 * @author xgh
 * @email ***
 * @date 2018-11-20 13:05:37
 */
public class AdminDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String username;
	//
	private String pwd;
	//
	private Date mtime;
	//
	private Date utime;
	//
	private String deleteIt;

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
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * 获取：
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * 设置：
	 */
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	/**
	 * 获取：
	 */
	public Date getMtime() {
		return mtime;
	}
	/**
	 * 设置：
	 */
	public void setUtime(Date utime) {
		this.utime = utime;
	}
	/**
	 * 获取：
	 */
	public Date getUtime() {
		return utime;
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

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("username", username)
				.append("pwd", pwd)
				.append("mtime", mtime)
				.append("utime", utime)
				.append("deleteIt", deleteIt)
				.toString();
	}
}
