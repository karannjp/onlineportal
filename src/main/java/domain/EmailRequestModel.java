package domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EmailRequestModel {
public  String sendto;
public String test_url;
public  String nameofcandiate;
public  String username;
    public  String password;

    public EmailRequestModel(String sendto, String nameOfTheCandidate, String testUrl, String username,
                             String password) {
        super();
        this.sendto = sendto;
        this.nameofcandiate = nameOfTheCandidate;
        this.test_url = testUrl;
        this.username = username;
        this.password = password;
    }




}
