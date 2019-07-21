package com.demo.dao;

import com.demo.dataobject.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 皇甫
 */
public interface StudentDao extends JpaRepository<StudentEntity,String> {}
