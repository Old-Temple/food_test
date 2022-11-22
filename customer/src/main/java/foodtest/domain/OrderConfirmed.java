package foodtest.domain;

import foodtest.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class OrderConfirmed extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long customerId;
    private String customerAddress;
    private Integer price;
    private Long shopId;
}
