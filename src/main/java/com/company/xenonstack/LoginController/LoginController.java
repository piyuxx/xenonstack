package com.company.xenonstack.LoginController;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.company.xenonstack.Logindomain.User;
import com.company.xenonstack.Loginservice.LoginService;

@Controller
public class LoginController {
@Autowired
    private LoginService userService;
 
                                  
    @GetMapping("/login")   
    public ModelAndView login() {
     ModelAndView mav = new ModelAndView("login");
        return mav;
    }
    
    @GetMapping("/welcome")   
    public ModelAndView welcome() {
     ModelAndView mav = new ModelAndView("welcome");
        return mav;
    }
    
    @GetMapping("/index")   
    public ModelAndView index() {
     ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    
    @GetMapping("/contact")   
    public ModelAndView contact() {
     ModelAndView mav = new ModelAndView("contact");
        return mav;
    }
    
    @GetMapping("/signup")   
    public ModelAndView signup() {
     ModelAndView mav = new ModelAndView("signup");
        return mav;
    }
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/login";
    }
    
    @RequestMapping(value = {"/index"}, method = RequestMethod.POST)
    public String index(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/index";
    }
    
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.POST)
    public String welcome(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/welcome";
    }
    
    @RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
    public String signup(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/signup";
    }
    
    @RequestMapping(value = {"/contact"}, method = RequestMethod.POST)
    public String contactUs(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/contact";
    }
 
    @PostMapping("/login-details")
    public String loginUser(@ModelAttribute User user ) {
    
     User oauthUser = userService.login(user);
     
     if(Objects.nonNull(oauthUser))
     {
    	 return "redirect:/welcome";
    
     } else {
    	 return "redirect:/login";
     }
 
}
    
    @PostMapping("/signup-details")
    public String signupUser(@ModelAttribute User user) {
     userService.save(user);
     return "redirect:/login";
    }
 
}
