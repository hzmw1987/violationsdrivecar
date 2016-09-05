package com.test.violationsdrivecarCommon.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.test.violationsdrivecarCommon.model.ViolationsOrder;



@Component
public interface ViolationsOrderDao extends CrudRepository<ViolationsOrder, Integer>,JpaSpecificationExecutor<ViolationsOrder>{

}
