package com.projeto.bibliotecaagil.api.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

@Controller
public class HandleErrorController implements ErrorController {

//    @RequestMapping("/error")
//    public RedirectView handleError() {
//        return new RedirectView("/");
//    }
	
	@Override
	public String getErrorPath() {
		return "/";
	}

}
