package com.styshak.repositories;

import com.styshak.domains.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sergey on 17.03.17.
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
