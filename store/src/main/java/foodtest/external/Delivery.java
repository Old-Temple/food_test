package foodtest.external;

import lombok.Data;
import java.util.Date;
@Data
public class Delivery {

    private Long id;
    private Long menuId;
    private Long shopId;
    private Long customerId;
    private Integer price;
    private String customerAddress;
    private String shopAddress;
}


