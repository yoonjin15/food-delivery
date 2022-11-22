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
    @Autowired OrderManagementRepository orderManagementRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_OrderInfoReceived(@Payload Paid paid){

        if(paid.isMe()){
            OrderManagement orderManagement = new OrderManagement();
            orderManagement.setOrderId(Long.valueOf(paid.getOrderId()));
            orderManagementRepository.save(orderManagement);
        }
    }
    
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_OrderReject(@Payload OrderCanceled orderCanceled){

        if(orderCanceled.isMe()){
            orderManagementRepository.findById(orderCanceled.getOrderId()).ifPresent(OrderManagement->{
                orderManagementRepository.delete(orderManagement);
            });
        }
    }

}
