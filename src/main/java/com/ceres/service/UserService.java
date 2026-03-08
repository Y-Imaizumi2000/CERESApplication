package com.ceres.service;

import com.ceres.dto.MUser;

/**
 * ユーザー関連のビジネスロジッククラス
 * @author Y.Imaizumi
 * @since 2026/02/01
 */
public interface UserService {

/**
 * ログインユーザーの有効チェック
 * @param loginId ログインID
 * @param loginDate ログイン日付 
 * @return boolean ログインユーザーの登録有無
 */
	boolean validLoginUser(Integer loginUserId, String pass, String loginDate);

/**
 * ユーザーの登録
 * @param loginId ログインID
 * @param loginDate ログイン日付 
 * @return boolean ログインユーザーの登録有無
 */
	int RegUserInfo(MUser mUser);
}	
