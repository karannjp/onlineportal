package domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ResponseBodyValidateCandidate {
Integer isvalidate;
String responsemsg;
public ResponseBodyValidateCandidate(){
    super();
}
    public ResponseBodyValidateCandidate(Integer isvalidate,String responsemsg){
        super();
this.isvalidate=isvalidate;
this.responsemsg=responsemsg;
    }

}
