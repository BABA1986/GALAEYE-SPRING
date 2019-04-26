package com.gala.urtube.dbconfig;


import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gala.urtube.modal.category.videoInfo;

@Repository
public interface videoRepository extends JpaRepository<videoInfo, Long>{
//	@Modifying
	@Transactional
	
	@Query("select e from videoInfo e where mCategoryId = ?1")
	Page<videoInfo> getVideosForCategoryPageable(@Param("categoryId") Long categoryId, Pageable pageRequest);
	
	@Query("select e from videoInfo e where e.mCategoryId like categoryId")
	ArrayList<videoInfo> getVideosForCategory(@Param("categoryId") Long categoryId);
}
