package com.ceres.dto;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Data;


/**
 * ユーザーTBLDTO
 * @author Y.Imaizumi
 * @since 2026/01/05
 */
@Data
public class MUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", length = 25, nullable = false)
    private String userName;

    @Column(name = "user_dob", length = 8)
    private String userDob;

    @Column(name = "user_tel_no", length = 15)
    private String userTelNo;
    
    @Column(name = "user_pass", length = 255, nullable = false)
    private String userPass;

    @Column(name = "upd_cntr", nullable = false)
    private Integer updCntr;

    @Column(name = "upd_timestamp", insertable = false, updatable = false)
    private Timestamp updTimestamp;

    @Column(name = "reg_timestamp", insertable = false, updatable = false)
    private Timestamp regTimestamp;
    
}
