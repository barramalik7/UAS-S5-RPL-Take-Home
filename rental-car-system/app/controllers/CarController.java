package controllers;

import models.Car;
import play.mvc.Controller;
import play.mvc.Result;

public class CarController extends Controller {
    public Result addCars() {
        Car car1 = new Car(1, "Toyota", "Corolla", 2018, 50.0);
        car1.save();
        Car car2 = new Car(2, "Honda", "Civic", 2017, 45.0);
        car2.save();
        Car car3 = new Car(3, "Ford", "Fiesta", 2016, 40.0);
        car3.save();
        Car car4 = new Car(4, "Mazda", "3", 2015, 35.0);
        car4.save();
        Car car5 = new Car(5, "Nissan", "Sentra", 2014, 30.0);
        car5.save();
        Car car6 = new Car(6, "Hyundai", "Elantra", 2013, 25.0);
        car6.save();
        Car car7 = new Car(7, "Subaru", "Impreza", 2012, 20.0);
        car7.save();
        Car car8 = new Car(8, "Kia", "Forte", 2011, 15.0);
        car8.save();
        Car car9 = new Car(9, "Volkswagen", "Jetta", 2010, 10.0);
        car9.save();
        Car car10 = new Car(10, "Chevrolet", "Cruze", 2009, 5.0);
        car10.save();
        return ok("Cars added successfully");

        // Return a "success" message
        return ok("Car created successfully");

    }

}
