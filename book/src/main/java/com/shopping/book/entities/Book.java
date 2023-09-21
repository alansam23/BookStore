package com.shopping.book.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "book_table",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_code_for_each_book",
                columnNames = "book_code"
        )
)
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long bookId;
    @Column(name = "book_code")
    private Long bookCode;
    private String bookName;
    private String author;
    @NotNull(message = "Pages Cannot be null")
    private Long pages;

    @ManyToMany(mappedBy = "assignBooks")//,fetch = FetchType.LAZY)
    private Set<Cart> carts ;
    public String getBookCode() {
        return bookCode.toString();
    }

    public void setBookCode(Long bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPages() {
        return pages.toString();
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }
    public Set<Cart> getCarts() {
        return carts;
    }
}