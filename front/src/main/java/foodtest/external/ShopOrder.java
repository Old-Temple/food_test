package foodtest.external;

import lombok.Data;
import java.util.Date;
@Data
public class ShopOrder {

    private Long id;
    private Long menuId;
    private Long shopId;
    private Integer price;
    private String status;
}


