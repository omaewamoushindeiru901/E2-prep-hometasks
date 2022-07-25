import org.junit.Test;
import static org.mockito.Mockito.*;

public class StubTest extends BaseTest{
    @Test
    public void verifyPositiveRating() {
        when(pizzaCritic.isPizzaGood()).thenReturn(true);
        ratePizza.goodOrBadRating();
        verify(pizzaCritic, times(1)).ratePositive();
        verify(pizzaCritic, times(0)).rateNegative();
    }

    @Test
    public void verifyNegativeRating() {
        when(pizzaCritic.isPizzaGood()).thenReturn(false);
        ratePizza.goodOrBadRating();
        verify(pizzaCritic, times(0)).ratePositive();
        verify(pizzaCritic, times(1)).rateNegative();
    }
}
