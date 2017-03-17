package com.styshak.repositories;

import com.styshak.domains.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	Page<Book> findByNameStartingWithIgnoreCase(String name, Pageable pageable);

	//Page<Book> findByAuthor_Id(long authorId, Pageable pageable);

	Page<Book> findByAuthor_NameContaining(String authorName, Pageable pageable);

	Page<Book> findByNameContainingIgnoreCase(String bookName, Pageable pageable);

	Page<Book> findByGenre_Id(long genreId, Pageable pageable);

	@Query(value = "SELECT content FROM book WHERE id = :bookId", nativeQuery = true)
	byte[] getContent(@Param("bookId") long bookId);

	@Query(value = "SELECT image FROM book WHERE id = :bookId", nativeQuery = true)
	byte[] getImage(@Param("bookId") long bookId);

	@Query(value = "SELECT name FROM book WHERE id = :bookId", nativeQuery = true)
	String getBookNameById(@Param("bookId") long bookId);
}
