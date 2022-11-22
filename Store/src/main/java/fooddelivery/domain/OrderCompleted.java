package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class OrderCompleted extends AbstractEvent {

    private Long id;
    private String foodId;
    private String customerId;
    private String storeId;
}
