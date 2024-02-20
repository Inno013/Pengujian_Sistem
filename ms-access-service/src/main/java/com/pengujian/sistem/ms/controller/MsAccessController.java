package com.pengujian.sistem.ms.controller;

import com.pengujian.sistem.ms.model.ProsesLogLine;
import com.pengujian.sistem.ms.model.ProsesLogTable;
import com.pengujian.sistem.ms.service.FileService;
import com.pengujian.sistem.ms.service.MsAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class MsAccessController {

    @Autowired
    private FileService service;
    @Autowired
    private MsAccessService service1;

    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        if(service.cekCsvFormat(file)){
            String respon = service.prosesDanSaveData(file);
            if(respon.contains("Masukan file")){
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                        .body(respon);
            }
            return ResponseEntity.status(HttpStatus.OK)
                    .body(respon);
        }
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Tolong unggah file CSV");
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
