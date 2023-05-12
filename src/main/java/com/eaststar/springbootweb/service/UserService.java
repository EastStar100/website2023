package com.eaststar.springbootweb.service;

import com.eaststar.springbootweb.entity.User;
import com.eaststar.springbootweb.repostitory.JPAUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private JPAUserRepository jpaUserRepository;


    //list all students
    public List<User> listAllUser() {
        return jpaUserRepository.findAll();
    }

    //create a student
    public void createUser(User user) {
        jpaUserRepository.save(user);

    }

    //delete a student
    public void removeUser(String id) {
        if (id == null) {
            System.out.println("User id is null !");
        }else {
            jpaUserRepository.deleteById(id);
        }

    }

    //get a student by id
    public User getUserById(String id) {
        Optional<User> load = jpaUserRepository.findById(id);
        if (load.isPresent()) {
            return load.get();
        }

        return null;
    }

    //get students by name
    public List<User> listUsersByName(String name, int page, int sizePerPage) {
        Pageable pageable = PageRequest.of(page, sizePerPage, Sort.by("id"));
        return jpaUserRepository.findUserByName(name, pageable);
    }
}
