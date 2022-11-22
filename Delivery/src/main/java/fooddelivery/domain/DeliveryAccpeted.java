package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryAccpeted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String address;

    public DeliveryAccpeted(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryAccpeted(){
        super();
    }
}
