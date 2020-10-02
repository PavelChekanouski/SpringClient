package chekanouski.pavel.springclient.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Image {
    private long id;
    private String imageURL;
}
