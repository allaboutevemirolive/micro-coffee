package com.example.coffee_service.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("API/coffee")
public class CoffeeController {

    private List<Coffee> coffeeList = new ArrayList<>(Arrays.asList(
            new Coffee(1, "Americano", Size.GRANDE),
            new Coffee(2, "Latte", Size.VENTI),
            new Coffee(3, "Macchiato", Size.TALL)));

    @GetMapping
    public List<Coffee> findAll() {
        return coffeeList;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        coffeeList.removeIf(c -> c.getId().equals(id));
    }

    public class Coffee {
        private Integer id;
        private String name;
        private Size size;

        public Coffee(Integer id, String name, Size size) {
            this.id = id;
            this.name = name;
            this.size = size;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Size getSize() {
            return size;
        }

        public void setSize(Size size) {
            this.size = size;
        }

    }

    public enum Size {
        SHORT,
        TALL,
        GRANDE,
        VENTI
    }
}
