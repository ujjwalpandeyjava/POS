package pos.pos_backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
//@ResponseBody
@RequestMapping(value = { "/", "" })
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080", "http://localhost:3001" })
public class ViewController {

	@GetMapping({ "/index", "/home", "/" })
	public String getIndex() {
		return "home";
	}

	@RequestMapping(value = "/error", method = { RequestMethod.GET, RequestMethod.POST })
	public String getErrorPage(Model model) {
		model.addAttribute("message", "HELLO from via attribute");
		return "error";
	}

	@RequestMapping(value = "/viewHome", method = { RequestMethod.GET, RequestMethod.POST })
	public String getViewHome() {
		return "view/viewHome";
	}

	@RequestMapping(value = "/jsonResp1", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<String> responseBody1() {
		System.out.println("Inside responseBody1() for /jsonResp1");
		return new ResponseEntity<String>("URI jsonResp1...", HttpStatus.OK);
	}

	@RequestMapping(value = "/jsonResp2", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String responseBody2() {
		System.out.println("Inside responseBody2() for /jsonResp2");
		return "URI jsonResp2...";
	}

}
