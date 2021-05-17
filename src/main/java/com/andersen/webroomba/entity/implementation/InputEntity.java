package com.andersen.webroomba.entity.implementation;

import com.andersen.webroomba.entity.inner.GridConfiguration;
import com.andersen.webroomba.entity.Identifiable;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * It is an entity class, that holds inner object
 * @see GridConfiguration
 * in a DB.
 * In addition it has an id  and creation day to help a user to identify an input.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Entity
public class InputEntity implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String configuration;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InputEntity input = (InputEntity) o;
        return Objects.equals(getConfiguration(), input.getConfiguration()) &&
                Objects.equals(getCreationDate(), input.getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getConfiguration(), getCreationDate());
    }


}
