//package com.sjprogramming.MailDemo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/mail")
//public class MailController {
//	
//	@Autowired
//	private MailService mailService;
//	
//	@PostMapping("/send/{mail}")
//	public String sendMail(@PathVariable String mail, @RequestBody MailStructure mailStructure) {
//		mailService.sendMail(mail,  mailStructure);
//		
//		return "Successfully sent the mail !!";
//	}
//}



//    {    "subject":"testing 1",
//        "message":"testing testing"
//    }


//------------------------------------------mail request-------------------------------------------

package com.sjprogramming.MailDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
    
    @Autowired
    private MailService mailService;
    
    @PostMapping("/send")
    public String sendMail(@RequestBody MailRequest mailRequest) {
        mailService.sendMail(mailRequest.getMail(), mailRequest.getMailStructure());
        return "Successfully sent the mail !!";
    }
}

//http://localhost:8080/mail/send
//{
//    "mail": "Richa.Gupta@prolifics.com",
//    "mailStructure": {
//        "subject":"testing 1",
//        "message":"testing testing"
//    }
//}
