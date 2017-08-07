package UnitTests.OffersTest;

import OfferTemplates.BulkDiscountOffer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tet for testing BulkDiscountOffer
 */
public class BulkDiscountOfferTest {
    /**
     * Test if purchase is greater than offer minimum
     * @throws Exception
     */
    @Test
    public void test_quantitiy_greaterThan_min() throws Exception {
        BulkDiscountOffer bulkDiscountOffer =  new BulkDiscountOffer(4,499.99f);
        float discountedSum = bulkDiscountOffer.computeDiscountForTheOffer(5,549.99f);
        assertEquals(250.0f,discountedSum,0.5);
    }

    /**
     * Test if purchase is less than offer minimum
     * @throws Exception
     */
    @Test
    public void test_quantitiy_lessThan_min() throws Exception {
        BulkDiscountOffer bulkDiscountOffer =  new BulkDiscountOffer(4,499.99f);
        float discountedSum = bulkDiscountOffer.computeDiscountForTheOffer(2,549.99f);
        assertEquals(0.0f,discountedSum,0.0);
    }

    /**
     * Test if purchase is equal to offer minimum
     * @throws Exception
     */
    @Test
    public void test_quantitiy_equal_min() throws Exception {
        BulkDiscountOffer bulkDiscountOffer =  new BulkDiscountOffer(4,499.99f);
        float discountedSum = bulkDiscountOffer.computeDiscountForTheOffer(4,549.99f);
        assertEquals(200.0f,discountedSum,0.0);
    }

    /**
     * Test if purchase is 0
     * @throws Exception
     */
    @Test
    public void test_quantitiy_no_quantity() throws Exception {
        BulkDiscountOffer bulkDiscountOffer =  new BulkDiscountOffer(4,499.99f);
        float discountedSum = bulkDiscountOffer.computeDiscountForTheOffer(0,549.99f);
        assertEquals(0.0,discountedSum,0.0);
    }

    /**
     * Test if quantity is negative
     * @throws Exception
     */
    @Test
    public void test_quantitiy_negative_quantity() throws Exception {
        BulkDiscountOffer bulkDiscountOffer =  new BulkDiscountOffer(4,499.99f);
        float discountedSum = bulkDiscountOffer.computeDiscountForTheOffer(-1,549.99f);
        assertEquals(0.0,discountedSum,0.0);
    }

    /**
     * Test to check if minimum quantity is set as negative
     * @throws Exception
     */
    @Test
    public void test_quantitiy_negative_minium_quantity() throws Exception {
        BulkDiscountOffer bulkDiscountOffer =  new BulkDiscountOffer(-7,499.99f);
        float discountedSum = bulkDiscountOffer.computeDiscountForTheOffer(-1,549.99f);
        assertEquals(0.0,discountedSum,0.0);
    }
}