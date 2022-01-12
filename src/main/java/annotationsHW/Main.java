package annotationsHW;

public class Main {
    @MyCustomAnnotation
    public static void printName(){
        System.out.println("General Kenobi");
    }

    public static void main(String args[]){
        printName();
    }
}
