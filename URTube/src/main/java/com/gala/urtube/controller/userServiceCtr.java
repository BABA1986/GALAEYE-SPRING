package com.gala.urtube.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gala.urtube.modal.user.pnStatistics;
import com.gala.urtube.modal.user.userInfo;
import com.gala.urtube.service.userService;

@RestController
public class userServiceCtr {

	@Autowired		
	userService				mUserService;
	
	@PostMapping("/api/adduser")
	public ResponseEntity<HashMap<String, Object>> addUser(@RequestBody userInfo userInfo) {
		return mUserService.addUser(userInfo);
	}
	
	@PostMapping("/api/deleteuser")
	public ResponseEntity<HashMap<String, Object>> deleteUser(@RequestBody userInfo userInfo) {
		return mUserService.deleteUser(userInfo);
	}
	
	@GetMapping("/api/allusers")
	public ArrayList<userInfo> allUser() {
		return mUserService.allUsers();
	}
	
	@PostMapping("/api/getuserpnStatistics")
	public pnStatistics getPNStatForUser(@RequestBody userInfo userInfo) {
		return mUserService.pnStatistics(userInfo);
	}
}
