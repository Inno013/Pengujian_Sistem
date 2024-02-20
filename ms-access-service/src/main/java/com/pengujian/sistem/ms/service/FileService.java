package com.pengujian.sistem.ms.service;

import com.pengujian.sistem.ms.model.ProsesLogLine;
import com.pengujian.sistem.ms.model.ProsesLogTable;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private MsAccessService service;

    public boolean cekCsvFormat(MultipartFile file){
        String type = "text/csv";
        if(!type.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public  String prosesDanSaveData(MultipartFile file){
        try{
            if(file.getOriginalFilename().contains("ProcessLogLine")){
                List<ProsesLogLine> logLines = CsvKeLogLines(file.getInputStream());
                service.saveProsesLogLine(logLines);
                return "File Proses Log Line Berhasil di save ke database";
            }else if(file.getOriginalFilename().contains("ProcessLogTable")){
                List<ProsesLogTable> logTables = CsvKeLogTables(file.getInputStream());
                service.saveProsesLogTable(logTables);
                return "File Proses Log Table Berhasil di save ke database";
            }else {
                return  "Masukan file Proses Log Line atau Proses Log Table";
            }
        } catch (IOException e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public List<ProsesLogLine> CsvKeLogLines(InputStream data){
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(data, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        ){
            List<CSVRecord> records = csvParser.getRecords();
            List<ProsesLogLine> logLines = new ArrayList<ProsesLogLine>();
            for(CSVRecord record : records){
                ProsesLogLine logLine = new ProsesLogLine(
                        record.get("CMPNYCD"),
                        record.get("RCVNO"),
                        record.get("RX_ARRANGEMENT_NUMBER"),
                        Integer.parseInt(record.get("PROCESS_LOG_COUNT")),
                        record.get("LENS_RL_TYPE"),
                        Integer.parseInt(record.get("PREVIOUS_PROCESS_NUMBER")),
                        Integer.parseInt(record.get("PREVIOUS_SUBPROCESS_NUMBER")),
                        Integer.parseInt(record.get("CURRENT_PROCESS_NUMBER")),
                        Integer.parseInt(record.get("CURRENT_SUBPROCESS_NUMBER")),
                        record.get("DIP_LOT_NUMBER"),
                        record.get("COAT_LOT_NUMBER"),
                        record.get("BREAKAGE_REASON_NUMBER"),
                        record.get("BREAKAGE_RESPONSIBLE_PROCESS_NUMBER"),
                        record.get("PROCESS_FLAG_1"),
                        record.get("PROCESS_FLAG_2"),
                        record.get("PROCESS_FLAG_3"),
                        record.get("PROCESS_FLAG_4"),
                        record.get("PROCESS_FLAG_5"),
                        record.get("PROCESS_FLAG_6"),
                        record.get("PROCESS_FLAG_7"),
                        record.get("PROCESS_FLAG_8"),
                        record.get("PROCESS_FLAG_9"),
                        record.get("PROCESS_FLAG_10"),
                        record.get("PROCESS_FLAG_11"),
                        record.get("PROCESS_FLAG_12"),
                        record.get("PROCESS_FLAG_13"),
                        record.get("PROCESS_FLAG_14"),
                        record.get("PROCESS_FLAG_15"),
                        record.get("PROCESS_FLAG_16"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_1"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_2"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_3"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_4"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_5"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_6"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_7"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_8"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_9"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_10"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_11"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_12"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_13"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_14"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_15"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_16"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_17"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_18"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_19"),
                        record.get("ADDITIONAL_TREATMENT_TYPE_20"),
                        record.get("MATERIAL_TYPE"),
                        record.get("MATERIAL_F_LENS_CODE"),
                        record.get("MATERIAL_F_COLOR_COAT_CODE"),
                        record.get("MATERIAL_F_LENS_NAME"),
                        record.get("MATERIAL_F_LENS_COLOR"),
                        record.get("MATERIAL_F_LENS_COAT"),
                        record.get("MATERIAL_F_LENS_CYLINDER_TYPE"),
                        record.get("MATERIAL_F_LENS_SPHERE"),
                        record.get("MATERIAL_F_LENS_CYLINDER"),
                        record.get("MATERIAL_F_LENS_AXIS"),
                        record.get("MATERIAL_F_LENS_ADDITION"),
                        record.get("MATERIAL_F_LENS_DIAMETER"),
                        record.get("MATERIAL_F_OPC"),
                        record.get("MATERIAL_S_LENS_CODE"),
                        record.get("MATERIAL_S_LENS_NAME"),
                        record.get("MATERIAL_S_LENS_COLOR"),
                        record.get("MATERIAL_S_LENS_MAKER"),
                        record.get("MATERIAL_S_LENS_NOMINAL_BC"),
                        record.get("MATERIAL_S_LENS_DIAMETER"),
                        record.get("MATERIAL_S_LENS_THICKNESS_TYPE"),
                        record.get("MATERIAL_S_LENS_ADDITION"),
                        record.get("MATERIAL_S_OPC"),
                        record.get("MATERIAL_R_LENS_CODE"),
                        record.get("MATERIAL_R_COLOR_COAT_CODE"),
                        record.get("MATERIAL_R_LENS_NAME"),
                        record.get("MATERIAL_R_LENS_COLOR"),
                        record.get("MATERIAL_R_LENS_COAT"),
                        record.get("MATERIAL_R_LENS_CYLINDER_TYPE"),
                        record.get("MATERIAL_R_LENS_SPHERE"),
                        record.get("MATERIAL_R_LENS_CYLINDER"),
                        record.get("MATERIAL_R_LENS_AXIS"),
                        record.get("MATERIAL_R_LENS_ADDITION"),
                        record.get("MATERIAL_R_LENS_DIAMETER"),
                        LocalDateTime.parse(record.get("AMDDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS")));

                logLines.add(logLine);
            }
            return logLines;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<ProsesLogTable> CsvKeLogTables(InputStream data) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(data, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        ) {
            List<CSVRecord> records = csvParser.getRecords();
            List<ProsesLogTable> logTables = new ArrayList<ProsesLogTable>();
            for (CSVRecord record : records) {
                ProsesLogTable logTable = new ProsesLogTable(
                        record.get("Completed"),
                        record.get("CMPNYCD"),
                        record.get("RCVNO"),
                        record.get("RX_ARRANGEMENT_NUMBER"),
                        Integer.parseInt(record.get("PROCESS_LOG_COUNT")),
                        record.get("PASS_DATE"),
                        record.get("PASS_TIME"),
                        record.get("PRODUCTION_COMPANY_CODE"),
                        record.get("PRODUCTION_PLACE_CODE"),
                        Integer.parseInt(record.get("BREAKAGE_COUNT")),
                        record.get("BREAKAGE_ID"),
                        Integer.parseInt(record.get("TOTDETLINE")),
                        LocalDateTime.parse(record.get("AMDDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS")));

                logTables.add(logTable);
            }
            return logTables;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
