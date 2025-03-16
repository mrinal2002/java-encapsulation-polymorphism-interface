// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Abstract method to calculate fare
    public abstract double calculateFare(double distance);

    // Concrete method to display vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }

    // Getter and Setter methods
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
}

// Interface GPS
interface GPS {
    String getCurrentLocation();

    void updateLocation(String newLocation);
}

// Subclass Car
class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return "Current Location: City Center";
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Location updated to: " + newLocation);
    }
}

// Main class to demonstrate polymorphism
public class RideHailingApplication {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Car("V001", "John Doe", 10);
        vehicle1.getVehicleDetails();
        System.out.println("Fare: " + vehicle1.calculateFare(5));
        System.out.println(((GPS) vehicle1).getCurrentLocation());
    }
}