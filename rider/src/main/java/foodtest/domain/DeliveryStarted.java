package foodtest.domain;

import foodtest.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long shopId;
    private Long customerId;
    private Integer price;
    private String customerAddress;
    private String shopAddress;
}
