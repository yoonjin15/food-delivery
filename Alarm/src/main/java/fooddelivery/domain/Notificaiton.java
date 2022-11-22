package fooddelivery.domain;

import fooddelivery.domain.Notified;
import fooddelivery.AlarmApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Notificaiton_table")
@Data

public class Notificaiton  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String message;

    @PostPersist
    public void onPostPersist(){


        Notified notified = new Notified(this);
        notified.publishAfterCommit();

    }

    public static NotificaitonRepository repository(){
        NotificaitonRepository notificaitonRepository = AlarmApplication.applicationContext.getBean(NotificaitonRepository.class);
        return notificaitonRepository;
    }




    public static void notified(CouponPublished couponPublished){

        /** Example 1:  new item 
        Notificaiton notificaiton = new Notificaiton();
        repository().save(notificaiton);

        */

        /** Example 2:  finding and process
        
        repository().findById(couponPublished.get???()).ifPresent(notificaiton->{
            
            notificaiton // do something
            repository().save(notificaiton);


         });
        */

        
    }
    public static void notified(OrderCompleted orderCompleted){

        repository.findById(orderCompleted.getId().ifPresent(notificaiton))->{
            
            notificaiton.setMessage("알림메시지");
            repository().save(notificaiton);

         });       
    }


}
