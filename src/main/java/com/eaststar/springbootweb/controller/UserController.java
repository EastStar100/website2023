package com.eaststar.springbootweb.controller;

import com.eaststar.springbootweb.entity.Product;
import com.eaststar.springbootweb.entity.User;
import com.eaststar.springbootweb.service.ProductService;
import com.eaststar.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String start() {
        return "hello world!";
    }

    @Autowired
    private UserService service;

    @Autowired
    private ProductService productService;

    //list all users
    @GetMapping(value = "/list/users")
    public List<User> listAllUsers() {
        return service.listAllUser();
    }

    //get users by name
    @GetMapping(value = "/list/users/name")
    public List<User> listUsersByName(@RequestParam(value = "name") String name,
                                      @RequestParam(value = "page") int page,
                                      @RequestParam(value = "size_per_page") int sizePerPage) {
        return service.listUsersByName(name, page, sizePerPage);
    }

    //get a user by id
    @GetMapping(value = "/get/user")
    @ResponseBody
    public User getUserById(@RequestParam(value = "id") String id) {
        System.out.println(service.getUserById(id));
        return service.getUserById(id);
    }

    //create a user
    @PostMapping(value = "/create/user")
    public String createUser(@RequestParam(value = "id") String id,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "address") String address,
                             @RequestParam(value = "age") String age,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "flight_id") String flight_id,
                             @RequestParam(value = "seat_number") Integer seat_number,
                             @RequestParam(value = "phone_number") String phone_number
    ) {
        User user = new User(id, name);
        user.setAddress(address);
        user.setAge(age);
        user.setPhone(phone_number);
        user.setEmail(email);
        user.setFlight_id(flight_id);
        user.setSeat_number(seat_number);
        service.createUser(user);
        return user.getId() + " created";
    }

    @PostMapping(value = "/bookFlight")
    public void bookFlight(@RequestParam(value = "id") String id,
                           @RequestParam(value = "flight_id") String flight_id) {
        User user = service.getUserById(id);
        user.setFlight_id(flight_id);
        Product product = productService.getFlightById(flight_id);
        product.setSeats(product.getSeats() - 1);
        productService.createFlight(product);
        service.createUser(user);
    }

    @PutMapping(value = "/chooseSeat")
    public void chooseSeat(@RequestParam(value = "id") String id,
                           @RequestParam(value = "seat_number") Integer seat_number) {
        User user = service.getUserById(id);
        user.setSeat_number(seat_number);


        service.createUser(user);

    }

    //update a user's address
    @PutMapping(value = "/update/user")
    public void updateUser(@RequestParam(value = "id") String id, @RequestParam(value = "address") String address) {
        User user = service.getUserById(id);
        user.setAddress(address);
        service.createUser(user);
    }

    //delete a user
    @DeleteMapping(value = "/delete/user")
    public String removeUser(@RequestParam(value = "id") String id) {
        service.removeUser(id);
        return id + "  deleted";
    }

    @DeleteMapping(value = "/cancelFlight")
    public void cancelFlight(@RequestParam(value = "id") String id) {
        User user = service.getUserById(id);
        String flightId = user.getFlight_id();
        Product product = productService.getFlightById(flightId);
        product.setSeats(product.getSeats() + 1);
        user.setFlight_id(null);
        user.setSeat_number(null);
        productService.createFlight(product);
        service.createUser(user);
    }

    @GetMapping(value = "/seats")
    public String getSeats(@RequestParam(value = "flightId") String flightId) {
        Product product = productService.getFlightById(flightId);

        return product.getSeats() + " seats left  for flightId: " + flightId;
    }

//    @GetMapping(value = "/list/users")
//    public List<User> listAllUser(@RequestParam(value = "page") int page,
//                                        @RequestParam(value = "size_per_page") int sizePerPage){
//        return service.listAllUser(page,sizePerPage);
//    }


}
