package com.demo.dao;

import com.demo.dataobject.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 皇甫
 */
public interface LogDao extends JpaRepository<LogEntity,String> {}
