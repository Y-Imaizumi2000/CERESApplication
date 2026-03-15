package com.ceres.service;

import com.ceres.dto.TInquiry;

/**
 * 問い合わせ関連のビジネスロジッククラス
 * @author Y.Imaizumi
 * @since 2026/03/15
 */
public interface InquiryService {

/**
 * 問い合わせ情報の登録
 * @param TInquiry 問い合わせ情報TBL
 * @return boolean ログインユーザーの登録有無
 */
	void RegInquiryInfo(TInquiry tInquiry);
}	
