package hello.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name="account")
public class AccountEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String description;
    private String image;

}
