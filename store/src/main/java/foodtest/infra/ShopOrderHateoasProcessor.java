package foodtest.infra;
import foodtest.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class ShopOrderHateoasProcessor implements RepresentationModelProcessor<EntityModel<ShopOrder>>  {

    @Override
    public EntityModel<ShopOrder> process(EntityModel<ShopOrder> model) {

        
        return model;
    }
    
}
