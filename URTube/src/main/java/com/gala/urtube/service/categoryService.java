package com.gala.urtube.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.gala.urtube.modal.category.videoCategory;
import com.gala.urtube.modal.category.videoInfo;
import com.gala.urtube.modal.menu.countryInfo;

public interface categoryService {
	public ArrayList<videoCategory>getAllCategoryForCountry(countryInfo aCountryInfo);
	public Page<videoInfo> getVideosForCategory(Long categoryId, Pageable pageable);
	public ResponseEntity<HashMap<String, Object>> addEditCategory(videoCategory category);
	public ResponseEntity<HashMap<String, Object>> deleteCategory(videoCategory category);
	public ResponseEntity<HashMap<String, Object>> deleteVideos(ArrayList<videoInfo> videos);
	public ResponseEntity<HashMap<String, Object>> addVideos(ArrayList<videoInfo> videos);
}
