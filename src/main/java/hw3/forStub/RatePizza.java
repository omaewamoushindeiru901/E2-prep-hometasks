package hw3.forStub;

public class RatePizza {
    private final PizzaCritic pizzaCritic;

    public RatePizza(PizzaCritic pizzaCritic) {
        this.pizzaCritic = pizzaCritic;
    }

    public void goodOrBadRating() {
        if(pizzaCritic.isPizzaGood()) pizzaCritic.ratePositive();
        else pizzaCritic.rateNegative();
    }
}
