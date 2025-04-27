package Hard;

import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
}

public class ProcessProducts {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 80000),
            new Product("Phone", "Electronics", 40000),
            new Product("Shirt", "Clothing", 1500),
            new Product("Jeans", "Clothing", 2500),
            new Product("Blender", "Home Appliances", 3500)
        );

        // Group products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("Products grouped by category:");
        groupedByCategory.forEach((category, list) -> {
            System.out.println(category + ": " + list.stream()
                                                     .map(Product::getName)
                                                     .collect(Collectors.joining(", ")));
        });

        // Find most expensive product in each category
        System.out.println("\nMost expensive product in each category:");
        groupedByCategory.forEach((category, list) -> {
            Product expensive = list.stream()
                                    .max(Comparator.comparing(Product::getPrice))
                                    .orElse(null);
            if (expensive != null) {
                System.out.println(category + ": " + expensive.getName() + " (" + expensive.getPrice() + ")");
            }
        });

        // Calculate average price of all products
        double averagePrice = products.stream()
                                      .mapToDouble(Product::getPrice)
                                      .average()
                                      .orElse(0.0);
        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}
