package com.andersen.webroomba.repository;

import com.andersen.webroomba.entity.implementation.InputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Yaroslav Dmitriev (
 * @since 15.05.2021
 */
@Repository
public interface InputRepository extends JpaRepository<InputEntity, Long> {

}
