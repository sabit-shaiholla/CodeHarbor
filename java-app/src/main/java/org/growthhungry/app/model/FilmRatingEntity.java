package org.growthhungry.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "film_rating", schema = "sakila")
public class FilmRatingEntity {

    public FilmRatingEntity() {
    }

    public FilmRatingEntity(short filmId, short stars){
        this.filmId = filmId;
        this.stars = stars;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "film_rating_id")
    private short filmRatingId;
    @Basic
    @Column(name = "film_id")
    private short filmId;
    @Basic
    @Column(name = "stars")
    private short stars;

    public short getFilmRatingId() {
        return filmRatingId;
    }

    public void setFilmRatingId(short filmRatingId) {
        this.filmRatingId = filmRatingId;
    }

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public short getStars() {
        return stars;
    }

    public void setStars(short stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmRatingEntity that = (FilmRatingEntity) o;

        if (filmRatingId != that.filmRatingId) return false;
        if (filmId != that.filmId) return false;
        if (stars != that.stars) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) filmRatingId;
        result = 31 * result + (int) filmId;
        result = 31 * result + (int) stars;
        return result;
    }
}
