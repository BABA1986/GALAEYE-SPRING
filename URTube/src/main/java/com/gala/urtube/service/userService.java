package com.gala.urtube.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;

import com.gala.urtube.modal.user.pnStatistics;
import com.gala.urtube.modal.user.userInfo;

public interface userService {
	public ResponseEntity<HashMap<String, Object>> addUser(userInfo userInfo);
	public ResponseEntity<HashMap<String, Object>> deleteUser(userInfo userInfo);
	public ArrayList<userInfo> allUsers();
	public pnStatistics pnStatistics(userInfo userInfo);
}
