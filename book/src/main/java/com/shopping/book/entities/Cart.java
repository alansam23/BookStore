package com.shopping.book.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cart_table")
public class Cart {
    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"
    )
    @Column(name = "cart_id")
    private Long cartId;
    private String noOfItems;
    private boolean confirm;

    @ManyToMany(cascade = CascadeType.ALL)//fetch = FetchType.LAZY
    @JoinTable(
            name = "book_assign",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> assignBooks;
    public String getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(String noOfItems) {
        this.noOfItems = noOfItems;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public Set<Book> getAssignBooks() {
        return assignBooks;
    }

    public void assignBooks(Book book) {
        assignBooks.add(book);
    }
}
