package util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class MySendMail {
	 /** 发信人 */  
    public static String Sendfrom="1918666439@qq.com";  
    /** 收信人 */  
    //private String to;  
    /** 主题 */  
    public static String subject="交大-验证码";  
    /** 正文 */  
    private String body;
    //用户邮箱账户-发送邮箱的账户
    public static final String userCount = "1918666439@qq.com";
    //登陆密码
    public static final String password = "wnuxjyaycvqddijg";  
    
    /**
     * 
     * @param reciver 收件人
     * @param checkId 要发送的验证码
     * @return
     */
    public static boolean sendMail(String reciver,String checkId) {  
            
            try {  
                Properties props = new Properties();  
                props.put("username", userCount);   
                props.put("password", password);   
                //指定端口及协议
                props.put("mail.transport.protocol", "smtp" );
                //指定服务器我用的是qq的
                props.put("mail.smtp.host", "smtp.qq.com");  
                //props.put("mail.smtp.port", "25" );  
                props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.setProperty("mail.smtp.port", "465");
                props.setProperty("mail.smtp.socketFactory.port", "465");
                Session mailSession = Session.getDefaultInstance(props);  
                Message msg = new MimeMessage(mailSession);   
      
                msg.setFrom(new InternetAddress(Sendfrom));  
                msg.addRecipients(Message.RecipientType.TO, InternetAddress  
                        .parse(reciver));  
                msg.setSentDate(new Date());  
                msg.setSubject(subject);   
      
                msg.setText("交大验证码:"+checkId+"\n"+"如非本人操作，请忽略此信息"+"该验证码有效时间为3分钟"+"\n"+"-------来自青橙"+"\n"+"本邮件为系统邮件请勿回复");  
                msg.saveChanges();  
                System.out.println("正在连接服务器。。。。");  
                Transport transport = mailSession.getTransport("smtp");  
                transport.connect(props.getProperty("mail.smtp.host"), props  
                        .getProperty("username"), props.getProperty("password"));   
                  
                System.out.println("正在发送邮件。。。。");  
                transport.sendMessage(msg, msg.getAllRecipients());  
                transport.close();   
                System.out.println("发送完毕。。。。");  
      
            } catch (Exception e) {  
                e.printStackTrace();  
                System.out.println(e);  
                return false;  
            }  
            return true;  
        }   
    public static void main(String[] args) {
        
        	MySendMail.sendMail("1336485920@qq.com", String.valueOf(Math.random() * 999+"我是小蚊子"));
            System.out.println("邮件发送成功!");
       
    }
}
