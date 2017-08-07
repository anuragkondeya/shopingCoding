package UnitTests.OffersTest;

import OfferTemplates.FreeVGAAdapterOffer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tet for testing FreeVGAAdapterOffer
 */
public class FreeVGAAdapterOfferTest {
    /**
     * Test if purchase fits offer
     * @throws Exception asset if test fails
     */
    @Test
    public void test_computeOffer() throws Exception {
        FreeVGAAdapterOffer freeVGAAdapterOffer =  new FreeVGAAdapterOffer(30.0f);
        float discountedSum = freeVGAAdapterOffer.computeDiscountForTheOffer(5,1399.99f);
        assertEquals(150.0f,discountedSum,0.0);
    }

    /**
     * Test if quantitiy is negative
     * @throws Exception asset if test fails
     */
    @Test
    public void test_negative_offer() throws Exception {
        FreeVGAAdapterOffer freeVGAAdapterOffer =  new FreeVGAAdapterOffer(30.0f);
        float discountedSum = freeVGAAdapterOffer.computeDiscountForTheOffer(-5,1399.99f);
        assertEquals(0.0f,discountedSum,0.0);
    }

}