import hw3.forFake.FakeRecipesRepo;
import hw3.forFake.RecipeInfoGenerator;
import org.junit.Assert;
import org.junit.Test;

public class FakeTest extends BaseTest{
    @Test
    public void verifyGeneratorReturnsCorrectString() {
        FakeRecipesRepo fakeRecipesRepo = new FakeRecipesRepo();
        RecipeInfoGenerator recipeInfoGenerator = new RecipeInfoGenerator(fakeRecipesRepo);

        String actualString = recipeInfoGenerator.getInfoAsString();
        String expectedString = "500g flour\n400g water\n100g ketchup\n100g kovbaska\n300g cheese";
        Assert.assertEquals(actualString, expectedString);
    }
}
