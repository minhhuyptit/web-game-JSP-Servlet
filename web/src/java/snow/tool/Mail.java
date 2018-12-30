/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snow.tool;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import snow.model.User;

/**
 *
 * @author huyla
 */
public class Mail {

    public static String message(User user, String code) {
        String linkActive = "http://localhost:8080/Game/ActiveServlet?username=" + user.getUserUserName() + "&code=" + code;
        String str = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
                + "    <title>Document</title>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n"
                + "        <tbody>\n"
                + "            <tr>\n"
                + "                <td style=\"border-collapse:collapse;border-left:1px solid #ff6e40;border-right:1px solid #ff6e40\">\n"
                + "                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n"
                + "                        <tbody>\n"
                + "                            <tr>\n"
                + "                                <td style=\"padding:18px 20px 20px 20px;vertical-align:middle;line-height:20px;font-family:Arial;background-color:#ff6e40;text-align:center\">\n"
                + "                                    <span style=\"color:#ffffff;font-size:115%;text-transform:uppercase\">Kích hoạt đăng ký\n"
                + "                                        tài khoản\n"
                + "                                    </span> </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td style=\"padding:20px 20px 12px 20px\"> <span style=\"font-size:13px;color:#252525;font-family:Arial,Helvetica,sans-serif\">\n"
                + "                                        Chào " + user.getUserFullName() + ", </span> </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td style=\"padding:4px 20px 12px 20px\"> <span style=\"font-size:12px;color:#252525;font-family:Arial,Helvetica,sans-serif;line-height:18px\">\n"
                + "                                        Chúng tôi đã nhận được yêu cầu mở tài khoản cho Web Game Mini với thông tin chính như sau:</span>\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td style=\"padding:20px 0px 12px 0px\">\n"
                + "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
                + "                                        <tbody>\n"
                + "                                            <tr>\n"
                + "                                                <td style=\"padding:8px 10px 8px 20px;font-family:Arial,Helvetica,sans-serif;color:#666666;font-size:12px;border-bottom:1px solid #dcdcdc\"\n"
                + "                                                    align=\"right\"><span>Username:</span></td>\n"
                + "                                                <td style=\"padding:8px 20px 8px 10px;font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#2525253;border-bottom:1px solid #dcdcdc\"\n"
                + "                                                    align=\"left\"><strong>" + user.getUserUserName()+ "</strong></td>\n"
                + "                                            </tr>\n"
                + "                                            <tr>\n"
                + "                                                <td style=\"padding:8px 10px 8px 20px;font-family:Arial,Helvetica,sans-serif;color:#666666;font-size:12px;border-bottom:1px solid #dcdcdc\"\n"
                + "                                                    align=\"right\"><span>Email:\n"
                + "                                                    </span></td>\n"
                + "                                                <td style=\"padding:8px 20px 8px 10px;font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#2525253;border-bottom:1px solid #dcdcdc\"\n"
                + "                                                    align=\"left\"><a href=\"mailto:" + user.getUserEmail()+ "\"\n"
                + "                                                        target=\"_blank\">" + user.getUserEmail()+ "</a></td>\n"
                + "                                            </tr>\n"
                + "                                            <tr>\n"
                + "                                                <td style=\"padding:8px 10px 8px 20px;font-family:Arial,Helvetica,sans-serif;color:#666666;font-size:12px;border-bottom:1px solid #dcdcdc\"\n"
                + "                                                    align=\"right\"><span>Fullname:\n"
                + "                                                    </span></td>\n"
                + "                                                <td style=\"padding:8px 20px 8px 10px;font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#2525253;border-bottom:1px solid #dcdcdc\"\n"
                + "                                                    align=\"left\">" + user.getUserFullName()+ "</td>\n"
                + "                                            </tr>\n"
                + "                                            <tr>\n"
                + "                                                <td style=\"padding:8px 10px 8px 20px;font-family:Arial,Helvetica,sans-serif;color:#666666;font-size:12px;border-bottom:1px solid #dcdcdc\"\n"
                + "                                                    align=\"right\"><span>Sex:\n"
                + "                                                    </span></td>\n"
                + "                                                <td style=\"padding:8px 20px 8px 10px;font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#2525253;border-bottom:1px solid #dcdcdc\"\n"
                + "                                                    align=\"left\">" + user.getSex()+ "</td>\n"
                + "                                            </tr>\n"
                + "                                            <tr>\n"
                + "                                                <td style=\"padding:8px 10px 8px 20px;font-family:Arial,Helvetica,sans-serif;color:#666666;font-size:12px;border-bottom:1px solid #dcdcdc\"\n"
                + "                                                    align=\"right\"><span>Birthday:\n"
                + "                                                    </span></td>\n"
                + "                                                <td style=\"padding:8px 20px 8px 10px;font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#2525253;border-bottom:1px solid #dcdcdc\"\n"
                + "                                                    align=\"left\">" + user.getUserBirthday()+ "</td>\n"
                + "                                            </tr>\n"
                + "                                            <tr>\n"
                + "                                                <td style=\"padding:8px 10px 8px 20px;font-family:Arial,Helvetica,sans-serif;color:#666666;font-size:12px;border-bottom:1px solid #dcdcdc\"\n"
                + "                                                    align=\"right\"><span>Address:\n"
                + "                                                    </span></td>\n"
                + "                                                <td style=\"padding:8px 20px 8px 10px;font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#2525253;border-bottom:1px solid #dcdcdc\"\n"
                + "                                                    align=\"left\">" + user.getUserAddress()+ "</td>\n"
                + "                                            </tr>\n"
                + "                                        </tbody>\n"
                + "                                    </table>\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td style=\"padding:4px 20px 12px 20px\"> <strong style=\"font-size:12px;color:#252525;font-family:Arial,Helvetica,sans-serif;line-height:18px\">\n"
                + "                                        Để tiếp tục quy trình đăng ký, xin vui lòng click vào đường link dưới đây hoặc copy vào thanh địa chỉ trình duyệt web bất\n"
                + "                                        kỳ và nhấn Enter:</strong> </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td style=\"padding:10px 20px 12px 20px\">\n"
                + "                                    <div style=\"background:rgb(255,248,204);border:1px solid rgb(255,140,0);padding:10px;border-radius:3px 3px 0px 0px;font-size:11px;font-family:'Courier New',Courier,monospace\"\n"
                + "                                        align=\"center\"> <a title=\"Đường dẫn kích hoạt tài khoản\"\n"
                + "                                            href=\"" + linkActive + "\"\n"
                + "                                            style=\"text-decoration:none;color:#252525\" target=\"_blank\" >" + linkActive + "</a>\n"
                + "                                    </div>\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                        </tbody>\n"
                + "                    </table>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "            <tr>\n"
                + "                <td>\n"
                + "                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n"
                + "                        <tbody>\n"
                + "                            <tr>\n"
                + "                                <td style=\"padding:4px 20px 12px 20px;border-left:1px solid #ff6e40;border-right:1px solid #ff6e40\"><span\n"
                + "                                        style=\"font-size:12px;color:#252525;font-family:Arial,Helvetica,sans-serif\">Cảm ơn bạn\n"
                + "                                        đã quan tâm và sử dụng dịch vụ của chúng tôi</span> </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td valign=\"middle\" style=\"background-color:#6e6e6e;font-size:11px;vertical-align:middle;text-align:center;padding:10px 20px 10px 20px;line-height:18px;border:1px solid #6e6e6e;font-family:Arial;color:#cccccc\">\n"
                + "                                    Bản quyền © 2005-2018 Web Game mini <br>Hệ thống Game mini online toàn cầu kết hợp bảo vệ người dùng hàng đầu Việt Nam </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td style=\"font-family:Arial;padding-top:6px;font-size:11px;color:#252525;text-align:center\">\n"
                + "                                    Hotline: 01214755005 &nbsp;&nbsp;&nbsp; Email: <a style=\"text-decoration:none;color:#427fed\"\n"
                + "                                        href=\"mailto:minhhuy97.ptit@gmail.com\" target=\"_blank\">minhhuy97.ptit@gmail.com</a> </td>\n"
                + "                            </tr>\n"
                + "                        </tbody>\n"
                + "                    </table>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "        </tbody>\n"
                + "    </table>\n"
                + "</body>\n"
                + "\n"
                + "</html>";
        return str;
    }

    public static boolean sendMail(String to, String subject, String message) {
        try {
            String host = "smtp.gmail.com";
            String user = "akai24h@gmail.com";
            String pass = "Akaishuichi";
            String from = "akai24h@gmail.com";
//            String messageText = "Your Is Test Email :";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(MimeUtility.encodeText(subject, "utf-8", "B"));
            msg.setSentDate(new Date());
//            msg.setText(messageText);
            msg.setContent(message, "text/html; charset=utf-8");

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
}
