package com.demo.service.impl;

import com.demo.dao.StudentDao;
import com.demo.dataobject.StudentEntity;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 皇甫
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public void saveStudents(List<StudentEntity> studentEntities) {
        studentDao.saveAll(studentEntities);
    }
}
