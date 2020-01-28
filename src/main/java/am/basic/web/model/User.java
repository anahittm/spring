package am.basic.web.model;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
@Data
@Entity
@Table(name = "user", schema = "test")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, length = 32, unique = true)
    private long id;
    @Transient
    private String username;
    @NotBlank
    private String surname;
    @Size(min = 1, max = 15, message = "")
    private int age;
    private String name;
    private String password;
    private String code;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="user_Id",referencedColumnName ="id" )
    private List<Action> action;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Card card;
    public User() {
    }
    //comment
}