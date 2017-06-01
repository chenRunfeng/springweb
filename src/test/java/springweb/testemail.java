package springweb;


import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import entity.Email;
import service.*;

public class testemail {
 
	public static void main(String[] args)
 {
	  final String EMAIL_CONTENT="Çë²Î¼Ó";
	  Email email= new Email();
	  EmailService emailService=new EmailService();  
	 List<String> list =new ArrayList<String>() ;
	 list.add("1396381740@qq.com");
	 list.add("3257883277@qq.com");
	 list.add("947322832@qq.com");
	  emailService.setEmail(email);
	  try {
		  System.out.println("11");
		emailService.sendMail(list);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
