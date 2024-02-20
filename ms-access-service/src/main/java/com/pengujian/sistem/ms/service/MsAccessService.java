package com.pengujian.sistem.ms.service;

import com.pengujian.sistem.ms.model.ProsesLogLine;
import com.pengujian.sistem.ms.model.ProsesLogTable;
import com.pengujian.sistem.ms.repository.ProsesLogLineRepository;
import com.pengujian.sistem.ms.repository.ProsesLogTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsAccessService {
    private final ProsesLogLineRepository prosesLogLineRepository;
    private final ProsesLogTableRepository prosesLogTableRepository;

    public MsAccessService(ProsesLogLineRepository prosesLogLineRepository, ProsesLogTableRepository prosesLogTableRepository) {
        this.prosesLogLineRepository = prosesLogLineRepository;
        this.prosesLogTableRepository = prosesLogTableRepository;
    }

    public List<ProsesLogLine> getAllProsesLogLine() {
        return prosesLogLineRepository.getAllProsesLogLine() ;
    }

    public void saveProsesLogLine(List<ProsesLogLine> prosesLogLines) {
        for (ProsesLogLine logLine : prosesLogLines){
            prosesLogLineRepository.saveProsesLogLine(logLine);
        }
    }


    public List<ProsesLogTable> getAllProsesLogTable() {
        return prosesLogTableRepository.getAllProsesLogTable() ;
    }

    public void saveProsesLogTable(List<ProsesLogTable> prosesLogTables) {
        for (ProsesLogTable logTable : prosesLogTables){
            prosesLogTableRepository.saveProsesLogTable(logTable);
        }
    }

}