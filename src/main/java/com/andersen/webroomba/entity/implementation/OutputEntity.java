package com.andersen.webroomba.entity.implementation;

import com.andersen.webroomba.entity.inner.GridCleaningResult;
import com.andersen.webroomba.entity.Identifiable;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * It is an entity class, that holds inner object
 * @see GridCleaningResult
 * in a DB.
 * In addition it has an id, foreign key to input  and creation day to help a user to identify an input.
 *
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */

@Entity
public class OutputEntity implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "input_id")
    private InputEntity input;

    @Column
    private String result;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public InputEntity getInput() {
        return input;
    }

    public void setInput(InputEntity input) {
        this.input = input;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
        OutputEntity output = (OutputEntity) o;
        return Objects.equals(getInput(), output.getInput()) &&
                Objects.equals(getResult(), output.getResult()) &&
                Objects.equals(getCreationDate(), output.getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getInput(), getResult(), getCreationDate());
    }


}
