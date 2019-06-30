package com.demo.dao;

import com.demo.dataobject.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 皇甫
 */
public interface TaskDao extends JpaRepository<TaskEntity,String> {}
