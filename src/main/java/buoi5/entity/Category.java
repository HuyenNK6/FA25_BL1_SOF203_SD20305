package buoi5.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Category {
    private Integer id;
    private String code;
    private String name;
}
