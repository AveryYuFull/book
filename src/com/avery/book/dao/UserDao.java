package com.avery.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.avery.book.exception.DBException;
import com.avery.book.model.User;
import com.avery.book.util.DBUtil;

public class UserDao {

	public User getUserByName(String userName) {
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = DBUtil.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM user WHERE user_name = ?");
            stmt.setString(1, userName);
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setCreatedTime(rs.getDate("created_time"));
                user.setUpdatedTime(rs.getDate("updated_time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException();
        } finally {
            DBUtil.close(rs, stmt, conn);
        }

		return user;
	}
}
