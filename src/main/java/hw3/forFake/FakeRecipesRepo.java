package hw3.forFake;

public class FakeRecipesRepo extends RecipesRepository {
    @Override
    public String[] getRecipeDetails() {
        return new String[]{"500g flour", "400g water", "100g ketchup", "100g kovbaska", "300g cheese"};
    }
}
