package com.styshak.repositories;

import com.styshak.domains.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	/*@Query(value = "SELECT id, name, page_count, author_id FROM book WHERE name = :letter \n#pageable\n", nativeQuery = true)
	public Page<Book> findByLetter(Pageable pageable, @Param("letter") Character letter);*/

	public Page<Book> findByName(String name, Pageable pageable);
}
