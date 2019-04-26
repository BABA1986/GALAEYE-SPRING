package com.gala.urtube.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;

import com.gala.urtube.modal.menu.countryInfo;

public interface menuService {
	public ArrayList<countryInfo>getAllMenu();
	public countryInfo getCountryObj(countryInfo aCountryInfo);
	public ResponseEntity<HashMap<String, Object>> addSubMenusForCountry(countryInfo aCountryInfo);
	public boolean deleteSubMenusForCountry(countryInfo aCountryInfo);
}
