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
public class LogEntity {
    @Id
    private String id;
    private Date importDate;
    private String logData;

    public LogEntity(String id, Date importDate, String logData) {
        this.id = id;
        this.importDate = importDate;
        this.logData = logData;
    }

    public LogEntity() {
    }
}
