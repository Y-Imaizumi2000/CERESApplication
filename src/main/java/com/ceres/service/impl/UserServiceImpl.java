package com.ceres.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ceres.dao.impl.MUserMapper;
import com.ceres.dto.MUser;
import com.ceres.rest.api.LoginResource;
import com.ceres.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * ログインユーザー関連のビジネスロジッククラス
 * @author Y.Imaizumi
 * @since 2026/02/01
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final MUserMapper mUserMapper;
	
	private Logger logger = LoggerFactory.getLogger(LoginResource.class);


/**
 * ログインユーザーのチェック
 * @param loginId ログインID
 * @param loginDate ログイン日付 
 * @return boolean ログインユーザーの登録有無
 */
	@Override
	public boolean validLoginUser(Integer loginUserId, String pass, String loginDate) {
		logger.debug("■■■　validLoginUser　開始　■■■");
		//ログインユーザー登録有無フラグの初期化
		boolean loginUserRegUmFlg = false;

		MUser response = mUserMapper.getUser(loginUserId);
		if (response != null) {
			logger.debug("ログインユーザーが存在しました。");
			loginUserRegUmFlg = true;
		} else {
			logger.debug("ログインユーザーが存在しませんでした。");
		}
		

		logger.debug("■■■　validLoginUser　終了　■■■");
		//ログインユーザー登録有無フラグを返却
		return loginUserRegUmFlg;
		
	}

@Override
public int RegUserInfo(MUser mUser) {
	int userId = mUserMapper.createUser(mUser);
	return userId;
}
}	
