package domain;

import lombok.Data;

@Data
public class AssignedTestCandidateResponse {
    public int canditate_id;
    public  int test_id;
    public int score;
    public String email_id;


}
