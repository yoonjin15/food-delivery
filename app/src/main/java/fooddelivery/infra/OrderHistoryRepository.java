package fooddelivery.infra;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="orderHistories", path="orderHistories")
public interface OrderHistoryRepository extends PagingAndSortingRepository<OrderHistory, Long> {

    

    
}
