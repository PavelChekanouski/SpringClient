package chekanouski.pavel.springclient.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Product {
    private Long id;
    private String name;
    private Brand brand;
    private List<Specification> specificationList = new ArrayList<>();
    private List<Image> images = new ArrayList<>();
}

