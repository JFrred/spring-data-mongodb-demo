package com.example;

import com.example.model.Car;
import com.example.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringMongodbDemoApplication  {
    private final CarRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbDemoApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        Car car0 = new Car("jaguar xe", 2010);
        Car car1 = new Car("golf IV", 2000);
        Car car2 = new Car("volvo v60", 2010);
        Car car3 = new Car("mazda 6", 2017);
        Car car4 = new Car("lexus rc", 2015);

        repository.saveAll(List.of(car0, car1, car2, car3, car4));
    }
}
