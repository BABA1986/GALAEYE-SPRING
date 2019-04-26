package com.gala.urtube.service.impl;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gala.urtube.URTubeConstant;
import com.gala.urtube.dbconfig.categoryRepository;
import com.gala.urtube.dbconfig.videoRepository;
import com.gala.urtube.modal.category.videoCategory;
import com.gala.urtube.modal.category.videoInfo;
import com.gala.urtube.modal.menu.countryInfo;
import com.gala.urtube.service.categoryService;

@Service
public class categoryServiceImp implements categoryService{
	
	@Autowired
	categoryRepository			mCategoryRepo;
	@Autowired
	videoRepository				mVideoRepo;

	@Override
	public ArrayList<videoCategory>getAllCategoryForCountry(countryInfo aCountryInfo) {
		// TODO Auto-generated method stub
		ArrayList<videoCategory> lCategories = (ArrayList<videoCategory>) mCategoryRepo.getCategoryForCountry(aCountryInfo.getmCountryCode());
		return lCategories;
	}
	
	@Override
	public Page<videoInfo> getVideosForCategory(Long categoryId, Pageable pageRequest) {
		// TODO Auto-generated method stub
		Page<videoInfo> lPageInfo = mVideoRepo.getVideosForCategoryPageable(categoryId, pageRequest); 
//		Page<videoInfo> lPageInfo = mVideoRepo.findAll(pageRequest);//(categoryId, pageRequest);
		return lPageInfo;
	}

	@Override
	public ResponseEntity<HashMap<String, Object>> addEditCategory(videoCategory category) {
		// TODO Auto-generated method stub
		if(category.getmCategoryIndex() == null) {
			category.setmCategoryIndex((long) 0);
		}
		ArrayList<videoCategory> lCategories = (ArrayList<videoCategory>) mCategoryRepo.getCategoryForCountry(category.getmCountryCode());
		int lIndex = 0;
		for (videoCategory lCategory: lCategories) {
			if (category.getmCategoryIndex() == null || category.getmCategoryIndex() == 0 || lIndex >= category.getmCategoryIndex())
			{
				lCategory.setmCategoryIndex((long) (lIndex + 1));
				 mCategoryRepo.save(lCategory);
			}
			lIndex = lIndex+1;
		}
		videoCategory lSavedCat = mCategoryRepo.save(category);
		HashMap<String, Object> lReturnDict = new HashMap<>();
		lReturnDict.put(URTubeConstant.RESPONSE_CODE_KEY, URTubeConstant.INVALID_INPUT_CODE);
		lReturnDict.put(URTubeConstant.RESPONSE_MSG_KEY, URTubeConstant.CATEGORY_ADDED);
		lReturnDict.put(URTubeConstant.RESPONSE_Body, lSavedCat);
		return new ResponseEntity<>(lReturnDict, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<HashMap<String, Object>> deleteCategory(videoCategory category) {
		// TODO Auto-generated method stub
		ArrayList<videoInfo> lVideos = mVideoRepo.getVideosForCategory(category.getmCategoryId());
		deleteVideos(lVideos);
		mCategoryRepo.delete(category);
		
		HashMap<String, Object> lReturnDict = new HashMap<>();
		lReturnDict.put(URTubeConstant.RESPONSE_CODE_KEY, URTubeConstant.INVALID_INPUT_CODE);
		lReturnDict.put(URTubeConstant.RESPONSE_MSG_KEY, URTubeConstant.CATEGORY_DELETED);
		return new ResponseEntity<>(lReturnDict, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<HashMap<String, Object>> addVideos(ArrayList<videoInfo> videos) {
		// TODO Auto-generated method stub
		ArrayList<videoInfo> lSavedVideos = new ArrayList<videoInfo>();
		for(videoInfo lVideoInfo : videos) {
			videoInfo lSavedVideoInfo = mVideoRepo.save(lVideoInfo);
			lSavedVideos.add(lSavedVideoInfo);
		}
		HashMap<String, Object> lReturnDict = new HashMap<>();
		lReturnDict.put(URTubeConstant.RESPONSE_CODE_KEY, URTubeConstant.INVALID_INPUT_CODE);
		lReturnDict.put(URTubeConstant.RESPONSE_MSG_KEY, URTubeConstant.VIDEO_ADDED);
		lReturnDict.put(URTubeConstant.RESPONSE_Body, lSavedVideos);
		return new ResponseEntity<>(lReturnDict, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<HashMap<String, Object>> deleteVideos(ArrayList<videoInfo> videos) {
		// TODO Auto-generated method stub
		for(videoInfo lVideoInfo : videos) {
			mVideoRepo.delete(lVideoInfo);
		}
		HashMap<String, Object> lReturnDict = new HashMap<>();
		lReturnDict.put(URTubeConstant.RESPONSE_CODE_KEY, URTubeConstant.INVALID_INPUT_CODE);
		lReturnDict.put(URTubeConstant.RESPONSE_MSG_KEY, URTubeConstant.VIDEO_DELETED);
		return new ResponseEntity<>(lReturnDict, HttpStatus.OK);
	}
}
