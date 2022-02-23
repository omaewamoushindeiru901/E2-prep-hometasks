package hw2.test;

import hw2.models.Book;
import log.Log;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collectors;

public class TestLambda {

    Log log = new Log(TestLambda.class.getName());

    public TestLambda concatTwoStrings(){
        BiFunction<String, String, String > concat = (String s1, String s2) -> s1.concat(" ").concat(s2);
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
        Consumer<Integer> len = (Integer number) -> {
            int count = 0;
            int n = number;
            while (n!=0){
                n = n/10;
                count++;
            }
            log.log(String.format("Len of %s is %s\n",number,count));
        };
        len.accept(33);
        len.accept(545);
        len.accept(9999);
        len.accept(123456);
        return this;
    }

    public TestLambda testOperators(){
        BinaryOperator<Integer> add = Integer::sum;
        UnaryOperator<Integer> increment = (Integer n) -> n + 1;
        log.log(String.format("Add operation: %s\n", add.apply(2,2)));
        log.log(String.format("Increment operation: %s\n", increment.apply(2)));
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
