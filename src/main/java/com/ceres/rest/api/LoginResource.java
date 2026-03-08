package com.ceres.rest.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceres.service.UserService;

/**
 * @author Y.Imaizumi
 * ログイン時のログインユーザー有効チェックRESTAPI
 */
@CrossOrigin(origins = "*")
 @RestController
 @RequestMapping("/")
 public class LoginResource {

	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(LoginResource.class);

	@PostMapping("/validLoginUser")
	public Map<String, Boolean> loginValidLoginUser(@RequestBody Map<String, Object> data) {
		logger.debug("■■■　loginValidLoginUser　開始　■■■");
		logger.debug("param:"+ data);
		
		String strId = (String)data.get("id");
		Integer id = Integer.valueOf(strId);
		String pass = (String) data.get("pass");
        //システム日付の取得
        String sysDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		//ログインユーザーの有効チェックを行う。
		boolean validFlg = userService.validLoginUser(id, pass, sysDate);
		logger.debug("■■■　loginValidLoginUser　終了　■■■");
		return Map.of("success", true,"validFlg", validFlg);
		
	}
}
