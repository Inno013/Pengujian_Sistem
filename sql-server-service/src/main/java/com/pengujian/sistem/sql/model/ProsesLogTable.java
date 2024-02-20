package com.pengujian.sistem.sql.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProsesLogTable {
    private Long id;
    private String completed;
    private String cmpnycd;
    private String rcvno;
    private String rxArrangementNumber;
    private Integer processLogCount;
    private String passDate;
    private String passTime;
    private String productionCompanyCode;
    private String productionPlaceCode;
    private Integer breakageCount;
    private String breakageId;
    private Integer totdetline;
    private LocalDateTime amddate;

    public ProsesLogTable(String completed, String cmpnycd, String rcvno, String rxArrangementNumber, Integer processLogCount, String passDate, String passTime, String productionCompanyCode, String productionPlaceCode, Integer breakageCount, String breakageId, Integer totdetline, LocalDateTime amddate) {
        this.completed = completed;
        this.cmpnycd = cmpnycd;
        this.rcvno = rcvno;
        this.rxArrangementNumber = rxArrangementNumber;
        this.processLogCount = processLogCount;
        this.passDate = passDate;
        this.passTime = passTime;
        this.productionCompanyCode = productionCompanyCode;
        this.productionPlaceCode = productionPlaceCode;
        this.breakageCount = breakageCount;
        this.breakageId = breakageId;
        this.totdetline = totdetline;
        this.amddate = amddate;
    }
}