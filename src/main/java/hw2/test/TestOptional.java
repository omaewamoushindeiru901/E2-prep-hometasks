package hw2.test;

import log.Log;
import log.LogType;

import java.util.Optional;

public class TestOptional {

    Log log = new Log(TestOptional.class.getName());

    private final Optional<String> val = Optional.of("qwerty");
    private final Optional<Integer> val2 = Optional.of(9999);

    public TestOptional useEmptyAndPresent(){
        try{
            Optional<String> emt = Optional.empty();
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

    public TestOptional compareOrElseToOrElseGet(){
        log.log(String.format("orElse: %s\n", val.orElse("Value is not present") ));
        log.log(String.format("orElseGet: %s\n", val.orElseGet(() -> String.valueOf((int) (Math.random() * 10)))));
        return this;
    }

    public TestOptional useConditionalReturn(){
        log.log(String.format("Filtered: %s\n", val2.filter(n -> n%2==0)));
        return this;
    }

    public TestOptional transformValue(){
        log.log(String.format("Transformed: %s\n", val2.map( n -> n + 1).get()));
        return this;
    }
}
