package com.andersen.webroomba.entity.basic;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@MappedSuperclass
public abstract class PersistentEntity implements Identifiable<Long> {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        PersistentEntity that = (PersistentEntity) other;

        return Objects.equals(id, that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}