package com.car_crud;

public class Car {
   private int id;
   private String manufacturer,carName,Horsepower;

	public Car() {

	}

	public Car(int id, String manufacturer, String carName, String horsepower) {
		
		this.id = id;
		this.manufacturer = manufacturer;
		this.carName = carName;
		Horsepower = horsepower;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getHorsepower() {
		return Horsepower;
	}

	public void setHorsepower(String horsepower) {
		Horsepower = horsepower;
	}
	
}
