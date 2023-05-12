package com.eaststar.springbootweb.service;

import com.eaststar.springbootweb.entity.Product;
import com.eaststar.springbootweb.repostitory.JPAProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private JPAProductRepository jpaProductRepository;



    //list all flights
    public List<Product> listAllFlight() {
        return jpaProductRepository.findAll();
    }


    //get a flight by id
    public Product getFlightById(String id) {
        Optional<Product> load = jpaProductRepository.findById(id);
        if (load.isPresent()) {
            return load.get();
        }
        return null;
    }

    //create a flight
    public void createFlight(Product product) {
        jpaProductRepository.save(product);
    }

    //delete a flight
    public void removeFlight(String id) {
        if (id == null) {
            System.out.println("Flight id is null !");
        }else {
            jpaProductRepository.deleteById(id);
        }
    }

//    public void addStudent(Flight flight, Student student) {
//        jpaFlightRepository.addStudent(flight,student);
//    }

//    public List<Flight> listAllFlight(int page, int sizePerPage) {
//        Pageable pageable = PageRequest.of(page, sizePerPage, Sort.by("id"));
//        return jpaFlightRepository.listAllFlight(pageable);
//    }
}
