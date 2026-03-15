package com.ceres.dto;

import java.sql.Timestamp;

import lombok.Data;


/**
 * 問い合わせ情報TBLDTO
 * @author Y.Imaizumi
 * @since 2026/03/15
 */
@Data
public class TInquiry {

    private Integer inquiryId;
    private Integer userId;
    private String inquiryType;
    private String message;
    private Integer updCntr;
    private Timestamp updTimestamp;
    private Timestamp regTimestamp;
    
}
