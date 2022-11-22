package fooddelivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fooddelivery.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_OrderStatusChange(@Payload DeliveryStarted deliveryStarted){

    DeliveryStarted event = deliveryStarted;
        
        if(event.getOrderId()!=null) {
            orderRepository.findById(Long.valueOf(event.getOrderId())).ifPresent((order)->{
               order.setStatus("배달시작됨");
               orderRepository.save(order);
            });
        }
    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryCompleted'")
    public void wheneverDeliveryCompleted_OrderStatusChange(@Payload DeliveryCompleted deliveryCompleted){
        
    DeliveryCompleted event = deliveryCompleted;
        
        orderRepository.findById(Long.valueOf(event.getOrderId())).ifPresent((order)->{
           order.setStatus("배달완료됨");
           orderRepository.save(order);
        });
    }
}
