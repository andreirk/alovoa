package com.nonononoki.alovoa.html;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nonononoki.alovoa.entity.Contact;
import com.nonononoki.alovoa.entity.User;
import com.nonononoki.alovoa.entity.UserReport;
import com.nonononoki.alovoa.repo.ContactRepository;
import com.nonononoki.alovoa.repo.UserReportRepository;
import com.nonononoki.alovoa.service.AuthService;

@Controller
public class AdminResource {

	@Autowired
	private AuthService authService;

	//@Autowired
	//private UserRepository userRepo;

	@Autowired
	private UserReportRepository userReportRepo;
	
	@Autowired
	private ContactRepository contactRepository;

	@GetMapping("/admin")
	public ModelAndView admin() throws Exception {
		User user = authService.getCurrentUser();
		if (!user.isAdmin()) {
			throw new Exception("");
		}

		ModelAndView mav = new ModelAndView("admin");

		List<UserReport> reports = userReportRepo.findAll();
		List<Contact> contacts = contactRepository.findAllByHiddenFalse();

		mav.addObject("reports", reports);
		mav.addObject("contacts", contacts);
		
		return mav;
	}
}
