package com.shopping.book.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "order_table")
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column(name = "order_id")
    private Long orderId;
    private Long price;
    private boolean confirm;
//    @OneToOne(mappedBy = "order")
//    private Wish wish;
    public String getPrice() {
        return price.toString();
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
//        this.confirm = Boolean.parseBoolean(String.valueOf(confirm));
    }
}
