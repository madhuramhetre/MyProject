package com.model;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class RoleModel {
	private Integer roleId;
	private String roleName;
	private String roleType;
	private Date startDate;
	private Date endDate;
	private int resourceId;
	
	public RoleModel() {
		super();
	}
	public RoleModel(Integer roleId, String roleName, String roleType, Date startDate, Date endDate, int resourceId) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleType = roleType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.resourceId = resourceId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	
}
