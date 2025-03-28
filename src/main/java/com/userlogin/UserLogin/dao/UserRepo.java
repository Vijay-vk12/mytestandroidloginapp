package com.userlogin.UserLogin.dao;

import com.userlogin.UserLogin.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepo  extends CrudRepository<User,Integer> {


     @Query(value="Select email from users where email = :email ",nativeQuery = true)
     List<String> checkUserEmail(@Param("email") String email);

    @Query(value="Select password from users where email = :email ",nativeQuery = true)
    String checkUserPasswordByEmail(@Param("email") String email);

    @Query(value="Select * from users where email = :email ",nativeQuery = true)
    User getAllDetailsByUserEmail(@Param("email") String email);


    @Transactional
    @Modifying
    @Query(value="INSERT INTO users (first_name,last_name,email,password,created_date) values (:first_name,:last_name,:email,:password,:date)",nativeQuery = true)
    int registerNewUser(@Param("first_name")String first_name,@Param("last_name")String last_name,
                        @Param("email")String email,@Param("password")String password,@Param("date") LocalDateTime currentDate);
}
