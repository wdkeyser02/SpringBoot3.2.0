package willydekeyser.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import willydekeyser.model.User;
import willydekeyser.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/user")
	public String findByUserName(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();		
		User user  = userService.findByUsername(username);
		model.addAttribute("text", userService.getText());
		model.addAttribute("user", user);
		return "user";
	}
	
}
