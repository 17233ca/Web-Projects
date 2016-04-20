
import java.io.Serializable;


/* 


 * Student Info: Name=AniketChoudhury, ID=17233

 * Subject:  CS532B_HW6_Spring_2016

 * Author: choud 

 * Filename: LoginBO.java 

 * Date and Time: Apr 15, 2016 2:39:24 PM 

 * Project Name: QuestionBank 


 */
/**
 *
 * @author choud
 */
public class LoginBO implements Serializable{
    
    private String userName;
    private String password;

    public LoginBO() {
    }

    public LoginBO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
