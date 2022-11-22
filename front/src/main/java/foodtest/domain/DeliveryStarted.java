package foodtest.domain;

import foodtest.domain.*;
import foodtest.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long shopId;
    private Long customerId;
    private Integer price;
    private String customerAddress;
    private String shopAddress;
}


