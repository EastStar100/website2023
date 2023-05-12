package com.eaststar.springbootweb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Flight")
public class Product {
    @Id
    @Column(name = "flight_id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;



    @Column(name = "seats")
    private Integer seats;

    public Integer getSeats() {
        return seats;
    }

    public Product(String id, String name, String address, Integer seats) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.seats = seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Product() {
    }


    public Product(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "flight{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
