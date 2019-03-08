package hello.database.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name="series")
public class SeriesEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String showType;
    private String status;
    private String ageRating;
    private int watched;
    private int favorited;
    private double rank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgeRatinkg() {
        return ageRating;
    }

    public void setAgeRatinkg(String ageRatinkg) {
        this.ageRating = ageRatinkg;
    }

    public int getWatched() {
        return watched;
    }

    public void setWatched(int watched) {
        this.watched = watched;
    }

    public int getFavorited() {
        return favorited;
    }

    public void setFavorited(int favorited) {
        this.favorited = favorited;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }
}
