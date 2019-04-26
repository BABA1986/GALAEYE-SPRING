package com.gala.urtube.modal.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "videoInfo")
public class videoInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long						mId;
	
	@Column(name = "videoid", nullable = false)
	private String						mVideoId;
	
	@Column(name = "categoryid", nullable = false)
    private Long						mCategoryId;
	
	@Column(name = "publishedon", nullable = false)
	private java.sql.Timestamp			mPublishedOn;
	
	videoInfo() {
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Timestamp sqlDate = new java.sql.Timestamp(utilDate.getTime());
	    mPublishedOn = sqlDate;
	}

	/**
	 * @return the mPublishedOn
	 */
	public java.sql.Timestamp getmPublishedOn() {
		return mPublishedOn;
	}

	/**
	 * @param mPublishedOn the mPublishedOn to set
	 */
	public void setmPublishedOn(java.sql.Timestamp mPublishedOn) {
		this.mPublishedOn = mPublishedOn;
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
	 * @return the mVideoId
	 */
	public String getmVideoId() {
		return mVideoId;
	}

	/**
	 * @param mVideoId the mVideoId to set
	 */
	public void setmVideoId(String mVideoId) {
		this.mVideoId = mVideoId;
	}

	/**
	 * @return the mCategoryId
	 */
	public Long getmCategoryId() {
		return mCategoryId;
	}

	/**
	 * @param mCategoryId the mCategoryId to set
	 */
	public void setmCategoryId(Long mCategoryId) {
		this.mCategoryId = mCategoryId;
	}
	
	
}
