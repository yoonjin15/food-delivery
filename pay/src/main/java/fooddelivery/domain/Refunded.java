package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Refunded extends AbstractEvent {

    private Long id;
    private String orderId;

    public Refunded(Payment aggregate){
        super(aggregate);
    }
    public Refunded(){
        super();
    }
}
