
import OfferTemplates.BulkDiscountOffer;
import OfferTemplates.FreeVGAAdapterOffer;
import OfferTemplates.Offer;
import OfferTemplates.BuyXGetYOffer;
import Products.Product;

import java.util.*;

/**
 * Class with main
 */
public class ComputerStoreMain {

    /**
     * SKU for product super ipad
     */
    private static final String SUPER_IPAD = "ipd";
    /**
     * SKU for product super macBookPro
     */
    private static final String MACBOOK_PRO = "mbp";
    /**
     * SKU for product super appleTv
     */
    private static final String APPLE_TV = "atv";
    /**
     * SKU for product super VGA adapter
     */
    private static final String VGA_ADATER = "vga";

    /**
     * Purchase use case 1
     */
    private static String[] shopingList1 = {"atv", "atv", "atv", "vga"};
    /**
     * Purchase use case 2
     */
    private static String[] shopingList2 = {"atv", "ipd", "ipd", "atv", "ipd", "ipd", "ipd"};
    /**
     * Purchase use case 3
     */
    private static String[] shopingList3 = {"mbp", "vga", "ipd"};

    private static final String[] shoppingList = shopingList3;


    /**
     * Prepares a list of products available in the store
     * The list can be prepared / modified form any external source (Sales Manager) without modifying the code
     * @param products
     */
    private static void getProductList(HashMap<String, Product> products) {
        products.put(SUPER_IPAD, new Product(SUPER_IPAD, "Super iPad", 549.99f));
        products.put(MACBOOK_PRO, new Product(MACBOOK_PRO, "MacBook Pro", 1399.99f));
        products.put(APPLE_TV, new Product(APPLE_TV, "Apple TV", 109.50f));
        products.put(VGA_ADATER, new Product(VGA_ADATER, "VGA adapter", 30f));
    }

    /**
     * Prepares offer list available in the store
     * The list can be prepared / modified form any external source ((Sales Manager) without modifying the code
     * @param productMap
     * @param offers
     */
    private static void getOfferList(HashMap<String, Product> productMap, Set<Offer> offers) {

        Offer percentageDiscountOffer = new BuyXGetYOffer(3,2);
        percentageDiscountOffer.setOfferWith(APPLE_TV);
        offers.add(percentageDiscountOffer);

        Offer freeVGAAdapterOffer = new FreeVGAAdapterOffer(30.0f);
        freeVGAAdapterOffer.setOfferWith(MACBOOK_PRO);
        offers.add(freeVGAAdapterOffer);

        Offer bulkDiscountOffer = new BulkDiscountOffer(4,499.99f);
        bulkDiscountOffer.setOfferWith(SUPER_IPAD);
        offers.add(bulkDiscountOffer);

    }

    /**
     * Encapsulating product and offer list into pricing list object
     * @return
     */
    private static PricingRules getPricingRules() {
        HashMap<String, Product> productMap = new HashMap<>();
        Set<Offer> offers = new HashSet<>();
        getProductList(productMap);
        getOfferList(productMap,offers);
        return new PricingRules(productMap, offers);
    }

    /**
     * Main function to execute
     * @param args
     */
    public static void main(String... args) {
        Checkout checkout = new Checkout(getPricingRules());
        for (String item : shoppingList) {
            System.out.println("Product scanned "+item);
            checkout.scan(item);
        }
        System.out.println("Total Bill = "+checkout.computeBill());
    }

}
