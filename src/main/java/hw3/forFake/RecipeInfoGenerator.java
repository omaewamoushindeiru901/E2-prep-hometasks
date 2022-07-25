package hw3.forFake;

public class RecipeInfoGenerator {
    RecipesRepository recipesRepository;
    public RecipeInfoGenerator(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    public String getInfoAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        String[] recipeInfo = recipesRepository.getRecipeDetails();
        int size = recipeInfo.length;

        for(int i = 0; i < size; i++) {
            stringBuilder.append(recipeInfo[i]);
            if(i != size - 1) stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
