package com.test.violationsdrivecarCommon.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.test.violationsdrivecarCommon.model.Role;
import com.test.violationsdrivecarCommon.model.User;



@Component
public interface RoleDao extends CrudRepository<Role, Integer>{

	
	


}
