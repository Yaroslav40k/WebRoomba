package com.andersen.webroomba.entity;

import com.andersen.webroomba.entity.basic.PersistentEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */

@Entity
public class Output extends PersistentEntity {

    @OneToOne
    @JoinColumn(name = "input_id")
    private Input input;

    @Column
    private String result;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Output output = (Output) o;
        return Objects.equals(getInput(), output.getInput()) &&
                Objects.equals(getResult(), output.getResult()) &&
                Objects.equals(getCreationDate(), output.getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getInput(), getResult(), getCreationDate());
    }


}
