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

import com.ceres.dto.MUser;
import com.ceres.service.UserService;

/**
 * @author Y.Imaizumi
 * ユーザー情報登録RESTAPI
 */
@CrossOrigin(origins = "*")
 @RestController
 @RequestMapping("/")
 public class RegUserInfoResource {

	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(LoginResource.class);

	@PostMapping("/regUserInfo")
	public Map<String, Object> regUserInfo(@RequestBody Map<String, Object> data) {
		logger.info("■■■　regUserInfo　開始　■■■");
		logger.info("リクエスト:"+ data);
		
		
		String name = (String) data.get("name");
		String dob = (String) data.get("dob");
		String telNo = (String) data.get("telNo");
		String pass = (String) data.get("pass");
		MUser mUser = new MUser();
		mUser.setUserName(name);
		mUser.setUserDob(dob);
		mUser.setUserTelNo(telNo);
		mUser.setUserPass(pass);

		logger.info("■■■　userService.RegUserInfo　開始　■■■");
		//ユーザー情報の登録を行う。
		int userId = userService.RegUserInfo(mUser);
		logger.info("■■■　userService.RegUserInfo　終了　■■■");
		logger.info("レスポンス:"+ userId);
		logger.info("■■■　regUserInfo　終了　■■■");
		return Map.of("success", true,"userId", userId);
	}
}
