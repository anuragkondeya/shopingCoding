package Products;

/**
 * Class encapsulates a product
 */
public class Product {

    /**
     * Sku
     */
    private String sku;
    /**
     * Product name
     */
    private String name;
    /**
     * Product price
     */
    private float price;

    /**
     * Constuctor
     * @param sku
     * @param name
     * @param price
     */
    public Product(String sku, String name,float price ){
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    /**
     * Getter for price
     * @return
     */
    public float getPrice() {
        return price;
    }



}
