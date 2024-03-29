package com.zcadmin.entity;
// Generated 2016-5-1 17:34:38 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Project generated by hbm2java
 */
@Entity
@Table(name = "project", catalog = "gmczc")
public class Project implements java.io.Serializable {

	private Integer projectId;
	private String projectOwner;
	private String projectTitle;
	private String projectHead;
	private String projectDescription;
	private byte[] projectContent;
	private String projectClass;
	private String projectAddressProvince;
	private String projectAddressCity;
	private int projectMoney;
	private Integer projectMoneyRecive;
	private int projectDays;
	private Date projectStart;
	private String projectState;

	public Project() {
	}

	public Project(String projectOwner, String projectTitle, String projectDescription, byte[] projectContent,
			String projectClass, String projectAddressProvince, String projectAddressCity, int projectMoney,
			int projectDays, String projectState) {
		this.projectOwner = projectOwner;
		this.projectTitle = projectTitle;
		this.projectDescription = projectDescription;
		this.projectContent = projectContent;
		this.projectClass = projectClass;
		this.projectAddressProvince = projectAddressProvince;
		this.projectAddressCity = projectAddressCity;
		this.projectMoney = projectMoney;
		this.projectDays = projectDays;
		this.projectState = projectState;
	}

	public Project(String projectOwner, String projectTitle, String projectHead, String projectDescription,
			byte[] projectContent, String projectClass, String projectAddressProvince, String projectAddressCity,
			int projectMoney, Integer projectMoneyRecive, int projectDays, Date projectStart, String projectState) {
		this.projectOwner = projectOwner;
		this.projectTitle = projectTitle;
		this.projectHead = projectHead;
		this.projectDescription = projectDescription;
		this.projectContent = projectContent;
		this.projectClass = projectClass;
		this.projectAddressProvince = projectAddressProvince;
		this.projectAddressCity = projectAddressCity;
		this.projectMoney = projectMoney;
		this.projectMoneyRecive = projectMoneyRecive;
		this.projectDays = projectDays;
		this.projectStart = projectStart;
		this.projectState = projectState;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "project_id", unique = true, nullable = false)
	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Column(name = "project_owner", nullable = false, length = 10)
	public String getProjectOwner() {
		return this.projectOwner;
	}

	public void setProjectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}

	@Column(name = "project_title", nullable = false, length = 80)
	public String getProjectTitle() {
		return this.projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	@Column(name = "project_head", length = 100)
	public String getProjectHead() {
		return this.projectHead;
	}

	public void setProjectHead(String projectHead) {
		this.projectHead = projectHead;
	}

	@Column(name = "project_description", nullable = false, length = 150)
	public String getProjectDescription() {
		return this.projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	@Column(name = "project_content", nullable = false)
	public byte[] getProjectContent() {
		return this.projectContent;
	}

	public void setProjectContent(byte[] projectContent) {
		this.projectContent = projectContent;
	}

	@Column(name = "project_class", nullable = false, length = 10)
	public String getProjectClass() {
		return this.projectClass;
	}

	public void setProjectClass(String projectClass) {
		this.projectClass = projectClass;
	}

	@Column(name = "project_address_province", nullable = false, length = 10)
	public String getProjectAddressProvince() {
		return this.projectAddressProvince;
	}

	public void setProjectAddressProvince(String projectAddressProvince) {
		this.projectAddressProvince = projectAddressProvince;
	}

	@Column(name = "project_address_city", nullable = false, length = 10)
	public String getProjectAddressCity() {
		return this.projectAddressCity;
	}

	public void setProjectAddressCity(String projectAddressCity) {
		this.projectAddressCity = projectAddressCity;
	}

	@Column(name = "project_money", nullable = false)
	public int getProjectMoney() {
		return this.projectMoney;
	}

	public void setProjectMoney(int projectMoney) {
		this.projectMoney = projectMoney;
	}

	@Column(name = "project_money_recive")
	public Integer getProjectMoneyRecive() {
		return this.projectMoneyRecive;
	}

	public void setProjectMoneyRecive(Integer projectMoneyRecive) {
		this.projectMoneyRecive = projectMoneyRecive;
	}

	@Column(name = "project_days", nullable = false)
	public int getProjectDays() {
		return this.projectDays;
	}

	public void setProjectDays(int projectDays) {
		this.projectDays = projectDays;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "project_start", length = 19)
	public Date getProjectStart() {
		return this.projectStart;
	}

	public void setProjectStart(Date projectStart) {
		this.projectStart = projectStart;
	}

	@Column(name = "project_state", nullable = false, length = 20)
	public String getProjectState() {
		return this.projectState;
	}

	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}

}
