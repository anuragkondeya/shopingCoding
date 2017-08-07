package UnitTests.OffersTest;

import OfferTemplates.BuyXGetYOffer;

import static org.junit.Assert.*;

/**
 * Unit tet for testing BuyXGetYOffer
 */
public class BuyXGetYOfferTest {
    /**
     * Test if purchase is greater than offer minimum
     * @throws Exception asset if test fails
     */
    @org.junit.Test
    public void test_quantitiy_greaterThan_min() throws Exception {
        BuyXGetYOffer buyXGetYOffer = new BuyXGetYOffer(3, 2);
        float discountedSum = buyXGetYOffer.computeDiscountForTheOffer(3,109.50f);
        assertEquals(109.50f, discountedSum, 0.0f);
    }

    /**
     * Test if purchase is less than offer minimum
     * @throws Exception asset if test fails
     */
    @org.junit.Test
    public void test_quantitiy_lessThan_min() throws Exception {
        BuyXGetYOffer buyXGetYOffer = new BuyXGetYOffer(3, 2);
        float discountedSum = buyXGetYOffer.computeDiscountForTheOffer(1,109.50f);
        assertEquals(0, discountedSum, 0.0f);
    }

    /**
     * Test if purchase is equal to offer minimum
     * @throws Exception asset if test fails
     */
    @org.junit.Test
    public void test_quantitiy_equalto_min() throws Exception {
        BuyXGetYOffer buyXGetYOffer = new BuyXGetYOffer(3, 2);
        float discountedSum = buyXGetYOffer.computeDiscountForTheOffer(2,109.50f);
        assertEquals(0, discountedSum, 0.0f);
    }

    /**
     * Test if purchase is 0
     * @throws Exception asset if test fails
     */
    @org.junit.Test
    public void test_quantitiy_negative_quantity() throws Exception {
        BuyXGetYOffer buyXGetYOffer = new BuyXGetYOffer(3, 2);
        float discountedSum = buyXGetYOffer.computeDiscountForTheOffer(-3,109.50f);
        assertEquals(0, discountedSum, 0.0f);
    }

    /**
     * Test if get quantity is 0 (div by 0 test)
     * @throws Exception asset if test fails
     */
    @org.junit.Test
    public void test_division_by_zero() throws Exception {
        BuyXGetYOffer buyXGetYOffer = new BuyXGetYOffer(0, 2);
        float discountedSum = buyXGetYOffer.computeDiscountForTheOffer(3,109.50f);
        assertEquals(0, discountedSum, 0.0f);
    }
}
