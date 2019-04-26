package com.gala.urtube.modal.menu;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gala.urtube.modal.mediaSrcType;
import com.gala.urtube.modal.mediaType;

@Entity
@Table(name = "submenutable")
public class subMenuInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long						mId;
	
	@Column(name = "submenutitle")
	private String						mSubMenuTitle;
		
	@Column(name = "submenuicon")
	private String						mSubMenuIcon;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "mediatype")
	private mediaType					mMediaType;	
	
	@Column(name = "mediasrc")
	private String						mMediaSrc;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "mediasrctype")
	private mediaSrcType				mMediaSrcType;

	@ManyToOne(targetEntity = menuInfo.class, optional = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name = "menuid", referencedColumnName = "id")
    private menuInfo					mMenuInfo;

	
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
	 * @return the mSubMenuTitle
	 */
	public String getmSubMenuTitle() {
		return mSubMenuTitle;
	}

	/**
	 * @param mSubMenuTitle the mSubMenuTitle to set
	 */
	public void setmSubMenuTitle(String mSubMenuTitle) {
		this.mSubMenuTitle = mSubMenuTitle;
	}

	/**
	 * @return the mSubMenuIcon
	 */
	public String getmSubMenuIcon() {
		return mSubMenuIcon;
	}

	/**
	 * @param mSubMenuIcon the mSubMenuIcon to set
	 */
	public void setmSubMenuIcon(String mSubMenuIcon) {
		this.mSubMenuIcon = mSubMenuIcon;
	}

	/**
	 * @return the mMediaType
	 */
	public mediaType getmMediaType() {
		return mMediaType;
	}

	/**
	 * @param mMediaType the mMediaType to set
	 */
	public void setmMediaType(mediaType mMediaType) {
		this.mMediaType = mMediaType;
	}

	/**
	 * @return the mMediaSrc
	 */
	public String getmMediaSrc() {
		return mMediaSrc;
	}

	/**
	 * @param mMediaSrc the mMediaSrc to set
	 */
	public void setmMediaSrc(String mMediaSrc) {
		this.mMediaSrc = mMediaSrc;
	}

	/**
	 * @return the mMediaSrcType
	 */
	public mediaSrcType getmMediaSrcType() {
		return mMediaSrcType;
	}

	/**
	 * @param mMediaSrcType the mMediaSrcType to set
	 */
	public void setmMediaSrcType(mediaSrcType mMediaSrcType) {
		this.mMediaSrcType = mMediaSrcType;
	}

	/**
	 * @return the mMenuInfo
	 */
	public menuInfo getmMenuInfo() {
		return mMenuInfo;
	}

	/**
	 * @param mMenuInfo the mMenuInfo to set
	 */
	public void setmMenuInfo(menuInfo mMenuInfo) {
		this.mMenuInfo = mMenuInfo;
	}
	
}
