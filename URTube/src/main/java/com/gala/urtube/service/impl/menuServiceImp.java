package com.gala.urtube.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gala.urtube.URTubeConstant;
import com.gala.urtube.dbconfig.countryRepository;
import com.gala.urtube.dbconfig.menuRepository;
import com.gala.urtube.modal.menu.countryInfo;
import com.gala.urtube.modal.menu.menuInfo;
import com.gala.urtube.modal.menu.subMenuInfo;
import com.gala.urtube.service.menuService;

@Service
public class menuServiceImp implements menuService {

	@Autowired
	countryRepository mCountryRepository;
	@Autowired
	menuRepository mMenuRepository;

	@Override
	public ArrayList<countryInfo> getAllMenu() {
		return (ArrayList<countryInfo>) mCountryRepository.findAll();
	}

	@Override
	public countryInfo getCountryObj(countryInfo aCountryInfo) {
		ArrayList<countryInfo> lCountries = getAllMenu();
		countryInfo lCountryInList = findCountryInList(aCountryInfo, lCountries);
		return lCountryInList;
	}

	@Override
	public ResponseEntity<HashMap<String, Object>> addSubMenusForCountry(countryInfo aCountryInfo) {
		// TODO Auto-generated method stub
		ArrayList<countryInfo> lCountries = getAllMenu();
		countryInfo lCountryInList = findCountryInList(aCountryInfo, lCountries);
		if (lCountryInList == null) {
			countryInfo lSavedCountryInfo = mCountryRepository.save(aCountryInfo);
			HashMap<String, Object> lReturnDict = new HashMap<>();
			lReturnDict.put(URTubeConstant.RESPONSE_CODE_KEY, URTubeConstant.SUCCESS_CODE);
			lReturnDict.put(URTubeConstant.RESPONSE_MSG_KEY, URTubeConstant.CHANNELMENU_EDIT);
			lReturnDict.put(URTubeConstant.RESPONSE_Body, lSavedCountryInfo);
			return new ResponseEntity<>(lReturnDict, HttpStatus.OK);
		}

		Set<menuInfo> lMenus = aCountryInfo.getmMenus();
		for (menuInfo lMenuinfo : lMenus) {
			menuInfo lMenuInList = findMenuInList(lMenuinfo, lCountryInList.getmMenus());

			if (lMenuInList == null) {
				lCountryInList.getmMenus().add(lMenuinfo);
				continue;
			} else {
				lMenuInList.setmMenuTitle(lMenuinfo.getmMenuTitle());
			}

			Set<subMenuInfo> lSubMenus = lMenuinfo.getmSubMenus();
			if (lSubMenus != null) {
				for (subMenuInfo lSubMenuinfo : lSubMenus) {
					subMenuInfo lSubMenuInList = findSubMenuInList(lSubMenuinfo, lMenuInList.getmSubMenus());
					if (lSubMenuInList == null) {
						lMenuInList.getmSubMenus().add(lSubMenuinfo);
						continue;
					} else {
						lSubMenuInList = lSubMenuinfo;
					}
				}
			}
		}

		countryInfo lSavedCountryInfo = mCountryRepository.save(lCountryInList);
		HashMap<String, Object> lReturnDict = new HashMap<>();
		lReturnDict.put(URTubeConstant.RESPONSE_CODE_KEY, URTubeConstant.SUCCESS_CODE);
		lReturnDict.put(URTubeConstant.RESPONSE_MSG_KEY, URTubeConstant.CHANNELMENU_EDIT);
		lReturnDict.put(URTubeConstant.RESPONSE_Body, lSavedCountryInfo);
		return new ResponseEntity<>(lReturnDict, HttpStatus.OK);
	}

	@Override
	public boolean deleteSubMenusForCountry(countryInfo aCountryInfo) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<countryInfo> lCountries = getAllMenu();
		countryInfo lCountryInList = findCountryInList(aCountryInfo, lCountries);
		if (lCountryInList == null) {
			return true;
		}

		Set<menuInfo> lMenus = aCountryInfo.getmMenus();
		if (lMenus == null) {
			mCountryRepository.delete(lCountryInList);
			return true;
		}

		for (menuInfo lMenuinfo : lMenus) {
			menuInfo lMenuInList = findMenuInList(lMenuinfo, lCountryInList.getmMenus());
			if ((lMenuInList != null && lMenuInList.getmSubMenus().size() <= 0)
					|| (lMenuinfo.getmSubMenus().size() == 0)) {
				lCountryInList.getmMenus().remove(lMenuInList);
				continue;
			}

			Set<subMenuInfo> lSubMenus = lMenuinfo.getmSubMenus();
			if (lSubMenus != null) {
				for (subMenuInfo lSubMenuinfo : lSubMenus) {
					subMenuInfo lSubMenuInList = findSubMenuInList(lSubMenuinfo, lMenuInList.getmSubMenus());
					if (lSubMenuInList != null) {
						lMenuInList.getmSubMenus().remove(lSubMenuInList);
						continue;
					}
				}
			}
		}

		if (lCountryInList.getmMenus().size() <= 0 || aCountryInfo.getmMenus().size() <= 0) {
			mCountryRepository.delete(lCountryInList);
			return true;
		}

		mCountryRepository.save(lCountryInList);
		return false;
	}

	private countryInfo findCountryInList(countryInfo aCountryInfo, ArrayList<countryInfo> aCountries) {
		countryInfo lRetCountryInfo = null;
		for (countryInfo lCountryInfo : aCountries) {
			if (lCountryInfo.getmCountryCode().equals(aCountryInfo.getmCountryCode())) {
				lRetCountryInfo = lCountryInfo;
				break;
			}
		}
		return lRetCountryInfo;
	}

	private menuInfo findMenuInList(menuInfo aMenuInfo, Set<menuInfo> aMenus) {
		menuInfo lRetMenuInfo = null;
		for (menuInfo lMenuInfo : aMenus) {
			if (lMenuInfo.getmId().equals(aMenuInfo.getmId())) {
				lRetMenuInfo = lMenuInfo;
				break;
			}
		}
		return lRetMenuInfo;
	}

	private subMenuInfo findSubMenuInList(subMenuInfo aSubMenuInfo, Set<subMenuInfo> aSubMenus) {
		subMenuInfo lRetSubMenuInfo = null;
		for (subMenuInfo lSubMenuInfo : aSubMenus) {
			if (lSubMenuInfo.getmId().equals(aSubMenuInfo.getmId())) {
				lRetSubMenuInfo = lSubMenuInfo;
				break;
			}
		}
		return lRetSubMenuInfo;
	}
}
