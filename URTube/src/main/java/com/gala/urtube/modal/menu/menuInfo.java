package com.gala.urtube.modal.menu;

import java.util.Set;

import javax.persistence.CascadeType;

//import java.util.Collection;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "menutable")
public class menuInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long						mId;
	
	@Column(name = "menutitle")
	private String						mMenuTitle;
		
	@Column(name = "menuicon")
	private String						mMenuIcon;
	
	@Column(name = "menuindex", nullable = true)
	private Long						mMenuIndex;
	
	@ManyToOne(targetEntity = countryInfo.class, optional = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name = "country_id", referencedColumnName = "id")
    private countryInfo					mCountryInfo;
	
	@OneToMany (targetEntity = subMenuInfo.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@Column(name = "submenus", nullable = true)
	@Valid
	private Set<subMenuInfo>		mSubMenus;

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
	 * @return the mCountryInfo
	 */
	public countryInfo getmCountryInfo() {
		return mCountryInfo;
	}
	/**
	 * @param mCountryInfo the mCountryInfo to set
	 */
	public void setmCountryInfo(countryInfo mCountryInfo) {
		this.mCountryInfo = mCountryInfo;
	}

	public String getmMenuTitle() {
		return mMenuTitle;
	}
	public void setmMenuTitle(String mMenuTitle) {
		this.mMenuTitle = mMenuTitle;
	}
	public String getmMenuIcon() {
		return mMenuIcon;
	}
	public void setmMenuIcon(String mMenuIcon) {
		this.mMenuIcon = mMenuIcon;
	}
	public Set<subMenuInfo> getmSubMenus() {
		return mSubMenus;
	}
	public void setmSubMenus(Set<subMenuInfo> mSubMenus) {
		this.mSubMenus = mSubMenus;
	}
}
