package com.zcadmin.entity;
// Generated 2016-5-1 17:34:38 by Hibernate Tools 4.3.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ProjectView generated by hbm2java
 */
@Entity
@Table(name = "project_view", catalog = "gmczc")
public class ProjectView implements java.io.Serializable {

	private ProjectViewId id;

	public ProjectView() {
	}

	public ProjectView(ProjectViewId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "projectId", column = @Column(name = "project_id", nullable = false) ),
			@AttributeOverride(name = "projectOwnerId", column = @Column(name = "project_owner_id", nullable = false, length = 10) ),
			@AttributeOverride(name = "projectOwnerName", column = @Column(name = "project_owner_name", nullable = false, length = 20) ),
			@AttributeOverride(name = "projectOwnerAvatar", column = @Column(name = "project_owner_avatar", length = 100) ),
			@AttributeOverride(name = "projectTitle", column = @Column(name = "project_title", nullable = false, length = 80) ),
			@AttributeOverride(name = "projectClass", column = @Column(name = "project_class", nullable = false, length = 10) ),
			@AttributeOverride(name = "projectHead", column = @Column(name = "project_head", length = 100) ),
			@AttributeOverride(name = "projectDescription", column = @Column(name = "project_description", nullable = false, length = 150) ),
			@AttributeOverride(name = "projectContent", column = @Column(name = "project_content", nullable = false) ),
			@AttributeOverride(name = "projectAddressProvince", column = @Column(name = "project_address_province", nullable = false, length = 10) ),
			@AttributeOverride(name = "projectAddressCity", column = @Column(name = "project_address_city", nullable = false, length = 10) ),
			@AttributeOverride(name = "projectMoney", column = @Column(name = "project_money", nullable = false) ),
			@AttributeOverride(name = "projectMoneyRecive", column = @Column(name = "project_money_recive") ),
			@AttributeOverride(name = "projectDays", column = @Column(name = "project_days", nullable = false) ),
			@AttributeOverride(name = "projectStart", column = @Column(name = "project_start", length = 19) ),
			@AttributeOverride(name = "projectEnd", column = @Column(name = "project_end", length = 19) ),
			@AttributeOverride(name = "projectDayLeft", column = @Column(name = "project_day_left") ),
			@AttributeOverride(name = "projectState", column = @Column(name = "project_state", nullable = false, length = 20) ),
			@AttributeOverride(name = "projectProcess", column = @Column(name = "project_process", precision = 16) ) })
	public ProjectViewId getId() {
		return this.id;
	}

	public void setId(ProjectViewId id) {
		this.id = id;
	}

}
