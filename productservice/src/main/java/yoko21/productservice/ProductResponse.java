package yoko21.productservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private Integer price;
    private List<Review> reviews;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class Review {
    private Long id;
    private String content;
}