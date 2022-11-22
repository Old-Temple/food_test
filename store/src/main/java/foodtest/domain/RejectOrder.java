package foodtest.domain;

import foodtest.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class RejectOrder extends AbstractEvent {

    public RejectOrder(ShopOrder shopOrder) {
    }
    private Long id;
    private Long menuId;
    private Long shopId;
    private Integer price;
    private String status;
}
