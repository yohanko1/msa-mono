package yoko21.reviewservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


public class ReviewDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Info {
        private Long id;
        private Long productId;
        private String content;

        public Info(Review review) {
            this.id = review.getId();
            this.productId = review.getProductId();
            this.content = review.getContent();
        }

        public Review toEntity() {
            return Review.builder()
                    .id(id)
                    .productId(productId)
                    .content(content)
                    .build();
        }
    }
}
