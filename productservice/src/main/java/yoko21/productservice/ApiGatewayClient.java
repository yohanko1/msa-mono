package yoko21.productservice;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiGatewayClient {

    public static final String APIGATEWAY = "apigateway";
    private EurekaClient eurekaClient;

    public ApiGatewayClient(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @CircuitBreaker(name = "review", fallbackMethod = "reviewFallBack")
    public List<ReviewInfo> getAllReviews() {
        InstanceInfo instanceInfo = getInstanceInfo();
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        ResponseEntity<ReviewInfo[]> response = restTemplate.getForEntity(
                String.format("http://%s:%s/reviews", instanceInfo.getIPAddr(), instanceInfo.getPort()),
                ReviewInfo[].class);
        ReviewInfo[] reviews = response.getBody();
        return reviews == null ? new ArrayList<>() : Arrays.asList(reviews);
    }

    @CircuitBreaker(name = "review", fallbackMethod = "reviewFallBack")
    public List<ReviewInfo> getReviews(Long productId) {
        InstanceInfo instanceInfo = getInstanceInfo();
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        ResponseEntity<ReviewInfo[]> response = restTemplate.getForEntity(
                String.format("http://%s:%s/products/%d/reviews", instanceInfo.getIPAddr(), instanceInfo.getPort(), productId),
                ReviewInfo[].class);
        ReviewInfo[] reviews = response.getBody();
        return reviews == null ? new ArrayList<>() : Arrays.asList(reviews);
    }

    private InstanceInfo getInstanceInfo() {
        Application application = eurekaClient.getApplication(APIGATEWAY);
        return application.getInstances().get(0);
    }

    private List<ReviewInfo> reviewFallBack(Throwable t) {
        return new ArrayList<>();
    }
}
