package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCompleted extends AbstractEvent {

    private Long id;
    private String foodId;
    private String customerId;
    private String storeId;

    public OrderCompleted(Order aggregate){
        super(aggregate);
    }
    public OrderCompleted(){
        super();
    }
}
