package com.gala.urtube.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gala.urtube.modal.category.videoCategory;
import com.gala.urtube.modal.category.videoInfo;
import com.gala.urtube.modal.menu.countryInfo;
import com.gala.urtube.service.categoryService;

@CrossOrigin
@RestController
public class categoryServiceCtr {
	
	@Autowired 
	categoryService mCategoryService;
	
	@PostMapping("/api/categoriesInCountry")
	public ArrayList<videoCategory>getAllCategoriesForCountry(@RequestBody countryInfo aCountryInfo){
		return mCategoryService.getAllCategoryForCountry(aCountryInfo);
	}

	@PostMapping("/api/addVideosInCategory")
	public ResponseEntity<HashMap<String, Object>>addVideos(@RequestBody ArrayList<videoInfo> videos){
		return mCategoryService.addVideos(videos);
	}
	
	@PostMapping("/api/videosInCategory")
	public Page<videoInfo>getVideosForCategory(@RequestBody HashMap<String, Long> requestBody){
		Long lCategoryId = requestBody.get("categoryId");
		Long lPageIndex = requestBody.get("pageIndex");
		Long lPageSize = requestBody.get("pageSize");
		Sort lSort = new Sort(Direction.DESC,"mPublishedOn");
		Pageable lPageable = PageRequest.of(lPageIndex.intValue(), lPageSize.intValue(), lSort);
		return mCategoryService.getVideosForCategory(lCategoryId, lPageable);
	}
	
	@PostMapping("/api/addEditCategory")
	public ResponseEntity<HashMap<String, Object>> addEditCategory(@RequestBody videoCategory videoCategory)
	{
		return mCategoryService.addEditCategory(videoCategory);
	}
	
	@PostMapping("/api/deleteCategory")
	public ResponseEntity<HashMap<String, Object>> deleteCategory(@RequestBody videoCategory videoCategory)
	{
		return mCategoryService.deleteCategory(videoCategory);
	}
	
	@PostMapping("/api/deleteCategoryVideos")
	public ResponseEntity<HashMap<String, Object>> deleteVideos(@RequestBody ArrayList<videoInfo> videos)
	{
		mCategoryService.deleteVideos(videos);
		return  ResponseEntity.status(200).build();
	}
}
