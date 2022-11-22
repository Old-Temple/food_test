package foodtest.domain;

import foodtest.domain.*;
import foodtest.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderChecked extends AbstractEvent {

    private Long id;
    private Long menuId;
    private Long customerId;
    private Long shopId;

    public OrderChecked(Order aggregate){
        super(aggregate);
    }
    public OrderChecked(){
        super();
    }
}
