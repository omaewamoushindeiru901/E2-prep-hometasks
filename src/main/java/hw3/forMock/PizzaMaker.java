package hw3.forMock;

public class PizzaMaker {
    private final TistoMaker tistoMaker;
    private final NachunkaMaker nachunkaMaker;

    public PizzaMaker(TistoMaker tistoMaker, NachunkaMaker nachunkaMaker) {
        this.tistoMaker = tistoMaker;
        this.nachunkaMaker = nachunkaMaker;
    }

    public void makePizza() {
        tistoMaker.makeTisto();
        nachunkaMaker.applyKetchup();
        nachunkaMaker.applyKovbaska();
        nachunkaMaker.applyCheese();
    }

}
