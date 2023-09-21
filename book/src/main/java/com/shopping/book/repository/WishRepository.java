package com.shopping.book.repository;

import com.shopping.book.entities.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish, Long> {
}
