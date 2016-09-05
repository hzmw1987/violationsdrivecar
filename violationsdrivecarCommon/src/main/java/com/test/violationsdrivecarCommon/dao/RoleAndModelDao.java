package com.test.violationsdrivecarCommon.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.test.violationsdrivecarCommon.model.RoleAndModel;



@Component
public interface RoleAndModelDao extends CrudRepository<RoleAndModel, Integer>{

	@Query("SELECT o.modelId FROM RoleAndModel o WHERE o.roleId IN (:roleId)")
	public List<Integer> findModelIdByRoleId(@Param("roleId") Integer roleIds);


}
