package controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.support.logging.Log;

import entity.Applicant;
import service.*;

/**
 * controller
 * @author csy81
 *
 */
@Controller
public class IndexController {
 
 @RequestMapping("/") 
 public String dobase (Map<String, Object> map ){
	 BaseServiceImpl<Applicant, Serializable> baseServiceImpl=new BaseServiceImpl<Applicant, Serializable>();
	 List<Applicant> list=baseServiceImpl.querybysql("select * from applicant");
	 map.put("userlist",list);	 
	 System.out.println(list.get(0).getApply_id());
	return "index" ;
 }
 @RequestMapping("/senemail")
 public String sendemail(String apply_id){
	 EmailService emailService =new EmailService();
	 int i= emailService.SendEmails(apply_id);
	 String reString="成功发送邮件"+i+"条";
	 return reString;
 }
}
