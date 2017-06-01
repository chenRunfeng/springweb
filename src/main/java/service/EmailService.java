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
	//�����ʼ�
	private  void sendMail(String str) throws Exception {  
	Properties props = new Properties(); //���Լ���һ�������ļ�  
	// ʹ��smtp�����ʼ�����Э��  
	props.put("mail.smtp.host", "smtp.qq.com");//�洢�����ʼ�����������Ϣ  
	props.put("mail.smtp.auth", "true");//ͬʱͨ����֤  
	props.put("mail.smtp.port", "465");
	props.put("mail.transport.protocol", "smtp");
	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.socketFactory.port", "465");
//	props.put("mail.smtp.ssl.enable", "true");
	//props.put("mail.smtp.ssl.socketFactory", msf);
	Authenticator authenticator = new Email_Authenticator("1657479059@qq.com", "nusadejsvrbbdbdf");
	Session session = Session.getInstance(props,authenticator);//���������½�һ���ʼ��Ự  
	//session.setDebug(true); //�������ӡһЩ������Ϣ��  
	
	MimeMessage message = new MimeMessage(session);//���ʼ��Ự�½�һ����Ϣ����  
	message.setFrom(new InternetAddress("1657479059@qq.com"));//���÷����˵ĵ�ַ 
	message.setRecipient(Message.RecipientType.TO, new InternetAddress(str));//�����ռ���,���������������ΪTO  
	message.setSubject("�����ʼ�");//���ñ���  
	//�����ż�����  
	//message.setText(mailContent); //���� ���ı� �ʼ� todo  
	message.setContent("����", "text/html;charset=gbk"); //����HTML�ʼ���������ʽ�ȽϷḻ  
	message.setSentDate(new Date());//���÷���ʱ��  
	message.saveChanges();//�洢�ʼ���Ϣ  
	
	//�����ʼ�  
//	//Transport transport = session.getTransport("smtp");  
//	Transport transport = session.getTransport();  
//	transport.connect(email.getUser(), email.getPassword());  
//	transport.sendMessage(message, message.getAllRecipients());//�����ʼ�,���еڶ�����������������õ��ռ��˵�ַ  
//	transport.close();  
	Transport.send(message);
  }  
	//���ʼ�����
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
