package com.examples.studentapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examples.studentapp.model.Student;
import com.examples.studentapp.service.StudentService;
import com.examples.studentapp.validator.StudentFormValidator;

@Controller
public class HomeController {


	private StudentService studentService;

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "redirect:/students";
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String showAllStudents(Model model) {

		model.addAttribute("students", studentService.findAll());
		return "students/list";

	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public String saveOrUpdateStudent(@ModelAttribute("studentForm") @Validated Student student, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) throws Exception {


		if (result.hasErrors()) {
			return "students/studentform";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");
			if (student.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "Student added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "Student updated successfully!");
			}

			studentService.saveOrUpdate(student);
			
			return "redirect:/students/" + student.getId();
		}

	}

	@RequestMapping(value = "/students/add", method = RequestMethod.GET)
	public String showAddStudentForm(Model model) {


		Student student = new Student();

		student.setName("examples123");
		student.setEmail("test@gmail.com");
		student.setAddress("abc 88");
		student.setFatherName("xyz");
		student.setSection(1);

		model.addAttribute("studentForm", student);

		return "students/studentform";

	}

	@RequestMapping(value = "/students/{id}/update", method = RequestMethod.GET)
	public String showUpdateStudentForm(@PathVariable("id") int id, Model model) throws Exception {


		Student student = studentService.findById(id);
		if (student == null) {
			throw new Exception("Student doesn't exist to update");
		}
		model.addAttribute("studentForm", student);

		return "students/studentform";

	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public String showStudent(@PathVariable("id") int id, Model model) throws Exception {


		Student student = studentService.findById(id);
		if (student == null) {
			throw new Exception("Student doesn't exist to show");
		}
		model.addAttribute("student", student);

		return "students/show";

	}
}