package com.gala.urtube.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class menuServiceViewCtr {
	@RequestMapping("/addmenuadminview")
	public String addMenuPage() {
		return "addmenuadminview";
	}
}
