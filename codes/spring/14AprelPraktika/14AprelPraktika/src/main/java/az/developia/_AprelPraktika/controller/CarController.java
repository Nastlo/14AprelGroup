package az.developia._AprelPraktika.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

	@GetMapping
	public String page() {
		return "car";
	}
	
}
  