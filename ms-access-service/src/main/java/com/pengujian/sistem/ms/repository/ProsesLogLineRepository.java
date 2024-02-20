package com.pengujian.sistem.ms.repository;

import com.pengujian.sistem.ms.model.ProsesLogLine;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProsesLogLineRepository {
    private final JdbcTemplate jdbcTemplate;


    public ProsesLogLineRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProsesLogLine> getAllProsesLogLine() {
        String sql = "SELECT * FROM Proses_log_line";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProsesLogLine.class));
    }

    public ProsesLogLine saveProsesLogLine(ProsesLogLine proseslogline) {
        String sql = "INSERT INTO Proses_log_line (CMPNYCD, RCVNO, RX_ARRANGEMENT_NUMBER, PROCESS_LOG_COUNT, LENS_RL_TYPE, \n" +
                "PREVIOUS_PROCESS_NUMBER, PREVIOUS_SUBPROCESS_NUMBER, CURRENT_PROCESS_NUMBER, CURRENT_SUBPROCESS_NUMBER, \n" +
                "DIP_LOT_NUMBER, COAT_LOT_NUMBER, BREAKAGE_REASON_NUMBER, BREAKAGE_RESPONSIBLE_PROCESS_NUMBER, \n" +
                "PROCESS_FLAG_1, PROCESS_FLAG_2, PROCESS_FLAG_3, PROCESS_FLAG_4, PROCESS_FLAG_5, PROCESS_FLAG_6, PROCESS_FLAG_7, PROCESS_FLAG_8, PROCESS_FLAG_9, PROCESS_FLAG_10, PROCESS_FLAG_11, PROCESS_FLAG_12, PROCESS_FLAG_13, PROCESS_FLAG_14, PROCESS_FLAG_15, PROCESS_FLAG_16, \n" +
                "ADDITIONAL_TREATMENT_TYPE_1, ADDITIONAL_TREATMENT_TYPE_2, ADDITIONAL_TREATMENT_TYPE_3, ADDITIONAL_TREATMENT_TYPE_4, ADDITIONAL_TREATMENT_TYPE_5, ADDITIONAL_TREATMENT_TYPE_6, ADDITIONAL_TREATMENT_TYPE_7, ADDITIONAL_TREATMENT_TYPE_8, ADDITIONAL_TREATMENT_TYPE_9, ADDITIONAL_TREATMENT_TYPE_10, ADDITIONAL_TREATMENT_TYPE_11, ADDITIONAL_TREATMENT_TYPE_12, ADDITIONAL_TREATMENT_TYPE_13, ADDITIONAL_TREATMENT_TYPE_14, ADDITIONAL_TREATMENT_TYPE_15, ADDITIONAL_TREATMENT_TYPE_16, ADDITIONAL_TREATMENT_TYPE_17, ADDITIONAL_TREATMENT_TYPE_18, ADDITIONAL_TREATMENT_TYPE_19, ADDITIONAL_TREATMENT_TYPE_20, \n" +
                "MATERIAL_TYPE, MATERIAL_F_LENS_CODE, MATERIAL_F_COLOR_COAT_CODE, MATERIAL_F_LENS_NAME, MATERIAL_F_LENS_COLOR, MATERIAL_F_LENS_COAT, MATERIAL_F_LENS_CYLINDER_TYPE, MATERIAL_F_LENS_SPHERE, MATERIAL_F_LENS_CYLINDER, MATERIAL_F_LENS_AXIS, MATERIAL_F_LENS_ADDITION, MATERIAL_F_LENS_DIAMETER, MATERIAL_F_OPC, \n" +
                "MATERIAL_S_LENS_CODE, MATERIAL_S_LENS_NAME, MATERIAL_S_LENS_COLOR, MATERIAL_S_LENS_MAKER, MATERIAL_S_LENS_NOMINAL_BC, MATERIAL_S_LENS_DIAMETER, MATERIAL_S_LENS_THICKNESS_TYPE, MATERIAL_S_LENS_ADDITION, MATERIAL_S_OPC, \n" +
                "MATERIAL_R_LENS_CODE, MATERIAL_R_COLOR_COAT_CODE, MATERIAL_R_LENS_NAME, MATERIAL_R_LENS_COLOR, MATERIAL_R_LENS_COAT, MATERIAL_R_LENS_CYLINDER_TYPE, MATERIAL_R_LENS_SPHERE, MATERIAL_R_LENS_CYLINDER, MATERIAL_R_LENS_AXIS, MATERIAL_R_LENS_ADDITION, MATERIAL_R_LENS_DIAMETER, \n" +
                "AMDDATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                proseslogline.getCmpnycd(),
                proseslogline.getRcvno(),
                proseslogline.getRxArrangementNumber(),
                proseslogline.getProcessLogCount(),
                proseslogline.getLensRlType(),
                proseslogline.getPreviousProcessNumber(),
                proseslogline.getPreviousSubprocessNumber(),
                proseslogline.getCurrentProcessNumber(),
                proseslogline.getCurrentSubprocessNumber(),
                proseslogline.getDipLotNumber(),
                proseslogline.getCoatLotNumber(),
                proseslogline.getBreakageReasonNumber(),
                proseslogline.getBreakageResponsibleProcessNumber(),
                proseslogline.getProcessFlag1(),
                proseslogline.getProcessFlag2(),
                proseslogline.getProcessFlag3(),
                proseslogline.getProcessFlag4(),
                proseslogline.getProcessFlag5(),
                proseslogline.getProcessFlag6(),
                proseslogline.getProcessFlag7(),
                proseslogline.getProcessFlag8(),
                proseslogline.getProcessFlag9(),
                proseslogline.getProcessFlag10(),
                proseslogline.getProcessFlag11(),
                proseslogline.getProcessFlag12(),
                proseslogline.getProcessFlag13(),
                proseslogline.getProcessFlag14(),
                proseslogline.getProcessFlag15(),
                proseslogline.getProcessFlag16(),
                proseslogline.getAdditionalTreatmentType1(),
                proseslogline.getAdditionalTreatmentType2(),
                proseslogline.getAdditionalTreatmentType3(),
                proseslogline.getAdditionalTreatmentType4(),
                proseslogline.getAdditionalTreatmentType5(),
                proseslogline.getAdditionalTreatmentType6(),
                proseslogline.getAdditionalTreatmentType7(),
                proseslogline.getAdditionalTreatmentType8(),
                proseslogline.getAdditionalTreatmentType9(),
                proseslogline.getAdditionalTreatmentType10(),
                proseslogline.getAdditionalTreatmentType11(),
                proseslogline.getAdditionalTreatmentType12(),
                proseslogline.getAdditionalTreatmentType13(),
                proseslogline.getAdditionalTreatmentType14(),
                proseslogline.getAdditionalTreatmentType15(),
                proseslogline.getAdditionalTreatmentType16(),
                proseslogline.getAdditionalTreatmentType17(),
                proseslogline.getAdditionalTreatmentType18(),
                proseslogline.getAdditionalTreatmentType19(),
                proseslogline.getAdditionalTreatmentType20(),
                proseslogline.getMaterialType(),
                proseslogline.getMaterialFLensCode(),
                proseslogline.getMaterialFColorCoatCode(),
                proseslogline.getMaterialFLensName(),
                proseslogline.getMaterialFLensColor(),
                proseslogline.getMaterialFLensCoat(),
                proseslogline.getMaterialFLensCylinderType(),
                proseslogline.getMaterialFLensSphere(),
                proseslogline.getMaterialFLensCylinder(),
                proseslogline.getMaterialFLensAxis(),
                proseslogline.getMaterialFLensAddition(),
                proseslogline.getMaterialFLensDiameter(),
                proseslogline.getMaterialFOPC(),
                proseslogline.getMaterialSLensCode(),
                proseslogline.getMaterialSLensName(),
                proseslogline.getMaterialSLensColor(),
                proseslogline.getMaterialSLensMaker(),
                proseslogline.getMaterialSLensNominalBC(),
                proseslogline.getMaterialSLensDiameter(),
                proseslogline.getMaterialSLensThicknessType(),
                proseslogline.getMaterialSLensAddition(),
                proseslogline.getMaterialSOPC(),
                proseslogline.getMaterialRLensCode(),
                proseslogline.getMaterialRColorCoatCode(),
                proseslogline.getMaterialRLensName(),
                proseslogline.getMaterialRLensColor(),
                proseslogline.getMaterialRLensCoat(),
                proseslogline.getMaterialRLensCylinderType(),
                proseslogline.getMaterialRLensSphere(),
                proseslogline.getMaterialRLensCylinder(),
                proseslogline.getMaterialRLensAxis(),
                proseslogline.getMaterialRLensAddition(),
                proseslogline.getMaterialRLensDiameter(),
                proseslogline.getAmddate()
        );
        return proseslogline;
    }
}
