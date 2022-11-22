package foodtest.domain;

import foodtest.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class EndCooking extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long shopId;
    private Integer price;
    private String status;
}
