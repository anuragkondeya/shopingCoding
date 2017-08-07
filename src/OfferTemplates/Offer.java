package OfferTemplates;

import Products.Product;

import java.util.HashMap;

/**
 * Interface against which offer templates should be prepared
 */
public interface Offer {

    /**
     * Setter of the product against which offer will be executed. To be called by methods which define offers
     * @param offerWith
     */
    void setOfferWith(String offerWith);

    /**
     * Getter of product against which offer will be executed
     * @return
     */
    String getOfferWith();
    /**
     * Calculate discount provided by this offer
     * @param quantity
     * @param unitPrice
     * @return
     */
    float computeDiscountForTheOffer(Integer quantity, float unitPrice);

}
