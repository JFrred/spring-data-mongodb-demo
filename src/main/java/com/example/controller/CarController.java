package com.example.controller;

import com.example.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final MongoTemplate mongoTemplate;

    @GetMapping
    public List<Car> getAll() {
        return mongoTemplate.findAll(Car.class, "car");
    }

    @GetMapping("/{id}")
    public Car getOne(@PathVariable String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        return mongoTemplate.findOne(query, Car.class);
    }

    @GetMapping("/period")
    public List<Car> getByProductionYear(@RequestParam int productionYear) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productionYear").is(productionYear));

        return mongoTemplate.find(query, Car.class);
    }

    @PostMapping
    public String insert(@RequestBody Car car) {
        String id = mongoTemplate.insert(car).getId();

        return "Car has been inserted with id=" +  id;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable String id, @RequestParam String newName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        Update update = new Update();
        update.set("name", newName);
        long modifiedCount = mongoTemplate.upsert(query, update, Car.class).getModifiedCount();

        return (modifiedCount == 1) ?
                String.format("Car with id=%s has been updated", id) :
                String.format("Couldn't update car with id=%s", id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        mongoTemplate.remove(query, Car.class);
        return "Car has been removed";
    }

}
