package fooddelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class Delivery {

    private Long id;
    private String orderId;
    private String address;
}


