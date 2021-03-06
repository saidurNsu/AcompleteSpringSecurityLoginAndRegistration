package com.example.student;

import com.example.student.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;


    @PostMapping(value = "/registerUser")
    public String registerUser( @ModelAttribute UserModel userModel){
        User user =userService.registerUser(userModel);
//        publisher.publishEvent(new RegistrationCompleteEvent(
//                user,
//                applicationUrl(request)
//        ));
        return "success_register";
    }

//    @PostMapping(value = "/registerUser",consumes = "JASON")
//    public String registerUser( @RequestBody UserModel userModel){
//        User user =userService.registerUser(userModel);
////        publisher.publishEvent(new RegistrationCompleteEvent(
////                user,
////                applicationUrl(request)
////        ));
//        return "success_register";
//    }

//    private String applicationUrl(HttpServletRequest request) {
//        return "http://"+
//                request.getServerName()+
//                ":"+
//                request.getServerPort()+
//                request.getContextPath();
//    }

    @GetMapping("/fail")
    public String showFormpagex(){
        return "failed";
    };

    @GetMapping("/registerView")
    public String viewRegister(@ModelAttribute UserModel userModel){
        return  "register_user_form";
    }


}
