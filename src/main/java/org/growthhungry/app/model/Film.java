package org.growthhungry.app.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "film", schema = "sakila")
public class Film {

    public Film() {
    }

    public Film(short filmId, String title, short length){
        this.filmId = filmId;
        this.title = title;
        this.length = length;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "film_id")
    private short filmId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "release_year", columnDefinition = "year")
    private Object releaseYear;
    @Basic
    @Column(name = "language_id")
    private short languageId;
    @Basic
    @Column(name = "original_language_id")
    private Short originalLanguageId;
    @Basic
    @Column(name = "rental_duration")
    private short rentalDuration;
    @Basic
    @Column(name = "rental_rate")
    private Float rentalRate;
    @Basic
    @Column(name = "length")
    private Short length;
    @Basic
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;
    @Basic
    @Column(name = "rating", columnDefinition = "enum('G','PG','PG-13','R','NC-17')")
    private Object rating;
    @Basic
    @Column(name = "special_features", columnDefinition = "set('Trailers','Commentaries','Deleted Scenes','Behind the Scenes')")
    private Object specialFeatures;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "film_actor",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private List<Actor> actors = new ArrayList<>();

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Object releaseYear) {
        this.releaseYear = releaseYear;
    }

    public short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(short languageId) {
        this.languageId = languageId;
    }

    public Short getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Short originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public short getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Float getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Float rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    public Object getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(Object specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film that = (Film) o;

        if (filmId != that.filmId) return false;
        if (languageId != that.languageId) return false;
        if (rentalDuration != that.rentalDuration) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (releaseYear != null ? !releaseYear.equals(that.releaseYear) : that.releaseYear != null) return false;
        if (originalLanguageId != null ? !originalLanguageId.equals(that.originalLanguageId) : that.originalLanguageId != null)
            return false;
        if (rentalRate != null ? !rentalRate.equals(that.rentalRate) : that.rentalRate != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (replacementCost != null ? !replacementCost.equals(that.replacementCost) : that.replacementCost != null)
            return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (specialFeatures != null ? !specialFeatures.equals(that.specialFeatures) : that.specialFeatures != null)
            return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) filmId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        result = 31 * result + (int) languageId;
        result = 31 * result + (originalLanguageId != null ? originalLanguageId.hashCode() : 0);
        result = 31 * result + (int) rentalDuration;
        result = 31 * result + (rentalRate != null ? rentalRate.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (replacementCost != null ? replacementCost.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (specialFeatures != null ? specialFeatures.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
