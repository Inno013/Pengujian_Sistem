package com.pengujian.sistem.ms.repository;

import com.pengujian.sistem.ms.model.ProsesLogTable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProsesLogTableRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProsesLogTableRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProsesLogTable> getAllProsesLogTable() {
        String sql = "SELECT * FROM Proses_log_table";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProsesLogTable.class));
    }

    public ProsesLogTable saveProsesLogTable(ProsesLogTable proseslogtable) {
        String sql = "INSERT INTO Proses_log_table (Completed, CMPNYCD, RCVNO, RX_ARRANGEMENT_NUMBER, PROCESS_LOG_COUNT,\n" +
                "PASS_DATE, PASS_TIME, PRODUCTION_COMPANY_CODE, PRODUCTION_PLACE_CODE,\n" +
                "BREAKAGE_COUNT, BREAKAGE_ID, TOTDETLINE, AMDDATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                proseslogtable.getCompleted(),
                proseslogtable.getCmpnycd(),
                proseslogtable.getRcvno(),
                proseslogtable.getRxArrangementNumber(),
                proseslogtable.getProcessLogCount(),
                proseslogtable.getPassDate(),
                proseslogtable.getPassTime(),
                proseslogtable.getProductionCompanyCode(),
                proseslogtable.getProductionPlaceCode(),
                proseslogtable.getBreakageCount(),
                proseslogtable.getBreakageId(),
                proseslogtable.getTotdetline(),
                proseslogtable.getAmddate()
        );
        return proseslogtable;
    }

}
