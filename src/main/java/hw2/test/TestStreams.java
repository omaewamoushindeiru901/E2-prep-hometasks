package hw2.test;

import hw2.models.Employee;
import hw2.models.FilterEmployees;
import log.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreams {

    Log log = new Log(TestLambda.class.getName());
    private final ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

    public TestStreams firstExercise(){
        ArrayList<Integer> filtered = new ArrayList<>();
        Stream.of(120,410,85,32,314,12).limit(3)
                .map(n -> n < 300 ? n + 11 : n)
                .forEach(filtered::add);
        log.log(filtered + "\n");
        return this;
    }

    public TestStreams secondExercise(){
        Optional<String> first = Stream.of("red", "green", "blue")
                .sorted()
                .findFirst();
        log.log(first.get() + "\n");
        return this;
    }

    public TestStreams thirdExercise(){
        Optional<Integer> firstN = Stream.of(3, 4, 1, 40)
                .sorted()
                .findFirst();
        log.log(firstN.get() + "\n");
        return this;
    }

    public TestStreams fourthExercise(){
        ArrayList<String> filtered = new ArrayList<>();
        Stream.of("apple", "banana", "pear", "cherry", "pineapple")
                .filter((n) -> n.startsWith("p"))
                .forEach(filtered::add);
        log.log(filtered + "\n");
        return this;
    }

    public TestStreams fifthExercise(){
        ArrayList<String> filtered = new ArrayList<>();
        Stream.of("Java", "Rocks")
                .map(String::toUpperCase)
                .forEach(filtered::add);
        log.log(filtered + "\n");
        return this;
    }

    public TestStreams sixthExercise(){
        ArrayList<Integer> filtered = new ArrayList<>();
        Stream.of(1.5, 2.3, 3.7)
                .mapToInt(Double::intValue)
                .forEach(filtered::add);
        log.log(filtered + "\n");
        return this;
    }

    public TestStreams seventhExercise(){
        ArrayList<Integer> numbers7 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Optional<Integer> findFirst = numbers7.stream().parallel()
                .filter((n) -> n < 4)
                .findFirst();

        Optional<Integer> findAny = numbers7.stream().parallel()
                .filter((n) -> n < 4)
                .findAny();
        log.log("Find first: " + findFirst.get() + "\n");
        log.log("Find any: " + findAny.get() + "\n");
        return this;
    }

    public TestStreams eighthExercise(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 10000, "Naruto"));
        employees.add(new Employee(3, 99999, "Bandera"));
        employees.add(new Employee(4, 25000, "Andrijko"));
        employees.add(new Employee(20, 27, "Ostap"));
        employees.add(new Employee(10, 1000, "Ostap"));

        FilterEmployees filterByid = (Employee employee) -> (employee.getId()<10) && (employee.getName().startsWith("A"));
        FilterEmployees filterBySalary = (Employee employee) -> (employee.getSalary()<10000);

        log.log(employees.stream().allMatch(filterByid::filterEmployee) + "\n");
        log.log(employees.stream().anyMatch(filterByid::filterEmployee) + "\n");
        log.log(employees.stream().allMatch(filterBySalary::filterEmployee) + "\n");
        log.log(employees.stream().anyMatch(filterBySalary::filterEmployee) + "\n");

        return this;
    }

    public TestStreams ninthExercise(){
        ArrayList<Integer> filtered = new ArrayList<>();
        arr.stream()
                .filter((n) -> n%2==0)
                .skip(2)
                .forEach(filtered::add);
        log.log(filtered + "\n");
        return this;
    }

    public TestStreams tenthExercise(){
        ArrayList<Integer> filtered = new ArrayList<>();
        arr.stream()
                .filter((n) -> n%2==0)
                .limit(2)
                .forEach(filtered::add);
        log.log(filtered + "\n");
        return this;
    }

    public TestStreams eleventhExercise(){
        ArrayList<Integer> filtered = new ArrayList<>();
        Stream.of(5,4,6,8,4,10,2,23,4).sorted().forEach(filtered::add);
        log.log(filtered + "\n");
        return this;
    }

    public TestStreams twelfthExercise(){
        ArrayList<Integer> filtered = Stream.of(4,1,5,1,2,3,3,4,5,5).sorted().distinct().collect(Collectors.toCollection(ArrayList::new));
        log.log(filtered + "\n");
        return this;
    }

    public TestStreams thirteenthExercise(){
        ArrayList<String> numbers13 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        numbers13.stream().sequential().forEach(e -> System.out.print(e + " "));
        System.out.println();
        numbers13.parallelStream().forEach(e -> System.out.print(e + " "));
        return this;
    }
}
