import OfferTemplates.Offer;
import Products.Product;

import java.util.*;

/**
 * Class contains utility methods for preparing a purchase list and calculate final bill amount
 */
public class Checkout {

    /**
     * Store list of offers
     */
    private Set<Offer> offers;
    /**
     * Store individual product against sku ie list of all available products in the store
     */
    private HashMap<String, Product> products;
    /**
     * stores purchase list against sku, the map grows as the items are scanned
     */
    private HashMap<String, Integer> purchaseMap;

    /**
     * Total amount of purchase before applying discount
     */
    private float sumBeforeDiscount = 0;

    /**
     * Constructor
     * @param pricingRules
     */
    public Checkout(PricingRules pricingRules) {
        this.products = pricingRules.getProductList();
        this.offers = pricingRules.getOfferList();
        purchaseMap = new HashMap<>();
    }

    /**
     * Scan each item and compute total amount (without discount) so far
     * @param item
     */
    public void scan(String item) {
        Integer count = purchaseMap.get(item);
        if (null != count) {
            purchaseMap.put(item, ++count);
        } else {
            purchaseMap.put(item, 1);
        }
        sumBeforeDiscount += products.get(item).getPrice();
    }

    /**
     * Compute discount by traversing the purchase list with every offer available
     * this way we can apply multiple offers on a single purchase
     * @return
     */
    public float computeBill() {
        for (Offer offer : offers) {
            String productKey = offer.getOfferWith();
            if (purchaseMap.containsKey(productKey)) {
                int quantity = purchaseMap.get(offer.getOfferWith());
                float discount = offer.computeDiscountForTheOffer(quantity, products.get(productKey).getPrice());
                sumBeforeDiscount -= discount;
            }
        }
        return sumBeforeDiscount;
    }
}
