import hw3.forMock.NachunkaMaker;
import hw3.forMock.PizzaMaker;
import hw3.forMock.TistoMaker;
import hw3.forStub.PizzaCritic;
import hw3.forStub.RatePizza;
import org.junit.Before;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.inOrder;

public abstract class BaseTest {
    protected PizzaMaker pizzaMaker;
    protected InOrder orderVerifier;
    protected RatePizza ratePizza;
    @Mock
    protected TistoMaker mockTistoMaker;
    @Mock
    protected NachunkaMaker mockNachunkaMaker;
    @Mock
    protected PizzaCritic pizzaCritic;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        pizzaMaker = new PizzaMaker(mockTistoMaker,mockNachunkaMaker);
        orderVerifier = inOrder(mockTistoMaker, mockNachunkaMaker);
        ratePizza = new RatePizza(pizzaCritic);

    }
}
