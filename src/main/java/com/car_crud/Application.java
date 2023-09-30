package com.car_crud;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

@SpringBootApplication
@RestController
public class Application {
     
	private Map<Integer, Car> carMap = new LinkedHashMap<>();
	private AtomicInteger id = new AtomicInteger();
	
	//read
	@GetMapping("/cars")
	public Collection<Car> getAllcars() {
		Collection<Car> Allcars = carMap.values();
		return Allcars;
	}
	
	//post
	@PostMapping("/cars")
	public String addCar(@RequestBody Car car) {
		car.setId(id.incrementAndGet());
		carMap.put(car.getId(), car);
		return "car added successfully";
	}
	
	//Delete
	@DeleteMapping("/cars/{id}")
	public String Deletebycarid(@PathVariable int id) {
	 carMap.remove(id);
	 return "Car with id "+id+" deleted";
		
	}
	
	//Get by car id
	@GetMapping("/cars/{id}")
	public Car getCarbyid(@PathVariable int id) {
	  Car	Foundcar = carMap.get(id);
		return Foundcar;
	}
	
	//updating car
	@PutMapping("/cars/{id}")
	public Car updateCarbyid(@RequestBody Car car,@PathVariable int id) {
		car.setId(id);
		Car updatedCar = carMap.put(id, car);
		return updatedCar;
		}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
