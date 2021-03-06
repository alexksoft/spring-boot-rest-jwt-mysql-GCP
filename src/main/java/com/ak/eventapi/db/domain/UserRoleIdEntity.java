package com.ak.eventapi.db.domain;
// Generated 02-Mar-2020 14:37:19 by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserRoleId generated by hbm2java
 */
@Embeddable
public class UserRoleIdEntity implements java.io.Serializable {

	private Integer appUser;
	private Integer appRole;

	public UserRoleIdEntity() {
	}

	public UserRoleIdEntity(Integer appUser, Integer appRole) {
		this.appUser = appUser;
		this.appRole = appRole;
	}

	@Column(name = "app_user")
	public Integer getAppUser() {
		return this.appUser;
	}

	public void setAppUser(Integer appUser) {
		this.appUser = appUser;
	}

	@Column(name = "app_role")
	public Integer getAppRole() {
		return this.appRole;
	}

	public void setAppRole(Integer appRole) {
		this.appRole = appRole;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRoleIdEntity))
			return false;
		UserRoleIdEntity castOther = (UserRoleIdEntity) other;

		return ((this.getAppUser() == castOther.getAppUser()) || (this.getAppUser() != null
				&& castOther.getAppUser() != null && this.getAppUser().equals(castOther.getAppUser())))
				&& ((this.getAppRole() == castOther.getAppRole()) || (this.getAppRole() != null
						&& castOther.getAppRole() != null && this.getAppRole().equals(castOther.getAppRole())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getAppUser() == null ? 0 : this.getAppUser().hashCode());
		result = 37 * result + (getAppRole() == null ? 0 : this.getAppRole().hashCode());
		return result;
	}

}
