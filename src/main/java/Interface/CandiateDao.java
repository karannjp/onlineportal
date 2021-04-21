package Interface;

import domain.AssignedTestCandidateResponse;
import domain.RequestBodyCandidate;
import domain.RequestBodyValidateCandidate;
import domain.ResponseBodyCandidate;

import java.util.List;

public interface CandiateDao {
    public int test_id=100;
    public String SELECT_ALL="select * from cdk_candidate";
    public String CHECK_FOR_EMAIL_ALREADY_PRESENT="select count(*) from cdk_candidate where email_id=?";
    public String SELECT_AUTHENTICATED="select count(*) from cdk_candidate where email_id=? and password=?";
    public String INSERT_ASSIGNED="insert into assigned_tests(candidate_id,test_id) values (?,?)";
    public String SELECT_ASSIGNED="select cdk_candidate.candidate_id,cdk_candidate.email_id,assigned_tests.test_id,assigned_tests.score from cdk_candidate\r\n" +
            "  inner join assigned_tests on cdk_candidate.candidate_id = assigned_tests.candidate_id";
    public void saveCandidateInfo(RequestBodyCandidate candidate, String password);
    public List<ResponseBodyCandidate> getAllCandidates();
    public Integer checkCandidateCredentials(RequestBodyValidateCandidate candidate);
    public void saveSelectedCandidatesIntoDb(int id);
    public List<AssignedTestCandidateResponse> getAllselectedCandidates();
    public Integer isEmailAlreadyPresent(RequestBodyCandidate requested_candidate);


}
