package yoko21.productservice;

import com.netflix.discovery.EurekaClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private ApiGatewayClient apiGatewayClient;

    public ReviewService(EurekaClient eurekaClient) {
        this.apiGatewayClient = new ApiGatewayClient(eurekaClient);
    }

    public Map<Long, List<Review>> getAllReview() {
        List<ReviewInfo> reviews = apiGatewayClient.getAllReviews();
        Map<Long, List<Review>> map = new HashMap<>();

        for (ReviewInfo r : reviews) {
            Long productId = r.getProductId();
            Review review = new Review(r.getId(), r.getContent());
            if (!map.containsKey(productId)) {
                List<Review> reviewList = new ArrayList<>();
                map.put(productId, reviewList);
            }
            map.get(productId).add(review);
        }
        return map;
    }

    public List<Review> getReviews(Long productId) {
        List<ReviewInfo> reviewInfos = this.apiGatewayClient.getReviews(productId);
        return reviewInfos.stream()
                .map(reviewInfo -> new Review(reviewInfo.getId(), reviewInfo.getContent()))
                .collect(Collectors.toList());
    }

}
