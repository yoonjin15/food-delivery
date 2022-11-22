package fooddelivery.domain;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="notificaitons", path="notificaitons")
public interface NotificaitonRepository extends PagingAndSortingRepository<Notificaiton, Long>{

}
