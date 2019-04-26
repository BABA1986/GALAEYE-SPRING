package com.gala.urtube.dbconfig;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gala.urtube.modal.menu.menuInfo;


@Repository
public interface menuRepository extends CrudRepository<menuInfo, Long>{

}
