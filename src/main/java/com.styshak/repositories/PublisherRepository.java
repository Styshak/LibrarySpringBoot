package com.styshak.repositories;

import com.styshak.domains.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sergey on 17.03.17.
 */
@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
