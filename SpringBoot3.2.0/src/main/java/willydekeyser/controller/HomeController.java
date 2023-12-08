package willydekeyser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import willydekeyser.service.HomeService;

@Controller
public class HomeController {

	private final HomeService homeService;
	
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("text", homeService.getText());
		return "index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "redirect:/";
	}
	
}
