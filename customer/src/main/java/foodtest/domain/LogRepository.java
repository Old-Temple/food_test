package foodtest.domain;

import foodtest.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="logs", path="logs")
public interface LogRepository extends PagingAndSortingRepository<Log, Long>{

}
