package com.gala.urtube.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gala.urtube.URTubeConstant;
import com.gala.urtube.urtubeValidator;
import com.gala.urtube.dbconfig.userRepository;
import com.gala.urtube.modal.user.userInfo;
import com.gala.urtube.service.userService;

@Service
public class userServiceImp implements userService{

	@Autowired
	userRepository			mUserRepository;
		
	@Override
	public ResponseEntity<HashMap<String, Object>> addUser(userInfo userInfo) {
		// TODO Auto-generated method stub

		HashMap<String, Object> lReturnDict = new HashMap<>();
		
		boolean lIsValidMail = urtubeValidator.isValidEmailAddress(userInfo.getmUserEmail());
		if(lIsValidMail == false) {
			lReturnDict.put(URTubeConstant.RESPONSE_CODE_KEY, URTubeConstant.INVALID_INPUT_CODE);
			lReturnDict.put(URTubeConstant.RESPONSE_MSG_KEY, URTubeConstant.EMAIL_INVALD_MSG);
			return new ResponseEntity<>(lReturnDict, HttpStatus.BAD_REQUEST);
		}
		
		ArrayList<userInfo> lUsers = mUserRepository.getUsersByEmail(userInfo.getmUserEmail());
		if(lUsers.size() > 0) {
			lReturnDict.put(URTubeConstant.RESPONSE_CODE_KEY, URTubeConstant.INVALID_INPUT_CODE);
			lReturnDict.put(URTubeConstant.RESPONSE_MSG_KEY, URTubeConstant.EMAIL_ALLREADY_REGISTERED);
			return new ResponseEntity<>(lReturnDict, HttpStatus.BAD_REQUEST);
		}
		
		mUserRepository.save(userInfo);
		
		lReturnDict.put(URTubeConstant.RESPONSE_CODE_KEY, URTubeConstant.SUCCESS_CODE);
		lReturnDict.put(URTubeConstant.RESPONSE_MSG_KEY, URTubeConstant.USER_ADDED_MSG);
		return new ResponseEntity<>(lReturnDict, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<HashMap<String, Object>> deleteUser(userInfo userInfo) {
		// TODO Auto-generated method stub
		mUserRepository.deleteUserByEmail(userInfo.getmUserEmail());
		HashMap<String, Object> lReturnDict = new HashMap<>();
		lReturnDict.put(URTubeConstant.RESPONSE_CODE_KEY, URTubeConstant.SUCCESS_CODE);
		lReturnDict.put(URTubeConstant.RESPONSE_MSG_KEY, URTubeConstant.USER_DELETE_MSG);
		return new ResponseEntity<>(lReturnDict, HttpStatus.OK);
	}

	@Override
	public ArrayList<userInfo> allUsers() {
		// TODO Auto-generated method stub
		return (ArrayList<userInfo>) mUserRepository.findAll();
	}
	
	@Override
	public com.gala.urtube.modal.user.pnStatistics pnStatistics(userInfo userInfo) {
		// TODO Auto-generated method stub
		ArrayList<userInfo> lUsers = mUserRepository.getUsersByEmail(userInfo.getmUserEmail());
		if(lUsers.size() > 0) {
			userInfo lUser = lUsers.get(0);
			return lUser.getmPNStatistics();
		}
		return null;
	}
}
