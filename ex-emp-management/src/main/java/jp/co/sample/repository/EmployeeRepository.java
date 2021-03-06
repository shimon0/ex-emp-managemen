package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Employee> Employee_ROW_MAPPER
	=(rs,i)->{
		Employee employee=new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setImage(rs.getString("image"));
		employee.setGender(rs.getString("gender"));
		employee.setHireDate(rs.getDate("hireDate"));
		employee.setMailAddress(rs.getString("mailAddress"));
		employee.setZipCode("zipCode");
		employee.setAddress(rs.getString("address"));
		employee.setTelephone(rs.getString("telephone"));
		employee.setSalary(rs.getInt("salary"));
		employee.setCharacteristics(rs.getString("characteristics"));
		employee.setDependentsCount(rs.getInt("dependentsCount"));

		return employee;
		};
		
		public List<Employee> findAll() {
			String sql = "select * from employees order by hire_date desc";
			
			List<Employee> employeeList = template.query(sql, Employee_ROW_MAPPER);
			return employeeList;
		}
	
		
		/**
		 * 従業員をid検索
		 *
		 * @param id ID
		 * @return 従業員1件
		 */
		public Employee load(Integer id) {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append(
					"id,name,image,gender,hire_date,mail_address,zip_code,address,telephone,salary,characteristics ");
			sql.append("FROM employees ");
			sql.append("WHERE id = :id;");
			SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
			Employee employee = template.queryForObject(sql.toString(), param, Employee_ROW_MAPPER);
			return employee;
		}

		/**
		 * 従業員更新
		 *
		 * @param employee 従業員情報
		 * @return 更新された従業員の情報
		 */
		public void update(Employee employee) {

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE employees SET ");
			sql.append("name = :name,");
			sql.append("image = :image,");
			sql.append("gender = :gender,");
			sql.append("hire_date = :hireDate,");
			sql.append("mail_address = :mailAddress,");
			sql.append("zip_code = :zipCode");
			sql.append("telephone = :telephone,");
			sql.append("salary = :salary");
			sql.append("characteristics = :characteristics");
			sql.append("WHERE id = :id;");
			SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
			template.update(sql.toString(), param);

		}
}


