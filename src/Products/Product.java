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
     * @param sku sku of the product
     * @param name name of the product
     * @param price price of the product
     */
    public Product(String sku, String name,float price ){
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    /**
     * Getter for price
     * @return price
     */
    public float getPrice() {
        return price;
    }



}
