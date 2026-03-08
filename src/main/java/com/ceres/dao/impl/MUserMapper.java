package com.ceres.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ceres.dao.MUserDao;
import com.ceres.dto.MUser;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MUserMapper {

    private final MUserDao mUserDao;

    public int createUser(MUser mUser) {
        return mUserDao.insertUser(mUser);
    }

    public List<Map<String, Object>> getUsers() {
        return mUserDao.findAll();
    }

    public MUser getUser(Integer id) {
        return mUserDao.findById(id);
    }

    public int updateUser(Integer id, String name, String dob, String tel, String pass) {
        return mUserDao.updateUser(id, name, dob, tel, pass);
    }

    public int deleteUser(Integer id) {
        return mUserDao.deleteUser(id);
    }}
