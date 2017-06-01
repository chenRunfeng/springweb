package service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import entity.Email;
import entity.Email_Authenticator;
import entity.Expertdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private Email getdefEmail(){
		 BaseServiceImpl<Email, Serializable> baseServiceImpl=new BaseServiceImpl<Email, Serializable>();
		String sqlStr="select * from mail_template where is_default='1'";
		List<Email> list= baseServiceImpl.querybysql(sqlStr);
		return list.get(0);
	}
	//发送邮件
	private  void sendMail(String str) throws Exception {  
	Properties props = new Properties(); //可以加载一个配置文件  
	// 使用smtp：简单邮件传输协议  
	props.put("mail.smtp.host", "smtp.qq.com");//存储发送邮件服务器的信息  
	props.put("mail.smtp.auth", "true");//同时通过验证  
	props.put("mail.smtp.port", "465");
	props.put("mail.transport.protocol", "smtp");
	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.socketFactory.port", "465");
//	props.put("mail.smtp.ssl.enable", "true");
	//props.put("mail.smtp.ssl.socketFactory", msf);
	Authenticator authenticator = new Email_Authenticator("1657479059@qq.com", "nusadejsvrbbdbdf");
	Session session = Session.getInstance(props,authenticator);//根据属性新建一个邮件会话  
	//session.setDebug(true); //有他会打印一些调试信息。  
	
	MimeMessage message = new MimeMessage(session);//由邮件会话新建一个消息对象  
	message.setFrom(new InternetAddress("1657479059@qq.com"));//设置发件人的地址 
	message.setRecipient(Message.RecipientType.TO, new InternetAddress(str));//设置收件人,并设置其接收类型为TO  
	message.setSubject("测试邮件");//设置标题  
	//设置信件内容  
	//message.setText(mailContent); //发送 纯文本 邮件 todo  
	message.setContent("测试", "text/html;charset=gbk"); //发送HTML邮件，内容样式比较丰富  
	message.setSentDate(new Date());//设置发信时间  
	message.saveChanges();//存储邮件信息  
	
	//发送邮件  
//	//Transport transport = session.getTransport("smtp");  
//	Transport transport = session.getTransport();  
//	transport.connect(email.getUser(), email.getPassword());  
//	transport.sendMessage(message, message.getAllRecipients());//发送邮件,其中第二个参数是所有已设好的收件人地址  
//	transport.close();  
	Transport.send(message);
  }  
	//多邮件发送
	public int SendEmails(String arg){
		int i=0;
		BaseServiceImpl<Expertdetail, Serializable> eBaseServiceImpl=new BaseServiceImpl<Expertdetail, Serializable>();
		String sqlString="select * from expertdetail where apply_id='"+arg+"'";
		List<Expertdetail> list =eBaseServiceImpl.querybysql(sqlString);
		for (Expertdetail expertdetail : list) {
			try {
				sendMail(expertdetail.getEemail());
				i++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				continue;				
			}
		}
		return i;
	}
}
