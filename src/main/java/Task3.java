import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static class Car {
        private String modelName;
        private int year;
        private double price;
        private String color;
        private double engineVolume;

        public Car(String modelName, int year, double price, String color, double engineVolume) {
            this.modelName = modelName;
            this.year = year;
            this.price = price;
            this.color = color;
            this.engineVolume = engineVolume;
        }

        public String getModelName() {
            return modelName;
        }

        public int getYear() {
            return year;
        }

        public double getPrice() {
            return price;
        }

        public String getColor() {
            return color;
        }

        public double getEngineVolume() {
            return engineVolume;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "modelName='" + modelName + '\'' +
                    ", year=" + year +
                    ", price=" + price +
                    ", color='" + color + '\'' +
                    ", engineVolume=" + engineVolume +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("Toyota Camry", 2023, 45000.0, "Blue", 2.5),
                new Car("Honda Accord", 2022, 58000.0, "Red", 2.0),
                new Car("Ford Mustang", 2020, 85000.0, "Black", 5.0),
                new Car("BMW 328", 2022, 23000.0, "White", 1.8)
        );

        System.out.println("Всі автомобілі:");
        displayCars(cars);

        System.out.println("\nАвтомобілі червоного кольору:");
        displayCarsByColor(cars, "Red");

        System.out.println("\nАвтомобілі дорожчі за 30000:");
        displayCarsMoreExpensiveThan(cars, 30000.0);

        System.out.println("\nАвтомобілі випущені у 2021-2022 роках:");
        displayCarsByYearRange(cars, 2021, 2022);

        System.out.println("\nСортування автомобілів за зменшенням вартості:");
        List<Car> sortedCars = sortCarsByPriceDescending(cars);
        displayCars(sortedCars);
    }

    private static void displayCars(List<Car> cars) {
        cars.forEach(System.out::println);
    }

    private static void displayCarsByColor(List<Car> cars, String color) {
        List<Car> filteredCars = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());

        displayCars(filteredCars);
    }

    private static void displayCarsMoreExpensiveThan(List<Car> cars, double price) {
        List<Car> filteredCars = cars.stream()
                .filter(car -> car.getPrice() > price)
                .collect(Collectors.toList());

        displayCars(filteredCars);
    }

    private static void displayCarsByYearRange(List<Car> cars, int startYear, int endYear) {
        List<Car> filteredCars = cars.stream()
                .filter(car -> car.getYear() >= startYear && car.getYear() <= endYear)
                .collect(Collectors.toList());

        displayCars(filteredCars);
    }

    private static List<Car> sortCarsByPriceDescending(List<Car> cars) {
        return cars.stream()
                .sorted((car1, car2) -> Double.compare(car2.getPrice(), car1.getPrice()))
                .collect(Collectors.toList());
    }
}