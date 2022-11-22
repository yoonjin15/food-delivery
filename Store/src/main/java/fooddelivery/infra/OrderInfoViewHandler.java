package fooddelivery.infra;

import fooddelivery.config.kafka.KafkaProcessor;
import fooddelivery.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoViewHandler {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCompleted_then_CREATE_1(
        @Payload OrderCompleted orderCompleted
    ) {
        try {
            if (!orderCompleted.validate()) return;

            // view 객체 생성
            OrderInfo orderInfo = new OrderInfo();
            // view 객체에 이벤트의 Value 를 set 함
            orderInfo.setOrderId(String.valueOf(orderCompleted.getId()));
            // view 레파지 토리에 save
            orderInfoRepository.save(orderInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
