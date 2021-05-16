package com.andersen.webroomba.entity;

import com.andersen.webroomba.entity.basic.PersistentEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Entity
public class Input  extends PersistentEntity {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Input input = (Input) o;
        return Objects.equals(getConfiguration(), input.getConfiguration()) &&
                Objects.equals(getCreationDate(), input.getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getConfiguration(), getCreationDate());
    }


}
