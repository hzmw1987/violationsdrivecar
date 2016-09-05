package com.test.violationsdrivecarCommon.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.test.violationsdrivecarCommon.model.CmModel;



@Component
public interface CmModelDao extends CrudRepository<CmModel, Integer>{

	@Query("SELECT o FROM CmModel o WHERE o.modelId IN (SELECT c.modelId FROM RoleAndModel c WHERE c.roleId IN (:roleId)) AND status = 1")
	public List<CmModel> findModelByModelIds(@Param("roleId") Integer roleId);


}
