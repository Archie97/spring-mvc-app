package com.examples.studentapp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.examples.studentapp.model.Student;
import com.examples.studentapp.service.StudentService;

@Component
public class StudentFormValidator implements Validator {

	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;

	@Autowired
	StudentService studentService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Student student = (Student) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.studentForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.studentForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.studentForm.address");

		if (!emailValidator.valid(student.getEmail())) {
			errors.rejectValue("email", "Pattern.studentForm.email");
		}
	}

}