package domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Data
public class AssignedTestCandidateRequestBody {
    public ArrayList<ResponseBodyCandidate> getData() {
        return data;
    }

    public void setData(ArrayList<ResponseBodyCandidate> data) {
        this.data = data;
    }

    @Getter
@Setter
    ArrayList<ResponseBodyCandidate> data = new ArrayList<ResponseBodyCandidate>();




}
