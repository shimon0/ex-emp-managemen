package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * @author smone
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	
	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee>employeeList = employeeService.showList();
		model.addAttribute("employeeList",employeeList);
		return "employee/list";
	}
	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Employee employee = employeeService.showDetail(Integer.parseInt(id));
		model.addAttribute("employee", employee);
		
		return "employee/detail";
	}
	@RequestMapping("/update")
	public String update(@Validated UpdateEmployeeForm form,BindingResult result,Model model) {
		if (result.hasErrors()) {
			return showDetail(form.getId(), model);
		}
		int employeeId = Integer.parseInt(form.getId());
		Employee employee = employeeService.showDetail(employeeId);
		employee.setMailAddress(form.getMailAddress());
		employee.setZipCode(form.getZipCode());
		employee.setAddress(form.getAddress());
		employee.setTelephone(form.getTelephone());
		employee.setSalary(form.getSalary());
		employee.setCharacteristics(form.getCharacteristics());
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
		employeeService.update(employee);
		return "redirect:/employee/showList";
	}
}
