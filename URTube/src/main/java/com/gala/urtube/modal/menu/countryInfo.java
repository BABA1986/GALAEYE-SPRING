package com.gala.urtube.modal.menu;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "countrytable")
public class countryInfo{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long						mId;
	
	@Column(name = "country_id", nullable = true)
	private Long						mCountryId;
	
	
	@Column(name = "countrycode", nullable = false)
	private String						mCountryCode;
	
	@OneToMany (targetEntity = menuInfo.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<menuInfo>     			mMenus;

	/**
	 * @return the mCountryId
	 */
	public Long getmCountryId() {
		return mCountryId;
	}

	/**
	 * @param mCountryId the mCountryId to set
	 */
	public void setmCountryId(Long mCountryId) {
		this.mCountryId = mCountryId;
	}

	/**
	 * @return the mCountryCode
	 */
	public String getmCountryCode() {
		return mCountryCode;
	}

	/**
	 * @param mCountryCode the mCountryCode to set
	 */
	public void setmCountryCode(String mCountryCode) {
		this.mCountryCode = mCountryCode;
	}

	/**
	 * @return the mId
	 */
	public Long getmId() {
		return mId;
	}

	/**
	 * @param mId the mId to set
	 */
	public void setmId(Long mId) {
		this.mId = mId;
	}

	/**
	 * @return the mMenus
	 */
	public Set<menuInfo> getmMenus() {
		return mMenus;
	}

	/**
	 * @param mMenus the mMenus to set
	 */
	public void setmMenus(Set<menuInfo> mMenus) {
		this.mMenus = mMenus;
	}

}
