package com.test.violationsdrivecarCommon.dao;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.test.violationsdrivecarCommon.model.User;



@Component
public interface UserDao extends CrudRepository<User, Integer>{

	@Query("SELECT o FROM User o WHERE o.userName = (:name)")
	public User getUserByName(@Param("name") String name);

	@Modifying
	@Transactional
	@Query("UPDATE  User o set o.updatedAt = now() , o.requestIp = (:requestIp) where o.userName = (:userName)")
	void updateUserLoginTime(@Param("requestIp") String requestIp,
			                 @Param("userName") String user);

}
