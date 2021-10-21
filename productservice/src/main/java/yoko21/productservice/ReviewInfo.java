package yoko21.productservice;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class ReviewInfo {
    private Long id;
    private Long productId;
    private String content;
}


