package com.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 皇甫
 */
@Entity
@Data
@DynamicUpdate
public class StudentEntity {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String clazz;
    private Date date;

    public StudentEntity() {
    }

    public StudentEntity(String id, String name, Integer age, String clazz, Date date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clazz = clazz;
        this.date = date;
    }
}
