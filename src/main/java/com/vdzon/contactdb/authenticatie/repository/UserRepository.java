package com.vdzon.contactdb.authenticatie.repository;

import com.vdzon.contactdb.authenticatie.data.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Qualifier(value = "userRepository")
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {


    @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username) AND LOWER(u.passwd) = LOWER(:passwd)")
    User findOne(@Param("username") String username, @Param("passwd") String passwd);

    @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
    User findOne(@Param("username") String username);

}
