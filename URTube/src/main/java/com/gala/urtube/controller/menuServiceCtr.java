package com.gala.urtube.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gala.urtube.modal.menu.countryInfo;
import com.gala.urtube.service.menuService;

@CrossOrigin
@RestController
public class menuServiceCtr {
	
	@Autowired
	menuService		mMenuService;
	
	@GetMapping("/api/menus")
	public ArrayList<countryInfo>getAllMenu(){
		return mMenuService.getAllMenu();
	}
	
	@PostMapping("/api/getMenuCountryWise")
	public countryInfo getMenuCountryWise(@RequestBody countryInfo countryObj)
	{
		return mMenuService.getCountryObj(countryObj);
	}
	
	@PostMapping("/api/addSubMenus")
	public ResponseEntity<HashMap<String, Object>> addSubMenus(@RequestBody countryInfo countryObj)
	{
		return mMenuService.addSubMenusForCountry(countryObj);
	}
	
	@PostMapping("/api/deleteSubMenus")
	public ResponseEntity<String> deleteSubMenus(@RequestBody countryInfo countryObj)
	{
		mMenuService.deleteSubMenusForCountry(countryObj);
		return  ResponseEntity.status(200).build();
	}
}
