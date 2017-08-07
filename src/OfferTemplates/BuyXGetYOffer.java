package OfferTemplates;

/**
 * Class calculates percentage offers
 * Example by 3 in cost of 2
 */
public class BuyXGetYOffer implements Offer {

    /**
     * Product against which offer will be executed
     */
    String mOfferWith;

    /**
     * the X quantity, number of items customer will get
     */
    int mGetQuantity;
    /**
     *  the Y quantity, minimum number of items customer needs to buy for executing the offer
     */
    int mForQuantity;

    /**
     * Constructor to set X and Y
     * @param getQuantitiy the X quantity, number of items customer will get
     * @param forQuantity the Y quantity, minimum number of items customer needs to buy for executing the offer
     */
    public BuyXGetYOffer(int getQuantitiy, int forQuantity) {
        if (0 >= getQuantitiy)
            getQuantitiy = 0;
        if (0 >= forQuantity)
            forQuantity = 0;
        this.mGetQuantity = getQuantitiy;
        this.mForQuantity = forQuantity;
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
     * Calculate the discount cost after executing the offer
     * @param quantity total number of items purchased
     * @param unitPrice unit price of item on which offer will be executed
     * @return discount amount to be negated from the total bill.
     */
    @Override
    public float computeDiscountForTheOffer(Integer quantity, float unitPrice) {
        float no_discount = 0.0f;
        if (null == quantity) {
            return no_discount;
        }
        if (quantity <= mForQuantity) {
            return no_discount;
        }
        if (mGetQuantity <= 0) {
            return no_discount;
        } else {
            int quotient = quantity / mGetQuantity;
            int reminder = quantity % mGetQuantity;
            float actualCost = unitPrice * quantity;
            return actualCost - ((quotient * mForQuantity * unitPrice) + (reminder * unitPrice));
        }
    }
}
