package foodtest.domain;

import foodtest.domain.*;
import foodtest.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class RejectOrder extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long shopId;
    private Integer price;
    private String status;
}


