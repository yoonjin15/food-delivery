package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Notified extends AbstractEvent {

    private Long id;
    private String orderId;
    private String customerId;
    private String message;

    public Notified(Notificaiton aggregate){
        super(aggregate);
    }
    public Notified(){
        super();
    }
}
