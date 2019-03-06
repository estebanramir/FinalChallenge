package hello.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name="lista")
public class ListEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Long idAccount;
    private Long idSerie;
    private int rank;
    private TipoLista tipo;


}
