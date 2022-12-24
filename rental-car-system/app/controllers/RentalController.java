package controllers;

import models.Car;
import models.Rental;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Date;
import java.util.List;

public class RentalController extends Controller {
    public Result createRentalForm() {
        List<Car> cars = Car.find.all();
        return ok(views.html.createRental.render(cars));
    }

    public Result createRental(int carId, String customerName, Date startDate, Date endDate) {
        Car car = Car.find.byId(carId);
        if (car == null) {
            return notFound("Car not found");
        }

        Rental rental = new Rental(0, customerName, car, startDate, endDate);
        rental.save();
        return ok("Rental created successfully");
    }

    public Result listRentals() {
        List<Rental> rentals = Rental.find.all();
        return ok(views.html.listRentals.render(rentals));
    }

    public Result viewRental(int rentalId) {
        Rental rental = Rental.find.byId(rentalId);
        if (rental == null) {
            return notFound("Rental not found");
        }
        return ok(views.html.viewRental.render(rental));
    }

    public Result updateRentalForm(int rentalId) {
        Rental rental = Rental.find.byId(rentalId);
        if (rental == null) {
            return notFound("Rental not found");
        }
        return ok(views.html.updateRental.render(rental));
    }

    public Result updateRental(int rentalId, String customerName, Date startDate, Date endDate) {
        Rental rental = Rental.find.byId(rentalId);
        if (rental == null) {
            return notFound("Rental not found");
        }
        rental.setCustomerName(customerName);
        rental.setStartDate(startDate);
        rental.setEndDate(endDate);
        rental.update();
        return ok("Rental updated successfully");
    }

    public Result deleteRental(int rentalId) {
        Rental rental = Rental.find.byId(rentalId);
        if (rental == null) {
            return notFound("Rental not found");
        }
        rental.delete();
        return ok("Rental deleted successfully");
    }
}
