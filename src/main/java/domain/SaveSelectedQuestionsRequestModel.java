package domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Data
public class SaveSelectedQuestionsRequestModel {
    public ArrayList<Integer> getData() {
        return data;
    }

    public void setData(ArrayList<Integer> data) {
        this.data = data;
    }

    @Getter
@Setter
    ArrayList<Integer> data=new ArrayList<>();
    public SaveSelectedQuestionsRequestModel() {}

    public SaveSelectedQuestionsRequestModel(ArrayList<Integer> data) {
        super();
        this.data = data;
    }


}
