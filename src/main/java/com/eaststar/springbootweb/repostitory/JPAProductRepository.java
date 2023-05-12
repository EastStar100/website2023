package com.eaststar.springbootweb.repostitory;

import com.eaststar.springbootweb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAProductRepository extends JpaRepository<Product, String> {

    //List<Teacher> listAllTeacher(Pageable pageable);

}
