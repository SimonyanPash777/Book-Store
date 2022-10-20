package am.itspace.bookstore.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_orders")
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Book book;
    @ManyToOne
    private User user;
    @DateTimeFormat (pattern = "yyyy-MM-dd hh:mm:ss")
    private Date orderDateTime;
}
