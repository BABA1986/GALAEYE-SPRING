package com.gala.urtube.dbconfig;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gala.urtube.modal.menu.countryInfo;

@Repository
public interface countryRepository extends CrudRepository<countryInfo, Long>{

}
