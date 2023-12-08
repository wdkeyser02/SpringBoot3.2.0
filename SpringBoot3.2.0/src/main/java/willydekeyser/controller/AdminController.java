package willydekeyser.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import willydekeyser.model.User;
import willydekeyser.service.AdminService;
import willydekeyser.service.UserService;

@Controller
public class AdminController {

	private final UserService userService;
	private final AdminService adminService;

	public AdminController(UserService userService, AdminService adminService) {
		this.userService = userService;
		this.adminService = adminService;
	}
	
	@GetMapping("/admin")
	public String getAllUsers(Model model) {
		List<User> users  = userService.getAllUsers();
		model.addAttribute("text", adminService.getText());
		model.addAttribute("users", users);
		return "admin";
	}
}
