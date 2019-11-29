package com.cemal.loginproject1.dao.repo;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cemal.loginproject1.dao.model.User;




@Repository
public interface UserRepo extends CrudRepository<User,String> {

	User findByUsername(String username);

	User findByPassword(String password);
	
    @Query(value = "select u FROM User u where u.username= :username and u.password= :password")
	User findByUser(@Param("username") String username, @Param("password") String password);
	
	
	


	
  

}
