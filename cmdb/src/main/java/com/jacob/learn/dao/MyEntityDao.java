package com.jacob.learn.dao;

import com.jacob.learn.entity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyEntityDao extends JpaRepository<MyEntity, Integer> {
    List<MyEntity> findByIsDelete(Boolean isDelete);
}
