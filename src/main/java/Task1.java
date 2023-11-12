import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Task1 {
    public static class Employee {
        private Integer ID;
        private String firstName;
        private String lastName;
        private boolean isManager;
        private double salary;

        public Employee(Integer ID, String firstName, String lastName, boolean isManager, double salary) {
            this.ID = ID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.isManager = isManager;
            this.salary = salary;
        }

        public Integer getID() {
            return ID;
        }

        public void setID(Integer ID) {
            this.ID = ID;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public boolean isManager() {
            return isManager;
        }

        public void setManager(boolean manager) {
            isManager = manager;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return ID + "," + firstName + "," + lastName + "," + (isManager ? "Y" : "N") + "," + salary;
        }
    }

    public static class FileUtilsEmployee {
        public static Map<Integer, Employee> getDataFromFile(String filePath) throws IOException {
            File file = new File(filePath);
            Map<Integer, Employee> result = Files.readAllLines(file.toPath(), Charset.defaultCharset())
                    .stream()
                    .skip(1)
                    .map(row -> {
                        String[] split = row.split(",");
                        Integer ID = Integer.parseInt(split[0]);
                        return new Employee(ID, split[1], split[2], "Y".equals(split[3]), Double.parseDouble(split[4]));
                    })
                    .collect(Collectors.toMap(Employee::getID, employee -> employee));

            return result;
        }
    }

    public static class ReadWriteMain {
        public static void main(String[] args) throws IOException {
            String inputFilePath = "src/main/employees_small.csv";
            Map<Integer, Employee> dataFromFile = FileUtilsEmployee.getDataFromFile(inputFilePath);
            List<Employee> sortedList = dataFromFile.values().stream()
                    .filter(employee -> !employee.isManager())
                    .sorted(Comparator.comparing(Employee::getLastName)
                            .thenComparing(Employee::getFirstName))
                    .collect(Collectors.toList());
            sortedList.forEach(System.out::println);
        }
    }
}