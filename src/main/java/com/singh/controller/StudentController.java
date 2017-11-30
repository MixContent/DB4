package com.singh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.singh.dao.StudentDAO;
import com.singh.model.Student;

@Controller
public class StudentController {
	@Autowired
	StudentDAO dao;

	@RequestMapping("welcome")
	public String showhomepage(Model model) {
		Student student = new Student();
		model.addAttribute(student);
		return "welcome";

	}

	@RequestMapping(value = "savedata", method = RequestMethod.POST)
	public ModelAndView saveData(@ModelAttribute("student") Student student1) {

		dao.save(student1);
		ModelAndView model = new ModelAndView("success");

		return model;

	}

	@RequestMapping(value = "showdata")
	public ModelAndView showstudent() {
		List<Student> list = dao.list();

		return new ModelAndView("success", "list", list);

	}

	@RequestMapping(value = "deleteid")
	public ModelAndView deleteid(HttpServletRequest request) {
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		dao.delete(studentid);
		List<Student> list = dao.list();
		return new ModelAndView("success", "list", list);

	}

	@RequestMapping(value = "delete")
	public String Delete() {

		return "delete";

	}

	@RequestMapping(value = "searchbyidresult")
	public ModelAndView serachbyid(@RequestParam("studentid") int studentid) {
		System.out.println("hello");
		Student student = dao.getbyid(studentid);
		System.out.println("hello");

		return new ModelAndView("serachresultstudent", "student", student);

	}

	@RequestMapping(value = "searchbyid")
	public String searchbyidshow() {

		return "searchresult";

	}

	@RequestMapping(value = "searchbyname")
	public String searchbyname() {

		return "serachbynames";

	}

	@RequestMapping(value = "searchedresult")
	public ModelAndView searched(@RequestParam("studentname") String studentname) {
		List<Student> list = dao.getbyname(studentname);
		return new ModelAndView("success", "list", list);

	}

}
