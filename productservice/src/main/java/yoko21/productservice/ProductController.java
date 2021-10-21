package yoko21.productservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private ReviewService reviewService;

    public ProductController(ProductService productService, ReviewService reviewService) {
        this.productService = productService;
        this.reviewService = reviewService;
    }

    @GetMapping("")
    public List<ProductResponse> productList() {
        List<ProductResponse> productResponses = new ArrayList<>();
        List<Product> products = productService.findAll();
        Map<Long, List<Review>> reviewMap = reviewService.getAllReview();

        for (Product p : products) {
            productResponses.add(
                    new ProductResponse(
                            p.getId(),
                            p.getName(),
                            p.getPrice(),
                            reviewMap.getOrDefault(p.getId(), new ArrayList<>())
                    ));
        }

        return productResponses;
    }

    @PostMapping("")
    public Product productCreate(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("/{id}")
    public ProductResponse productDetail(@PathVariable("id") Long id) {
        Product product = this.productService.findById(id);
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                reviewService.getReviews(product.getId())
        );
    }

    @PutMapping("/{id}")
    public Product productUpdate(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void productDelete(@PathVariable("id") Long id) {
        productService.deleteById(id);
    }

}
