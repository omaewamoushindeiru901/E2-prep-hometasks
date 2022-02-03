package hw2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        testDateTimeAPI();
        testLambda();
        testOptional();
        testStreams();
    }

    public static void testDateTimeAPI(){
        System.out.println("Print Zoned Date Time Now");
        ZonedDateTime timeNow = ZonedDateTime.now();
        System.out.println(timeNow);

        System.out.println("Print birthday");
        LocalDate birthdayTime = LocalDate.of(2002, Month.SEPTEMBER, 25);
        System.out.println(birthdayTime);

        System.out.println("Print Local Time");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        System.out.println("Print time span");
        // USE OF FUNCTIONAL INTERFACES IN DATETIME API
        CountPeriod countPeriod = (LocalDate start, LocalDate end) -> Period.between(end, start);
        LocalDate now = LocalDate.now();
        Period period = countPeriod.countPeriod(LocalDate.now(), now.plus(2, ChronoUnit.WEEKS));
        System.out.println(period);

        System.out.println("Print formatted date");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(now.format(formatter));

        System.out.println("Print number of days in the month");
        Month feb = Month.FEBRUARY;
        System.out.println(feb.length(true));

        System.out.println("Print formatted Zoned Date Time");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("EEE, dd-MM-yyyy HH:mm:ss zzz");
        System.out.println(timeNow.format(formatter2));

        System.out.println("\n===============================================\n");
    }

    public static void testLambda(){
        System.out.println("Concat two strings");
        BiFunction<String, String, String > concat = (String s1, String s2) -> s1.concat(" ").concat(s2);
        System.out.println(concat.apply("Hello", "There"));

        System.out.println("Print any 3 names with Hello");
        Consumer<String> greetings = (String s) -> {System.out.println("Hello, " + s + " <3");};
        greetings.accept("Ilona");
        greetings.accept("Nika");
        greetings.accept("Naruto");

        System.out.println("Print length of number");
        Function<Integer, Integer> len = (Integer number) -> {
            int count = 0;
            while (number!=0){
              number = number/10;
              count++;
            }
            return count;
        };
       System.out.println(len.apply(33));
       System.out.println(len.apply(545));
       System.out.println(len.apply(9999));
       System.out.println(len.apply(123456));

        BinaryOperator<Integer> add = (Integer n1, Integer n2) -> n1 + n2;
        UnaryOperator<Integer> increment = (Integer n) -> n + 1;
        System.out.println("Add operation");
        System.out.println(add.apply(2,2));
        System.out.println("Increment operation");
        System.out.println(increment.apply(2));

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Naruto", "Masashi", "Kishimoto", 300));
        books.add(new Book("Naruto", "NeMasashi", "NeKishimoto", 4000));
        books.add(new Book("Harry Potter","J.K.", "Rowling", 500));
        books.add(new Book("Shos", "Htos", "Htos", 2121));

        int sum = books.stream()
                .mapToInt(n -> n.getPages())
                .sum();
        System.out.println("Sum of all pages: " + sum);


        List<String> authors = books.stream()
                .map(a -> a.getAuthorName() + " " + a.getAuthorLName())
                .collect(Collectors.toList());
        System.out.println("Authors: " + authors);

        List<String> titlesWithDuplicate = books.stream()
                .map(a -> a.getTitle())
                .collect(Collectors.toList());
        System.out.println("Titles with duplicate: " + titlesWithDuplicate);

        Set<String> titlesWithoutDuplicate = books.stream()
                .map(a -> a.getTitle())
                .collect(Collectors.toSet());
        System.out.println("Titles without duplicate: " + titlesWithoutDuplicate);

        System.out.println("Sorted books:  ");
        books.stream()
                .sorted((b1,b2) -> b1.getPages().compareTo(b2.getPages()))
                .forEach(System.out::println);

        System.out.println("\n===========================================\n");
    }

    public static void testOptional(){
       try{
           Optional<String> emt = Optional.empty();
           System.out.println(emt.isPresent());
       } catch (Exception e){
           System.out.println("Exception");
       }

       Optional<String> val = Optional.of("qwerty");
       val.ifPresent(System.out::println);

       System.out.println("orElse: "+ val.orElse("Value is not present"));
       System.out.println("OrElseGet: " + val.orElseGet(() -> String.valueOf((int) (Math.random() * 10))));

       Optional<Integer> val2 = Optional.of(9999);
       System.out.println("Filtered: "+ val2.filter(n -> n%2==0));

       System.out.println("Transformed: " + val2.map( n -> n + 1).get());

       System.out.println("\n======================================\n");
    }

    public static void testStreams(){
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(120,410,85,32,314,12));
        numbers.stream()
                .filter((n) -> n < 300)
                .map((n) -> n + 11)
                .forEach(System.out::println);
        System.out.println();

        ArrayList<String> colors = new ArrayList<>(Arrays.asList("red", "green", "blue"));
        Optional<String> first = colors.stream()
                .sorted()
                .findFirst();
        System.out.println(first.get() + "\n");

        ArrayList<Integer> numbers3 = new ArrayList<>(Arrays.asList(3,4,1,40));
        Optional<Integer> firstN = numbers3.stream()
                .sorted()
                .findFirst();
        System.out.println(firstN.get() + "\n");

        ArrayList<String> fruits = new ArrayList<>(Arrays.asList("apple", "banana", "pear", "cherry", "pineapple"));
        fruits.stream()
                .filter((n) -> n.startsWith("p"))
                .forEach(System.out::println);
        System.out.println();

        ArrayList<String> words = new ArrayList<>(Arrays.asList("Java", "Rocks"));
        words.stream()
                .map((n) -> n.toUpperCase(Locale.ROOT))
                .forEach(System.out::println);
        System.out.println();

        ArrayList<Double> numbers6 = new ArrayList<>(Arrays.asList(1.5, 2.3, 3.7));
        numbers6.stream()
                .map((n) -> (n.intValue()))
                .forEach(System.out::println);
        System.out.println();

        ArrayList<Integer> numbers7 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Optional<Integer> findFirst = numbers7.stream()
                .filter((n) -> n < 4)
                .findFirst();
        Optional<Integer> findAny = numbers7.stream()
                .filter((n) -> n < 4)
                .findAny();
        System.out.println(findFirst.get());
        System.out.println(findAny.get() + "\n");

        // TODO 8

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        arr.stream()
                .filter((n) -> n%2==0)
                .skip(2)
                .forEach(System.out::println);
        System.out.println();

        arr.stream()
                .filter((n) -> n%2==0)
                .limit(2)
                .forEach(System.out::println);
        System.out.println();

        ArrayList<Integer> numbers11 = new ArrayList<>(Arrays.asList(5,4,6,8,4,10,2,23,4));
        numbers11.stream().sorted().forEach(System.out::println);
        System.out.println();

        ArrayList<Integer> numbers12 = new ArrayList<>(Arrays.asList(4,1,5,1,2,3,3,4,5,5));
        numbers12.stream().sorted().collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println();

        ArrayList<String > numbers13 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        numbers13.forEach(System.out::println);
        System.out.println();
        numbers13.parallelStream().forEach(System.out::println);
    }
}
