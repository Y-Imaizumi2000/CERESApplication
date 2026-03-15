package com.ceres.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ceres.dto.TInquiry;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TInquiryDao {

    private final JdbcTemplate jdbc;

    // INSERT
    public void insertInquiry(TInquiry tInquiry) {
    	String sql = """
    		    INSERT INTO t_inquiry (inquiry_type, inquiry_message, user_id)
    		    VALUES (?, ?, ?)
    		""";
    	jdbc.update(sql, tInquiry.getInquiryType(), tInquiry.getMessage(), tInquiry.getUserId());
    }
//
//    // SELECT 全件
//    public List<Map<String, Object>> findAll() {
//        String sql = "SELECT * FROM m_user ORDER BY user_id";
//        return jdbc.queryForList(sql);
//    }
//
//    // SELECT 1件
//    public MUser findById(Integer id) {
//        String sql = "SELECT * FROM m_user WHERE user_id = ?";
//        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(MUser.class), id);
//    }
//
//    // UPDATE
//    public int updateUser(Integer id, String name, String dob, String tel, String pass) {
//        String sql = """
//            UPDATE m_user
//            SET user_name = ?, user_dob = ?, user_tel_no = ?, user_pass = ?, upd_cntr = upd_cntr + 1
//            WHERE user_id = ?
//        """;
//        return jdbc.update(sql, name, dob, tel, pass, id);
//    }
//
//    // DELETE
//    public int deleteUser(Integer id) {
//        String sql = "DELETE FROM m_user WHERE user_id = ?";
//        return jdbc.update(sql, id);
//    }
}
