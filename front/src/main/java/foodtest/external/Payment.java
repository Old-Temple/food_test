package foodtest.external;

import lombok.Data;
import java.util.Date;
@Data
public class Payment {

    private Long id;
    private Integer price;
    private Long customerId;
    private Long shopId;
    private Long menuId;
    private Boolean status;
}


