package OfferTemplates;

import Products.Product;

import java.util.HashMap;

/**
 * Interface against which offer templates should be prepared
 */
public interface Offer {

    /**
     * Setter of the product against which offer will be executed. To be called by methods which define offers
     * @param offerWith sku of the product against which this offer is running
     */
    void setOfferWith(String offerWith);

    /**
     * Getter of product against which offer will be executed
     * @return name of the product against which offer is running
     */
    String getOfferWith();
    /**
     * Calculate discount provided by this offer
     * @param quantity purchase quantity of item under offer
     * @param unitPrice unit price of item under offer or the price of free item in the offer. check {@link FreeVGAAdapterOffer}
     * @return discount that will ne negated from bill amount
     */
    float computeDiscountForTheOffer(Integer quantity, float unitPrice);

}
