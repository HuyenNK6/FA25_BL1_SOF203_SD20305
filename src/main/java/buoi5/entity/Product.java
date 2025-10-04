package buoi5.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Product {
    private Integer id;
    private String code;
    private String name;
    private Double price;
    private String description;
//    private Integer categoryID;
    private Category category;
}
