package datastructures;

/**
 * Product class represents a product in the e-commerce platform.
 * It contains details like Product ID, Product Name, and Category.
 */
public class Product {
    private String productId;
    private String productName;
    private String category;

    /**
     * Parameterized constructor to initialize a Product.
     * 
     * @param productId   the unique ID of the product
     * @param productName the name of the product
     * @param category    the category the product belongs to
     */
    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters and Setters

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Overriding toString() to display product information in a friendly format.
     */
    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=\"" + productName + "\", Category=" + category + "]";
    }
}
