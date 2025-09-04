package lx.edu.springmvc.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.cj.Session;

import lx.edu.springmvc.vo.AddrBookVO;
import lx.edu.springmvc.vo.RequestLogVO;


@Component
public class RequestLogDAO {
	@Autowired
	SqlSession session;

	public int insertDB(RequestLogVO vo) throws Exception {
		return session.insert("mapper-requestLog.insertDB", vo);
	}

}
