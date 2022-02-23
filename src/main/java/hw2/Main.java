package hw2;

import hw2.test.TestDateTimeAPI;
import hw2.test.TestLambda;
import hw2.test.TestOptional;
import hw2.test.TestStreams;
import log.Log;

public class Main {

    public static void main(String[] args){
        Log log = new Log(Main.class.getName());

        log.log("\n===START TEST DATETIME API===\n");
        new TestDateTimeAPI()
                .printZonedDateTimeNow()
                .printBirthday()
                .printLocalTime()
                .printTimeSpan()
                .printFormattedDate()
                .printNumberOfDays()
                .printFormattedZonedDateTime();

        log.log("\n===START TEST LAMBDA===\n");
        new TestLambda()
                .concatTwoStrings()
                .printThreeNames()
                .printLengthOfNumber()
                .testOperators()
                .doOperationsWithBooks();

        log.log("\n===START TEST OPTIONAL===\n");
        new TestOptional()
                .useEmptyAndPresent()
                .useIfPresent()
                .compareOrElseToOrElseGet()
                .useConditionalReturn()
                .transformValue();

        log.log("\n===START TEST STREAMS===\n");
        new TestStreams()
                .firstExercise()
                .secondExercise()
                .thirdExercise()
                .fourthExercise()
                .fifthExercise()
                .sixthExercise()
                .seventhExercise()
                .eighthExercise()
                .ninthExercise()
                .tenthExercise()
                .eleventhExercise()
                .twelfthExercise()
                .thirteenthExercise();
    }

}
