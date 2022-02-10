package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

/**
 * @author smone
 *
 */
@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee>showList(){
		return employeeRepository.findAll();
	}
	/**
	 * @param id
	 * @return
	 */
	public Employee showDetail(Integer id) {
		return employeeRepository.load(id);
	}
 } 