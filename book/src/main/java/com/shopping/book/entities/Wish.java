package com.shopping.book.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "wish_table")
public class Wish {
    @Id
    @SequenceGenerator(
            name = "wish_sequence",
            sequenceName = "wish_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wish_sequence"
    )
    @Column(name = "wish_id")
    private Long wishId;
    private String url;
    private Long noOfWish;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "For_Order_id")
//    private Order order;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Many_Order_id",referencedColumnName = "wish_id")
    private List<Order> order;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String  getNoOfWish() {
        return noOfWish.toString();
    }

    public void setNoOfWish(Long noOfWish) {
        this.noOfWish = noOfWish;
    }
}