package com.smalldogg.rememberplease.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerDocsRedirect {

  @GetMapping("/docs")
  public String swaggerRedirect() {
    return "redirect:/swagger-ui.html";
  }

}
