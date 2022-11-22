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
    @Autowired NotificaitonRepository notificaitonRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CouponPublished'")
    public void wheneverCouponPublished_Notified(@Payload CouponPublished couponPublished){

        CouponPublished event = couponPublished;
        System.out.println("\n\n##### listener Notified : " + couponPublished + "\n\n");


        

        // Sample Logic //
        Notificaiton.notified(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCompleted'")
    public void wheneverOrderCompleted_Notified(@Payload OrderCompleted orderCompleted){

        OrderCompleted event = orderCompleted;
        System.out.println("\n\n##### listener Notified : " + orderCompleted + "\n\n");


        

        // Sample Logic //
        Notificaiton.notified(event);
        

        

    }

}


