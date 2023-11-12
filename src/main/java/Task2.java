import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Task2 {
        public static void main(String[] args) {
            List<Integer> numbers = generateRandomNumbers(10, 1, 100);
            System.out.println("Вихідний набір чисел: " + numbers);
            long countEven = countEvenNumbers(numbers);
            System.out.println("Кількість парних чисел: " + countEven);
        }
        private static List<Integer> generateRandomNumbers(int count, int min, int max) {
            Random random = new Random();
            return random.ints(count, min, max + 1).boxed().collect(Collectors.toList());
        }

        private static long countEvenNumbers(List<Integer> numbers) {
            return numbers.stream()
                    .filter(num -> num % 2 == 0)
                    .count();
        }
    }

