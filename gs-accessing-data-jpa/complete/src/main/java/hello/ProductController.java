package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.dc.pr.PRError;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class ProductController {
        @Autowired
        private ProductRepository productRepository;
        @GetMapping(path="/products")
        public Iterable<Product> getAllProducts() {
            return productRepository.findAll();
        }
        @PostMapping(path="/product")
        public Product addProduct(@RequestBody Product product){
            return productRepository.save(product);
        }
        @GetMapping(path = "/product/{id}")
        public Product getById(@PathVariable Long id) throws ResourceNotFoundException {
            return productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found for this id :: " + id));
        }
        @PutMapping(path="/product/{id}")
        public Product updateProduct(@PathVariable Long id, @RequestBody Product product) throws ResourceNotFoundException {
            Product existingProduct=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found for this id :: " + id));
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            return productRepository.save(existingProduct);

        }
        @DeleteMapping(path="/product/{id}")
        public void deleteProduct(@PathVariable Long id) throws ResourceNotFoundException {
            Product product=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found for this id :: " + id));
            productRepository.delete(product);
        }

}
