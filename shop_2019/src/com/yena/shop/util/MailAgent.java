package com.yena.shop.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailAgent extends Authenticator {
	
	private String receiver;
	private String content;
	private String subject;
	
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public void setTo(String receiver){
		this.receiver = receiver;
	}
	
	public void send() throws UnknownHostException{
		InetAddress local = InetAddress.getLocalHost();	// 내 PC 서버정보 가져오기
		String ip = local.getHostAddress();
		
		System.out.println("------------ Send Email Aboune Authorize Key -------------");
		System.out.println("\temail : " + receiver);
		System.out.println("\tip_info : " + ip);
		
		// 네이버일 경우 smtp.naver.com 을 입력합니다.
		// Google일 경우 smtp.gmail.com 을 입력합니다.
		String host = "smtp.gmail.com"; // mail.from (어느 SMTP를 통해서 보냇음 ?) return02@carry.com
		
		final String username = "ishrhrl39";       // GMAIL 아이디를 입력해주세요. @nave.com은 입력하지 마시구요.
		final String password = "klrsowytjxjicdqh";   // GMAIL 이메일 비밀번호를 입력해주세요.
		int port = 465; //포트번호
		
		// 메일 내용
		Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성
		 
		// SMTP 서버 정보 설정
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);
		props.put("mail.smtp.starttls.enable","true");   
		
		//Session 생성
		// getDefaultInstance : JavaMail session 초기화
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un=username;
			String pw=password;
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(un, pw);
			}
		});
		session.setDebug(true); // 디버깅 정보를 화면에 보여준다.
		   
		Message mimeMessage = new MimeMessage(session); //MimeMessage 생성
		try {
			// InternetAddress : 이메일 주소를 나타낼 때 사용되는 클래스로서, Message 클래스의 수취인과 발신인을 지정할 때 사용
			//발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요.
			mimeMessage.setFrom(new InternetAddress("ishrhrl39@gmail.com"));
			//수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver)); 
			mimeMessage.setContent(content, "text/html; charset=utf-8");
			mimeMessage.setSubject(subject);  //제목셋팅
			//javax.mail.Transport.send() 이용
			Transport.send(mimeMessage); 
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
		}
	}
}
