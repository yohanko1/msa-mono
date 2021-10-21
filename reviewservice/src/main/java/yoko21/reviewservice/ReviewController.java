package yoko21.reviewservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/products/{productId}/reviews")
    public ReviewDto.Info createReview(@PathVariable("productId") Long productId, @RequestBody CreateReviewRequest review) {
        return reviewService.create(
                Review.builder().productId(productId).content(review.getContent()).build()
        );
    }

    @DeleteMapping("/products/{productId}/reviews/{id}")
    public void deleteReview(@PathVariable("id") Long id) {
        reviewService.delete(id);
    }

    @GetMapping("/products/{productId}/reviews")
    public List<Review> getReviewsByProductId(@PathVariable("productId") Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

}
