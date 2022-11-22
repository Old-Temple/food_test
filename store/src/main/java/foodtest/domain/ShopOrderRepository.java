package foodtest.domain;

import foodtest.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="shopOrders", path="shopOrders")
public interface ShopOrderRepository extends PagingAndSortingRepository<ShopOrder, Long>{

}
