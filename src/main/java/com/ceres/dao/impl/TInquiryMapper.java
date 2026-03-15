package com.ceres.dao.impl;

import org.springframework.stereotype.Repository;

import com.ceres.dao.TInquiryDao;
import com.ceres.dto.TInquiry;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TInquiryMapper {

    private final TInquiryDao tInquiryDao;

    public void insertInquiry(TInquiry tInquiry) {
    	tInquiryDao.insertInquiry(tInquiry);
    }
//
//    public List<Map<String, Object>> getUsers() {
//        return mUserDao.findAll();
//    }
//
//    public MUser getUser(Integer id) {
//        return mUserDao.findById(id);
//    }
//
//    public int deleteUser(Integer id) {
//        return mUserDao.deleteUser(id);
//    }
    }
