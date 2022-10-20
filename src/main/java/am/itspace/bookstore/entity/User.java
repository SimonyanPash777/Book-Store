package am.itspace.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table (name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @Enumerated (value = EnumType.STRING)
    private UserRole userRole;
    private boolean isEnable;
    private String phoneNumber;
    @Column(name = "verify_token")
    private String verifyToken;
}
