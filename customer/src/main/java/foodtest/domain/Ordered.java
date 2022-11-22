package foodtest.domain;

import foodtest.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Ordered extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long customerId;
    private Integer price;
    private Long shopId;
}
