package foodtest.domain;

import foodtest.domain.*;
import foodtest.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class PayCancled extends AbstractEvent {

    private Long id;
    private Integer price;
    private Long customerId;
    private Long shopId;
    private Long menuId;
    private Boolean status;
}


