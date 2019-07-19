package pl.jwr.table;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("chleb", 3.50));
        products.add(new Product("masło", 4.50));
        products.add(new Product("mleko", 2.50));
    }

    public List<Product> getAll() {
        return products;
    }

    public double sumOfProducts() {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }
}
