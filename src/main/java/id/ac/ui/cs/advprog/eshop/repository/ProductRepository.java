package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    static long counter = 0;

    public Product create(Product product) {
        product.setProductId(Long.toString(++counter));
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String id) {
        for (Product product : productData) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public Product edit(Product productEdited) {
        String idProductEdited = productEdited.getProductId();
        Product product = findById(idProductEdited);
        product.setProductName(productEdited.getProductName());
        product.setProductQuantity(productEdited.getProductQuantity());
        return product;
    }
}