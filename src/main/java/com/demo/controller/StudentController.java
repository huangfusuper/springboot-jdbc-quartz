package com.demo.controller;

import com.demo.dataobject.LogEntity;
import com.demo.dataobject.StudentEntity;
import com.demo.service.LogService;
import com.demo.service.StudentService;
import com.demo.util.DateUtil;
import com.demo.util.TestDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author 皇甫
 */
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;
    @Autowired
    private LogService logService;

    @RequestMapping("saveStudent")
    public String saveStudent() throws ParseException {
        List<StudentEntity> datas = TestDataUtil.getData();
        threadPoolExecutor.submit(() -> {
            System.out.println("-----------------------线程开始运行--------------------");
            List<StudentEntity> students = datas.stream().filter(studentEntity -> {
                int days = DateUtil.getDays(studentEntity.getDate(), new Date());
                return days > 300;
            }).collect(Collectors.toList());

            List<LogEntity> collect = students.stream().map(s -> {
                LogEntity logEntity = new LogEntity();
                logEntity.setImportDate(new Date());
                logEntity.setId(UUID.randomUUID().toString().replace("-", ""));
                logEntity.setLogData("错误信息:name=【" + s.getName() + "】；date=【" + s.getDate() + "】;");
                return logEntity;
            }).collect(Collectors.toList());

            logService.saveLogs(collect);
            System.out.println("-----------------------线程开始结束--------------------");
        });

        studentService.saveStudents(datas);
        return "OJBK";
    }
}
