package OfferTemplates;

/**
 * Compute free items given with a purchase
 */
public class FreeVGAAdapterOffer implements Offer {

    /**
     * Product against which the offer is executed
     */
    String mOfferWith;
    /**
     * cost of the accessory given as free item
     */
    float mFreeProductCost = 0;

    /**
     * Constructor
     * @param freeProductCost cost of the accessory given as free item
     */
    public FreeVGAAdapterOffer(float freeProductCost) {
        mFreeProductCost = freeProductCost;
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
     * Computes total cost of free item to be negated from actual sum
     * @param quantity number of items purchased on which the offer is executed
     * @param unitPrice unit price of free item
     * @return discount amount to be negated from the total bill.
     */
    @Override
    public float computeDiscountForTheOffer(Integer quantity, float unitPrice) {
        if (null == quantity)
            return 0.0f;
        if (0 > quantity)
            quantity = 0;
        return mFreeProductCost * quantity;
    }

}
