package com.ceres.rest.api;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceres.dto.TInquiry;
import com.ceres.service.InquiryService;

/**
 * @author Y.Imaizumi
 * 問い合わせ情報登録RESTAPI
 */
@CrossOrigin(origins = "*")
 @RestController
 @RequestMapping("/")
 public class RegInquiryInfoResource {

	@Autowired
	private InquiryService inquiryService;
	
	private Logger logger = LoggerFactory.getLogger(LoginResource.class);

	@PostMapping("/regInquiryInfo")
	public Map<String, Object> regInquiryInfo(@RequestBody Map<String, Object> data) {
		logger.info("■■■　regInquiryInfo　開始　■■■");
		logger.info("リクエスト:"+ data);
		
		
		String inquiryType = (String) data.get("inquiryType");
		String message = (String) data.get("message");
		TInquiry tInquiry = new TInquiry();
		tInquiry.setInquiryType(inquiryType);
		tInquiry.setMessage(message);

		logger.info("■■■　userService.RegUserInfo　開始　■■■");
		//r問い合わせ情報の登録を行う。
		inquiryService.RegInquiryInfo(tInquiry);
		logger.info("■■■　userService.RegUserInfo　終了　■■■");
		logger.info("■■■　regInquiryInfo　終了　■■■");
		return Map.of("success", true);
	}
}
