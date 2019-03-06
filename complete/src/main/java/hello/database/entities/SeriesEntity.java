package hello.database.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name="series")
public class SeriesEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String showType;
    private String status;
    private String ageRatinkg;
    private int watched;
    private int favorited;
    private double rank;



}
