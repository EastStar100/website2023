package com.eaststar.springbootweb.repostitory;


import com.eaststar.springbootweb.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAUserRepository extends JpaRepository<User, String> {

    //List<User> findUserByName(String name);
    List<User> findUserByName(String name, Pageable pageable);

    //List<User> listAllUsers(Pageable pageable);

}
