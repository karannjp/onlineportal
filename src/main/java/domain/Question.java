package domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@Table(name = "Question")
@Data
//@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class Question {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private String q_id;
private  String Quesation;
private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String isanswer;
    private String is_selected;
    /*public Question(){
        System.out.println("Qusation created ");

    }*/

}
