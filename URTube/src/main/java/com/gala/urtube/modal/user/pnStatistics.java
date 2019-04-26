package com.gala.urtube.modal.user;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "pnstattable")
public class pnStatistics {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long			mId;
	
	@Column(name = "successcount")
	private Long			mSuccessCount;
	
	@Column(name = "failurecount")
	private Long			mFailureCount;
	
	@Column(name = "lastsuccessdelivery")
	private Date			mLastSuccessDeliveryAt;
	
	@OneToOne(targetEntity = userInfo.class, optional = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonBackReference
    @JoinColumn(name = "userkiid", referencedColumnName = "id")
	private userInfo	mUserInfo;
	
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
	 * @return the mSuccessCount
	 */
	public Long getmSuccessCount() {
		return mSuccessCount;
	}

	/**
	 * @param mSuccessCount the mSuccessCount to set
	 */
	public void setmSuccessCount(Long mSuccessCount) {
		this.mSuccessCount = mSuccessCount;
	}

	/**
	 * @return the mFailureCount
	 */
	public Long getmFailureCount() {
		return mFailureCount;
	}

	/**
	 * @param mFailureCount the mFailureCount to set
	 */
	public void setmFailureCount(Long mFailureCount) {
		this.mFailureCount = mFailureCount;
	}

	/**
	 * @return the mLastSuccessDeliveryAt
	 */
	public Date getmLastSuccessDeliveryAt() {
		return mLastSuccessDeliveryAt;
	}

	/**
	 * @param mLastSuccessDeliveryAt the mLastSuccessDeliveryAt to set
	 */
	public void setmLastSuccessDeliveryAt(Date mLastSuccessDeliveryAt) {
		this.mLastSuccessDeliveryAt = mLastSuccessDeliveryAt;
	}
	
	/**
	 * @return the mUserInfo
	 */
	public userInfo getmUserInfo() {
		return mUserInfo;
	}

	/**
	 * @param mUserInfo the mUserInfo to set
	 */
	public void setmUserInfo(userInfo mUserInfo) {
		this.mUserInfo = mUserInfo;
	}
}
