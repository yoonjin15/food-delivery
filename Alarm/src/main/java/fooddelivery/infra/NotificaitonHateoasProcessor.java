package fooddelivery.infra;
import fooddelivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class NotificaitonHateoasProcessor implements RepresentationModelProcessor<EntityModel<Notificaiton>>  {

    @Override
    public EntityModel<Notificaiton> process(EntityModel<Notificaiton> model) {

        
        return model;
    }
    
}
