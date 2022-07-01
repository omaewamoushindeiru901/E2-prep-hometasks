package hw2.test;

import hw2.models.Book;
import hw2.models.Calc;
import hw2.models.Increment;
import log.Log;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class TestLambda {

    Log log = new Log(TestLambda.class.getName());

    public TestLambda concatTwoStrings(){
        BiFunction<String, String, String > concat = (String s1, String s2) -> s1 + " " + s2;
        log.log(String.format("Concat two strings: %s\n", concat.apply("Hello", "There")));
        return this;
    }

    public TestLambda printThreeNames(){
        log.log("Print any 3 names with Hello:");
        Consumer<String> greetings = (String s) -> log.log("Hello, " + s + " <3\n");
        greetings.accept("Ilona");
        greetings.accept("Nika");
        greetings.accept("Naruto");
        return this;
    }

    public TestLambda printLengthOfNumber(){
        log.log("Print length of number:");
        IntFunction<Integer> len = (int number) -> String.valueOf(number).length();
        List<Integer> numbers = List.of(33, 545, 9999, 123456);
        for (Integer elem:numbers) {
            log.log(String.format("Len of %s is %s\n", elem, len.apply(elem)));
        }

        return this;
    }

    public TestLambda testOperators(){
        Calc add = Integer::sum;
        Calc sub = (int a, int b) -> a - b;
        Calc mult = (int a, int b) -> a * b;
        Calc div  = (int a, int b) -> (float)a / (float)b;
        Increment increment = (int a) -> ++a;


        log.log(String.format("Add operation: %s\n", add.calc(3,2)));
        log.log(String.format("Subtract operation: %s\n", sub.calc(3,2)));
        log.log(String.format("Multiplication operation: %s\n", mult.calc(3,2)));
        log.log(String.format("Divide operation: %s\n", div.calc(3,2)));
        log.log(String.format("Increment operation: %s\n", increment.calc(3)));
        return this;
    }

    public TestLambda doOperationsWithBooks(){
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Naruto", "Masashi", "Kishimoto", 300));
        books.add(new Book("Naruto", "NeMasashi", "NeKishimoto", 4000));
        books.add(new Book("Harry Potter","J.K.", "Rowling", 500));
        books.add(new Book("Shos", "Htos", "Htos", 2121));

        int sum = books.stream()
                .mapToInt(Book::getPages)
                .sum();
        log.log("Sum of all pages: " + sum + "\n");


        List<String> authors = books.stream()
                .map(a -> a.getAuthorName() + " " + a.getAuthorLName())
                .collect(Collectors.toList());
        log.log("Authors: " + authors + "\n");

        List<String> titlesWithDuplicate = books.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
        log.log("Titles with duplicate: " + titlesWithDuplicate + "\n");

        Set<String> titlesWithoutDuplicate = books.stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());
        log.log("Titles without duplicate: " + titlesWithoutDuplicate + "\n");

        log.log("Sorted books: ");
        books.stream()
                .sorted(Comparator.comparing(Book::getPages))
                .forEach( book -> log.log(book +"\n"));
        return this;
    }

}
