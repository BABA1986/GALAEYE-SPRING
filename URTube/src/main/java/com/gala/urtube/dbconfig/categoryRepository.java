package com.gala.urtube.dbconfig;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gala.urtube.modal.category.videoCategory;

public interface categoryRepository extends CrudRepository<videoCategory, Long>{
	@Modifying
	@Transactional
	@Query("select e from videoCategory e where mCountryCode = ?1 ORDER BY mCategoryIndex ASC")
	ArrayList<videoCategory> getCategoryForCountry(String countryCode);
}
