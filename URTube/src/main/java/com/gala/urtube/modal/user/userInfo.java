package com.gala.urtube.modal.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "usertable")
public class userInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long			mId;
	
	@Column(name = "user_id", nullable = false)
	private Long			mUserId;
	
	@Column(name = "username")
	private String			mUserName;
	
	@Column(name = "useremail", nullable = false)
	private String			mUserEmail;
	
	@Column(name = "userpicurl")
	private String			mUserPicUrl;
	
	@Column(name = "isactive")
	private boolean			mIsActive;
	
	@Column(name = "devicetoken")
	private String			mDeviceToken;
	
	@OneToOne (targetEntity = pnStatistics.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private pnStatistics	mPNStatistics;
	
	userInfo() {
		if(this.mPNStatistics  != null)
			return;
			
		this.mPNStatistics = new pnStatistics();		
		this.mPNStatistics.setmFailureCount((long) 0);
		this.mPNStatistics.setmSuccessCount((long) 0);
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    this.mPNStatistics.setmLastSuccessDeliveryAt(sqlDate);
	}
	
	/**
	 * @return the mPNStatistics
	 */
	public pnStatistics getmPNStatistics() {
		return mPNStatistics;
	}

	/**
	 * @param mPNStatistics the mPNStatistics to set
	 */
	public void setmPNStatistics(pnStatistics aPNStatistics) {
		this.mPNStatistics  = aPNStatistics;
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
	 * @return the mUserId
	 */
	public Long getmUserId() {
		return mUserId;
	}

	/**
	 * @param mUserId the mUserId to set
	 */
	public void setmUserId(Long mUserId) {
		this.mUserId = mUserId;
	}

	/**
	 * @return the mUserName
	 */
	public String getmUserName() {
		return mUserName;
	}

	/**
	 * @param mUserName the mUserName to set
	 */
	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}

	/**
	 * @return the mUserEmail
	 */
	public String getmUserEmail() {
		return mUserEmail;
	}

	/**
	 * @param mUserEmail the mUserEmail to set
	 */
	public void setmUserEmail(String mUserEmail) {
		this.mUserEmail = mUserEmail;
	}

	/**
	 * @return the mUserPicUrl
	 */
	public String getmUserPicUrl() {
		return mUserPicUrl;
	}

	/**
	 * @param mUserPicUrl the mUserPicUrl to set
	 */
	public void setmUserPicUrl(String mUserPicUrl) {
		this.mUserPicUrl = mUserPicUrl;
	}

	/**
	 * @return the mIsActive
	 */
	public boolean getmIsActive() {
		return mIsActive;
	}

	/**
	 * @param mIsActive the mIsActive to set
	 */
	public void setmIsActive(boolean mIsActive) {
		this.mIsActive = mIsActive;
	}

	/**
	 * @return the mDeviceToken
	 */
	public String getmDeviceToken() {
		return mDeviceToken;
	}

	/**
	 * @param mDeviceToken the mDeviceToken to set
	 */
	public void setmDeviceToken(String mDeviceToken) {
		this.mDeviceToken = mDeviceToken;
	}
}
