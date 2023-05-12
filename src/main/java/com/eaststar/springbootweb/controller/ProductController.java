package com.eaststar.springbootweb.controller;

import com.eaststar.springbootweb.entity.Product;
import com.eaststar.springbootweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    //create a flight
//    @PostMapping(value = "/create/flight")
//    public String createFlight(@RequestBody Flight flight) {
//        service.createFlight(flight);
//        return flight.getId() + " created";
//
//    }
    @PostMapping(value = "/create/flight")
    public String createFlight(@RequestParam(value = "id") String id,
                               @RequestParam(value = "name") String name,
                               @RequestParam(value = "address") String address

                               ) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setAddress(address);

        service.createFlight(product);
        return product.getId() + " created";

    }
    //list all flights
    @GetMapping(value = "/list/flights")
    public List<Product> listAllFlight() {
        return service.listAllFlight();
    }

    //get a flight by id
    @GetMapping(value = "/get/flight")
    @ResponseBody
    public Product getFlightById(@RequestParam(value = "id") String id) {
        return service.getFlightById(id);
    }

    //delete a flight
    @DeleteMapping(value = "/delete/flight")
    public String removeFlight(@RequestParam(value = "id") String id) {
        service.removeFlight(id);
        return id + "  deleted";
    }

    //    @GetMapping(value = "/list/flights")
//    public List<Flight> listAllFlight(@RequestParam(value = "page") int page,
//                                            @RequestParam(value = "size_per_page") int sizePerPage){
//        return service.listAllFlight(page,sizePerPage);
//    }
    //    @PostMapping(value = "/create/flight")
//    public void createFlight(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name,
//                              @RequestParam(value = "address") String address) {
//        System.out.println("flight");
//        Flight flight = new Flight(id, name, address);
//        service.createFlight(flight);
//    }
}
