package com.gala.urtube.dbconfig;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gala.urtube.modal.user.userInfo;

public interface userRepository  extends CrudRepository<userInfo, Long>{

	@Modifying
	@Transactional
	@Query("delete from userInfo e where mUserEmail = ?1")
	void deleteUserByEmail(String email);
	
	@Modifying
	@Transactional
	@Query("select e from userInfo e where mUserEmail = ?1")
	ArrayList<userInfo> getUsersByEmail(String email);
}
