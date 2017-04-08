package com.styshak.repositories;

import com.styshak.domains.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Lob;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	Page<Book> findByNameStartingWithIgnoreCase(String name, Pageable pageable);

	Page<Book> findByAuthor_NameContaining(String authorName, Pageable pageable);

	Page<Book> findByNameContainingIgnoreCase(String bookName, Pageable pageable);

	Page<Book> findByGenre_Id(long genreId, Pageable pageable);

	@Query(value = "SELECT content FROM book WHERE id = :bookId", nativeQuery = true)
	byte[] getContent(@Param("bookId") long bookId);

	@Query(value = "SELECT image FROM book WHERE id = :bookId", nativeQuery = true)
	byte[] getImage(@Param("bookId") long bookId);

	@Query(value = "SELECT name FROM book WHERE id = :bookId", nativeQuery = true)
	String getBookNameById(@Param("bookId") long bookId);

	@Modifying
	@Query(value = "UPDATE book SET image = :image WHERE id = :bookId", nativeQuery = true)
	void updateImage(@Param("bookId") long bookId, @Param("image") byte[] image);

	@Modifying
	@Query(value = "UPDATE book SET content = :content WHERE id = :bookId", nativeQuery = true)
	void updateContent(@Param("bookId") long bookId, @Param("content") byte[] content);
}
