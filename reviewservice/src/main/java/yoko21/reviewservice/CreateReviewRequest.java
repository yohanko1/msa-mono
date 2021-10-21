package yoko21.reviewservice;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateReviewRequest {
    private String content;
}
