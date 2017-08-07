package OfferTemplates;

/**
 * Calculates discount when a product is purchased in bulk.
 */
public class BulkDiscountOffer implements Offer {

    /**
     * Minimum quantity above which offer starts
     */
    int mMinimumQuantity;
    /**
     * Discounted cost of the product
     */
    float mDiscountedUnitCost;

    /**
     * Product against which offer will be executed
     */
    String mOfferWith;


    /**
     * Contruct an offer instance
     *
     * @param minimumQuantity    minimum quantity for offer to apply
     * @param discountedUnitCost reduced cost of the item under offer
     */
    public BulkDiscountOffer(int minimumQuantity, float discountedUnitCost) {
        if (0 >= minimumQuantity)
            minimumQuantity = 0;
        this.mMinimumQuantity = minimumQuantity;
        this.mDiscountedUnitCost = discountedUnitCost;
    }

    /**
     * Setter for product against which the offer is executed.
     * @param offerWith product against which offer is set
     */
    @Override
    public void setOfferWith(String offerWith) {
        this.mOfferWith = offerWith;
    }

    /**
     * Getter for product against which offer is executed
     * @return product against which offer it set
     */
    @Override
    public String getOfferWith() {
        return this.mOfferWith;
    }

    /**
     * Discounts the unit price if quantity is greater than or equal to minimum quantity defined
     * @param quantity number of items purchased on which the offer is executed
     * @param unitPrice unit price of  item under offer
     * @return discount amount to be negated from the total bill.
     */
    @Override
    public float computeDiscountForTheOffer(Integer quantity, float unitPrice) {
        if (quantity < mMinimumQuantity) {
            return 0;
        } else {
            return (unitPrice - mDiscountedUnitCost) * quantity;
        }
    }

}
