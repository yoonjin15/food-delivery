package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String storeId;
    private String orderId;
    private String couponId;

    public DeliveryStarted(OrderManagement aggregate){
        super(aggregate);
    }
    public DeliveryStarted(){
        super();
    }
}
