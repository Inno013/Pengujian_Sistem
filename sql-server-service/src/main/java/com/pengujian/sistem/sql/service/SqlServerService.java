package com.pengujian.sistem.sql.service;

import com.pengujian.sistem.sql.model.ProsesLogLine;
import com.pengujian.sistem.sql.model.ProsesLogTable;
import com.pengujian.sistem.sql.repository.ProsesLogLineRepository;
import com.pengujian.sistem.sql.repository.ProsesLogTableRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SqlServerService {
    private final ProsesLogLineRepository prosesLogLineRepository;
    private final ProsesLogTableRepository prosesLogTableRepository;

    public SqlServerService(ProsesLogLineRepository prosesLogLineRepository, ProsesLogTableRepository prosesLogTableRepository) {
        this.prosesLogLineRepository = prosesLogLineRepository;
        this.prosesLogTableRepository = prosesLogTableRepository;
    }

    public List<ProsesLogLine> getAllProsesLogLine() {
        return prosesLogLineRepository.getAllProsesLogLine() ;
    }

    @Transactional
    public List<Boolean> saveProsesLogLine(List<ProsesLogLine> proseslogline) {
        List<Boolean> results = new ArrayList<>();
        for(ProsesLogLine logLine : proseslogline){
            boolean result = prosesLogLineRepository.saveProsesLogLine(logLine);
            results.add(result);
        }
        return results;
    }

    public List<ProsesLogTable> getAllProsesLogTable() {
        return prosesLogTableRepository.getAllProsesLogTable() ;
    }

    @Transactional
    public List<Boolean> saveProsesLogTable(List<ProsesLogTable> prosesLogTables) {
        List<Boolean> results = new ArrayList<>();
        for (ProsesLogTable logTable : prosesLogTables){
            boolean result = prosesLogTableRepository.saveProsesLogTable(logTable);
            results.add(result);
        }
        return results;
    }

}