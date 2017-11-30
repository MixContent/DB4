package com.singh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.singh.model.Student;

public class StduentDAOImpl implements StudentDAO {

	JdbcTemplate jf;

	public void setJf(JdbcTemplate jf) {
		this.jf = jf;
	}

	@Override
	public int save(Student s) {
		// TODO Auto-generated method stub
		String name = s.getStudentname();
		String email = s.getStudentemail();
		String sql = "insert into test2(studentname,studentemail) values ('" + name + "','" + email + "')";
		return jf.update(sql);
	}

	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		String sql = "select* from test2";
		List<Student> list = jf.query(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();

				student.setStudentname(rs.getString(1));
				student.setStudentemail(rs.getString(2));
				student.setStudentid(rs.getInt(3));
				return student;
			}
		});

		return list;
	}

	@Override
	public void delete(int studentid) {
		// TODO Auto-generated method stub
		String sql = "delete from test2 where studentid=?";
		jf.update(sql, studentid);

	}

	@Override
	public Student getbyid(int studentid) {
		// TODO Auto-generated method stub
		String sql = "select * from test2  where studentid=" + studentid;

		return jf.query(sql, new ResultSetExtractor<Student>() {

			@Override
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				if (rs.next()) {
					Student student = new Student();
					student.setStudentid(rs.getInt(3));
					student.setStudentemail(rs.getString(2));
					student.setStudentname(rs.getString(1));
					return student;
				}
				return null;
			}
		});
	}

	@Override
	public List<Student> getbyname(String studentname) {
		// TODO Auto-generated method stub
		String sql = "select * from student where studentname  LIKE '" + studentname + "%'";
		List<Student> list = jf.query(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setStudentid(rs.getInt(1));
				student.setStudentemail(rs.getString(3));
				student.setStudentname(rs.getString(2));
				return student;
			}
		});

		return list;
	}

}
