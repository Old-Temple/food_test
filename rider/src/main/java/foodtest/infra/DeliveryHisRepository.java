package foodtest.infra;

import foodtest.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="deliveryHis", path="deliveryHis")
public interface DeliveryHisRepository extends PagingAndSortingRepository<DeliveryHis, Long> {

    

    
}
