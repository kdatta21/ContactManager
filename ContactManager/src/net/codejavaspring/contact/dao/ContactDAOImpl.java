package net.codejavaspring.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejavaspring.contact.model.Contact;

public class ContactDAOImpl implements ContactDAO {

	private JdbcTemplate jdbcTemplate;
	
	//need to why this parameterized contructor is used
	public ContactDAOImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Override
	public int save(Contact c) {
		
		String sql = "INSERT INTO contact (name, email, address, telephone) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getAddress(), c.getTelephone());
	}

	@Override
	public int update(Contact c) {
		
		String sql = "UPDATE contact SET name=?, email=?, address=?, telephone=? WHERE contact_id=?";
		return jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getAddress(), c.getTelephone(), c.getId());
	}

	@Override
	public Contact get(Integer id) {
		String sql = "SELECT * FROM contact WHERE contact_id=" + id;
		
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {
			
			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String telephone = rs.getString("telephone");
					return new Contact(id, name, email, address, telephone);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM contact WHERE contact_id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Contact> list() {
		String sql = "SELECT * FROM contact";
		
		RowMapper<Contact> rowMapper = new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Integer id = rs.getInt("contact_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String telephone = rs.getString("telephone");
				return new Contact(id, name, email, address, telephone);
			}
			
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

}
