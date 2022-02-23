package hw2.test;

import log.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStreams {

    Log log = new Log(TestLambda.class.getName());
    private final ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

    public TestStreams firstExercise(){
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(120,410,85,32,314,12));
        ArrayList<Integer> filtered = new ArrayList<>();
        numbers.stream()
                .filter(n -> n < 300)
                .map(n -> n + 11)
                .forEach(filtered::add);
        log.log(filtered + "\n");
        return this;
    }

    public TestStreams secondExercise(){
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("red", "green", "blue"));
        Optional<String> first = colors.stream()
                .sorted()
                .findFirst();
        log.log(first.get() + "\n");
        return this;
    }

    public TestStreams thirdExercise(){
        ArrayList<Integer> numbers3 = new ArrayList<>(Arrays.asList(3,4,1,40));
        Optional<Integer> firstN = numbers3.stream()
                .sorted()
                .findFirst();
        log.log(firstN.get() + "\n");
        return this;
    }

    public TestStreams fourthExercise(){
        ArrayList<String> fruits = new ArrayList<>(Arrays.asList("apple", "banana", "pear", "cherry", "pineapple"));
        ArrayList<String> filtered = new ArrayList<>();
        fruits.stream()
                .filter((n) -> n.startsWith("p"))
                .forEach(filtered::add);
        log.log(filtered + "\n");
        return this;
    }

    public TestStreams fifthExercise(){
        ArrayList<String> words = new ArrayList<>(Arrays.asList("Java", "Rocks"));
        ArrayList<String> filtered = new ArrayList<>();
        words.stream()
                .map((n) -> n.toUpperCase(Locale.ROOT))
                .forEach(filtered::add);
        log.log(filtered + "\n");
        return this;
    }

    public TestStreams sixthExercise(){
        ArrayList<Double> numbers6 = new ArrayList<>(Arrays.asList(1.5, 2.3, 3.7));
        ArrayList<Integer> filtered = new ArrayList<>();
        numbers6.stream()
                .map(Double::intValue)
                .forEach(filtered::add);
        log.log(filtered + "\n");
        return this;
    }

    public TestStreams seventhExercise(){
        ArrayList<Integer> numbers7 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Optional<Integer> findFirst = numbers7.stream()
                .filter((n) -> n < 4)
                .findFirst();
        Optional<Integer> findAny = numbers7.stream()
                .filter((n) -> n < 4)
                .findAny();
        log.log(findFirst.get() + "\n");
        log.log(findAny.get() + "\n");
        return this;
    }

    public TestStreams eighthExercise(){
        //TODO
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
        ArrayList<Integer> numbers11 = new ArrayList<>(Arrays.asList(5,4,6,8,4,10,2,23,4));
        ArrayList<Integer> filtered = new ArrayList<>();
        numbers11.stream().sorted().forEach(filtered::add);
        log.log(filtered + "\n");
        return this;
    }

    public TestStreams twelfthExercise(){
        ArrayList<Integer> numbers12 = new ArrayList<>(Arrays.asList(4,1,5,1,2,3,3,4,5,5));
        ArrayList<Integer> filtered = numbers12.stream().sorted().distinct().collect(Collectors.toCollection(ArrayList::new));
        log.log(filtered + "\n");
        return this;
    }

    //???
    public TestStreams thirteenthExercise(){
        ArrayList<String > numbers13 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        ArrayList<String> filtered = new ArrayList<>(numbers13);
        log.log(filtered + "\n");
        filtered.clear();
        numbers13.parallelStream().forEach(filtered::add);
        log.log(filtered + "\n");
        return this;
    }
}
