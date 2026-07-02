package datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Main class to demonstrate Linear and Binary Search on an ArrayList of Product
 * objects.
 */
public class Main {

    /**
     * Performs a Linear Search on the products list by product name.
     * Linear search checks each element one-by-one from beginning to end.
     * 
     * Time Complexity: O(n) - where n is the number of products.
     * Space Complexity: O(1) - constant extra space.
     * 
     * @param products   the list of products to search
     * @param targetName the name of the product we are looking for
     * @return the Product object if found, or null if not found
     */
    public static Product linearSearch(ArrayList<Product> products, String targetName) {
        // Loop through each product in the list
        for (Product product : products) {
            // Check if the current product name matches the target name (ignoring case)
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product; // Found and returned the product
            }
        }
        return null; // Product not found in the list
    }

    /**
     * Performs a Binary Search on a sorted products list by product name.
     * Binary search repeatedly divides the search range in half.
     * Note: The list MUST be sorted by product name before calling this method.
     * 
     * Time Complexity: O(log n) - where n is the number of products.
     * Space Complexity: O(1) - constant extra space.
     * 
     * @param products   the sorted list of products to search
     * @param targetName the name of the product we are looking for
     * @return the Product object if found, or null if not found
     */
    public static Product binarySearch(ArrayList<Product> products, String targetName) {
        int low = 0;
        int high = products.size() - 1;

        // Keep searching while the range is valid
        while (low <= high) {
            // Find the middle element index
            int mid = low + (high - low) / 2;
            Product midProduct = products.get(mid);

            // Compare middle product's name with the target name (ignoring case)
            int comparison = midProduct.getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return midProduct; // Found the product at the middle index!
            } else if (comparison < 0) {
                // If mid product name is alphabetically smaller than target, search in right
                // half
                low = mid + 1;
            } else {
                // If mid product name is alphabetically larger than target, search in left half
                high = mid - 1;
            }
        }
        return null; // Product not found
    }

    public static void main(String[] args) {
        // Step 1: Create a list to store products
        ArrayList<Product> productList = new ArrayList<>();

        // Step 2: Add multiple products to the list (unsorted order)
        productList.add(new Product("P105", "Wireless Mouse", "Electronics"));
        productList.add(new Product("P101", "Laptop", "Electronics"));
        productList.add(new Product("P103", "Mechanical Keyboard", "Electronics"));
        productList.add(new Product("P102", "Smart Watch", "Wearables"));
        productList.add(new Product("P104", "Bluetooth Headphones", "Audio"));

        System.out.println("--- Original Unsorted Product List ---");
        for (Product p : productList) {
            System.out.println(p);
        }
        System.out.println();

        // Target products to search for
        String searchTarget1 = "Mechanical Keyboard"; // Existing product
        String searchTarget2 = "Gaming Console"; // Non-existent product

        // ==========================================
        // 1. Demonstrate Linear Search
        // ==========================================
        System.out.println("==========================================");
        System.out.println("Running Linear Search...");
        System.out.println("==========================================");

        // Search 1: Searching for an existing product
        System.out.println("Searching for: \"" + searchTarget1 + "\"");
        Product resultLinear1 = linearSearch(productList, searchTarget1);
        displaySearchResult(resultLinear1, searchTarget1);

        // Search 2: Searching for a non-existent product
        System.out.println("Searching for: \"" + searchTarget2 + "\"");
        Product resultLinear2 = linearSearch(productList, searchTarget2);
        displaySearchResult(resultLinear2, searchTarget2);
        System.out.println();

        // ==========================================
        // 2. Demonstrate Binary Search
        // ==========================================
        System.out.println("==========================================");
        System.out.println("Running Binary Search...");
        System.out.println("==========================================");

        // Step A: Binary search requires the list to be sorted first
        System.out.println("Sorting product list by Product Name alphabetically...");
        // Sort using a custom Comparator that ignores case
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getProductName().compareToIgnoreCase(p2.getProductName());
            }
        });

        System.out.println("--- Sorted Product List ---");
        for (Product p : productList) {
            System.out.println(p);
        }
        System.out.println();

        // Search 1: Searching for an existing product
        System.out.println("Searching for: \"" + searchTarget1 + "\"");
        Product resultBinary1 = binarySearch(productList, searchTarget1);
        displaySearchResult(resultBinary1, searchTarget1);

        // Search 2: Searching for a non-existent product
        System.out.println("Searching for: \"" + searchTarget2 + "\"");
        Product resultBinary2 = binarySearch(productList, searchTarget2);
        displaySearchResult(resultBinary2, searchTarget2);
    }

    /**
     * Helper method to display search result cleanly.
     * 
     * @param product    the product found (or null)
     * @param targetName the name searched for
     */
    private static void displaySearchResult(Product product, String targetName) {
        if (product != null) {
            System.out.println("Result: Success! Found: " + product);
        } else {
            System.out.println("Result: Not Found! Product \"" + targetName + "\" does not exist.");
        }
    }
}
