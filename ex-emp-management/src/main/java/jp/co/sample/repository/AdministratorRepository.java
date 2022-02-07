package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

/**
 * @author smone
 *
 */
@Repository
public class AdministratorRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Administrator> Administrator_ROW_MAPPER
	=(rs,i)->{
		Administrator administrator=new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mailAddress"));
		administrator.setPassword("password");
		return administrator;
		};

		public void insert(Administrator administrator) {
			SqlParameterSource param
				=new BeanPropertySqlParameterSource(administrator);
		
			if(administrator.getId()==null) {
				String insertSql
				="INSERT INTO administrators(name,mail_address,password)"
						+ " VALUES(:name,:mail_address,password)";
				template.update(insertSql,param);
			}else {
				String upateSql
				="UPDATE administrators set name=:name,mail_adress=:mailAddres,password=:password WHERE id=:id";
				template.update(upateSql, param);
			}
		
		}
		
		/** 管理者をメールアドレス、パスワードをもとに1件取得 */
		public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
			String sql =
					"SELECT id,name,mail_address,password FROM administrators WHERE mail_address = :mailAddress AND password = :password;";
			SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress)
					.addValue("password", password);
			List<Administrator> administratorList =
					template.query(sql, param, Administrator_ROW_MAPPER);
			if (administratorList.size() == 0) {
				return null;
			} else {
				return administratorList.get(0);
			}
		}
}




