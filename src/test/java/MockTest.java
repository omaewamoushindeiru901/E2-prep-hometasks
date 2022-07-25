import org.junit.Test;
import static org.mockito.Mockito.times;

public class MockTest extends BaseTest {
    @Test
    public void verifyOrder() {
        pizzaMaker.makePizza();
        orderVerifier.verify(mockTistoMaker, times(1)).makeTisto();
        orderVerifier.verify(mockNachunkaMaker, times(1)).applyKetchup();
        orderVerifier.verify(mockNachunkaMaker, times(1)).applyKovbaska();
        orderVerifier.verify(mockNachunkaMaker, times(1)).applyCheese();
    }
}
