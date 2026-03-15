package com.ceres.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ceres.dao.impl.TInquiryMapper;
import com.ceres.dto.TInquiry;
import com.ceres.rest.api.LoginResource;
import com.ceres.service.InquiryService;

import lombok.RequiredArgsConstructor;

/**
 * ログインユーザー関連のビジネスロジッククラス
 * @author Y.Imaizumi
 * @since 2026/03/15
 */
@Service
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService{
	
	private final TInquiryMapper tInquiryMapper;
	
	private Logger logger = LoggerFactory.getLogger(LoginResource.class);

	@Override
	public void RegInquiryInfo(TInquiry tInquiry) {
		logger.info("■■■　RegInquiryInfo　開始　■■■");

		logger.info("■■■　tInquiryMapper.insertInquiry　開始　■■■");
		tInquiryMapper.insertInquiry(tInquiry);
		logger.info("■■■　tInquiryMapper.insertInquiry　終了　■■■");
		
		logger.info("■■■　RegInquiryInfo　終了　■■■");
	}
}	
