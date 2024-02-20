package com.pengujian.sistem.sql.controller;

import com.pengujian.sistem.sql.model.ProsesLogLine;
import com.pengujian.sistem.sql.model.ProsesLogTable;
import com.pengujian.sistem.sql.service.FileService;
import com.pengujian.sistem.sql.service.SqlServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SqlServerController {
    @Autowired
    private FileService service;
    @Autowired
    private SqlServerService service1;

    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") List<MultipartFile> files){
        try {
            List<MultipartFile> fileCek = service.cekCsvFormat(files);
            for (MultipartFile file : fileCek){
                service.prosesDanSaveData(file);
            }
            return ResponseEntity.ok("Sukses Upload File");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error terjadi " + e.getMessage());
        }
    }

    @GetMapping(value =  "/finds/logline")
    public List<ProsesLogLine> findsLogline(){
        List<ProsesLogLine> logLines = service1.getAllProsesLogLine();
        return logLines;
    }

    @GetMapping(value =  "/finds/logtable")
    public List<ProsesLogTable> findsLogTable(){
        List<ProsesLogTable> logTables = service1.getAllProsesLogTable();
        return logTables;
    }

}
