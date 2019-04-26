package com.gala.urtube.modal.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "videoCategory")
public class videoCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "categoryid", nullable = false)
	private Long						mCategoryId;

	@Column(name = "categoryname", nullable = false)
	private String						mCategoryName;
	
	@Column(name = "categoryindex", nullable = true)
	private Long						mCategoryIndex;

	@Column(name = "categoryforcountry", nullable = false)
	private String						mCountryCode;
	
	@Column(name = "videolimit", nullable = true)
	private Long						mVideoCount;

	/**
	 * @return the mCategoryIndex
	 */
	public Long getmCategoryIndex() {
		return mCategoryIndex;
	}

	/**
	 * @param mCategoryIndex the mCategoryIndex to set
	 */
	public void setmCategoryIndex(Long mCategoryIndex) {
		this.mCategoryIndex = mCategoryIndex;
	}
	
	/**
	 * @return the mId
	 */
	public Long getmCategoryId() {
		return mCategoryId;
	}

	/**
	 * @param mId the mId to set
	 */
	public void setmCategoryId(Long mId) {
		this.mCategoryId = mId;
	}

	/**
	 * @return the mCategoryName
	 */
	public String getmCategoryName() {
		return mCategoryName;
	}

	/**
	 * @param mCategoryName the mCategoryName to set
	 */
	public void setmCategoryName(String mCategoryName) {
		this.mCategoryName = mCategoryName;
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
	 * @return the mVideoCount
	 */
	public Long getmVideoCount() {
		return mVideoCount;
	}

	/**
	 * @param mVideoCount the mVideoCount to set
	 */
	public void setmVideoCount(Long mVideoCount) {
		this.mVideoCount = mVideoCount;
	}
}
