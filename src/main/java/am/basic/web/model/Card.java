package am.basic.web.model;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    private String number;
}