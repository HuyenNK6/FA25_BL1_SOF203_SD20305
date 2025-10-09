package buoi11.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class GiangVien {
    private Integer id;
    private String ma;
    private String ten;
    private Integer tuoi;
    private Boolean gioiTinh;
    private String queQuan;
}
