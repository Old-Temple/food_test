package foodtest.external;

import lombok.Data;
import java.util.Date;
@Data
public class Order {

    private Long id;
    private Long menuId;
    private Long customerId;
    private String customerAddress;
    private String status;
    private Integer price;
    private Long shopId;
}


