package oleksandra.nikitiuk.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private final static int  ALIQUOT = 3;

    public static void main(String[] args) {
        String userInput;

        do {
            System.out.println(
                    "\nPlease choose task number: \n" +
                    "Task 1\n" +
                    "Task 2\n" +
                    "Task 3\n" +
                    "Press 'q' to quit\n"
            );
            Scanner scanner = new Scanner(System.in);

            userInput = scanner.nextLine();

            if (userInput.equals("1")) {

                hello();

            } else if (userInput.equals("2")) {

                helloWithName();

            } else if (userInput.equals("3")) {
                System.out.println(
                        "1. Use default numbers: 1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 14, 15, 16, 18, 20, 21\n" +
                        "2. Custom numbers\n");

                scanner = new Scanner(System.in);

                userInput = scanner.nextLine();

                if(userInput.equals("1")) {
                    final List<Integer> defaultNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 14, 15, 16, 18, 20, 21);

                    List<Integer> resultList = aliquotOfNumber(defaultNumbers, 3);

                    printResultNumbers(resultList);

                } else if(userInput.equals("2")) {
                    System.out.println("Provide numbers and separate it with comma than hit Enter:\n");

                    scanner = new Scanner(System.in);

                    userInput = scanner.nextLine();

                    List<Integer> intNumbers = parseStringNumbers(userInput);

                    List<Integer> resultList = aliquotOfNumber(intNumbers, ALIQUOT);

                    printResultNumbers(resultList);
                }
            }
        } while(!userInput.equalsIgnoreCase("q"));

        System.exit(0);
    }

    //Task1
    public static void hello() {
        System.out.println("Please enter a number: ");
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        List<Integer> nums = parseStringNumbers(userInput);

        if(nums.size() > 0 && nums.get(0) > 7) {
            System.out.println("Hello");
        } else {
            System.out.println("Ups, not matched..");
        }
    }

    //Task2
    public static void helloWithName() {
        String name = "Vyacheslav";
        System.out.println("Please enter a name (correct name is " + name + "): ");
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();

        if (name.equals(inputName)){
            System.out.println("Hello " + name + "!");
        } else {
            System.out.println("There is no such name as " + inputName);
        }
    }
    // Task3
    public static List<Integer> aliquotOfNumber(List<Integer> numbers, int aliquot) {

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < numbers.size(); i++){
            int num = numbers.get(i);
            if(num % aliquot == 0) {
                res.add(num);
            }
        }

        return res;
    }

    private static List<Integer> parseStringNumbers(String stringNumbers) {
        return Arrays.stream(stringNumbers.split(","))
                .map(el -> el.trim())
                .filter(el -> el.matches("^[0-9]*$"))
                .map(num -> Integer.parseInt(num))
                .collect(Collectors.toList());
    }

    private static void printResultNumbers(List<Integer> resultList) {
        resultList.forEach(num -> System.out.println(num));
    }
}
