import OfferTemplates.Offer;
import Products.Product;

import java.util.HashMap;
import java.util.Set;

/**
 * Class encapsulates list of products and offers described by sales manager
 */
public class PricingRules {

    /**
     * List of product stored against sku for searching
     */
    private HashMap<String,Product> productList;

    /**
     * List of offers available
     */
    private Set<Offer> offerList;

    /**
     * Returns product list
     * @return Returns product list
     */
    public HashMap<String,Product> getProductList() {
        return productList;
    }

    /**
     * Returns offer List
     * @return Returns offer List
     */
    public Set<Offer> getOfferList() {
        return offerList;
    }

    /**
     * Constructor
     * @param products list of products available in the store
     * @param offers list of offers available in the store
     */
    PricingRules(HashMap<String,Product> products, Set<Offer> offers){
        this.productList = products;
        this.offerList = offers;
    }





}
