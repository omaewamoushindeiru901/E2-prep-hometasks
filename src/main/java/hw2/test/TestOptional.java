package hw2.test;

import log.Log;
import log.LogType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestOptional {

    Log log = new Log(TestOptional.class.getName());

    private final Optional<String> val = Optional.of("qwerty");
    private final Optional<Integer> val2 = Optional.of(9999);
    private final Optional<String> emt = Optional.empty();

    public TestOptional useEmptyAndPresent(){
        try{
            log.log(String.format("Use of empty() and isPresent(): %s\n", emt.isPresent()));
        } catch (Exception e){
            log.log(LogType.ERROR, "Exception");
        }
        return this;
    }

    public TestOptional useIfPresent(){
        val.ifPresent(v -> log.log(String.format("Use of ifPresent: %s\n", v)));
        return this;
    }

    private String foo(){
        log.log("---did smth inside foo---");
        return "returned smth";
    }

    public TestOptional compareOrElseToOrElseGet(){
        log.log(String.format("orElse: %s\n", val.orElse(foo())));
        log.log(String.format("orElseGet: %s\n", val.orElseGet((this::foo))));

        log.log(String.format("orElse: %s\n", emt.orElse(foo())));
        log.log(String.format("orElseGet: %s\n", emt.orElseGet(this::foo)));
        return this;
    }

    public TestOptional useConditionalReturn(){
        val2.filter(n -> n%2==0).ifPresentOrElse((v) -> log.log(String.format("Filtered: %s\n", v)),
                () -> log.log("Value is empty\n"));
        return this;
    }

    public TestOptional transformValue(){
        log.log(String.format("Transformed int: %s\n", val2.map( n -> n + 1).get()));
        Optional<List<Integer>> optionalList = Optional.of(Arrays.asList(1,2,3));
        log.log(String.format("Transformed list: %s\n", optionalList.map(List::size).orElse(0)));
        return this;
    }
}
