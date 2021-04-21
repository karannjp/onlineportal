package Service;

import Interface.CandiateDao;
import domain.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

@Service
public class CandiateService {
@Autowired
    JdbcTemplate jdbcTemplate;
@Autowired
CandiateDao cDao;

    public  static  final  String emailserver="https://cdktestmail.herokuapp.com/sendEmail";
    public final static String testUrl="http://100.78.23.86:3000/";

    public String passwordCreation(int passLength) {
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*";
        String values = Capital_chars + Small_chars + numbers + symbols;
        Random random=new Random();
        char[] password=new char[passLength];
        for (int i = 0; i < passLength; i++)
        {
            password[i] =
                    values.charAt(random.nextInt(values.length()));
        }
        String pass=String.copyValueOf(password);
        return pass;
    }

    public void autoGeneratePassword(RequestBodyCandidate c, String pass) {
        cDao.saveCandidateInfo(c, pass);
    }

    public Integer isEmailPresent(RequestBodyCandidate candidate) {
        return cDao.isEmailAlreadyPresent(candidate);
    }

    public List<ResponseBodyCandidate> findAllCandidates() {
        List<ResponseBodyCandidate> candidateList=new ArrayList();
        candidateList.addAll(cDao.getAllCandidates());
        return candidateList;
    }

    public Integer validateCandidate(RequestBodyValidateCandidate candidate) {
        return cDao.checkCandidateCredentials(candidate);
    }

    public void saveSelectedCandidates(AssignedTestCandidateRequestBody req) {
        if(req.getData() != null && req.getData().size() != 0) {
            for(ResponseBodyCandidate candidate: req.getData())
            {
                System.out.println(candidate);
                cDao.saveSelectedCandidatesIntoDb(candidate.getCandidateId());
                this.sendEmail(candidate);
            }
        }
    }

    public List<AssignedTestCandidateResponse> findAllSelectedCandidate() {
        List<AssignedTestCandidateResponse> candidateList=new ArrayList<>();
        candidateList.addAll(cDao.getAllselectedCandidates());
        return candidateList;
    }


    private void sendEmail(ResponseBodyCandidate candidate)
    {
        EmailRequestModel receiverInfo = new EmailRequestModel(candidate.getEmail(),"candidate",testUrl,candidate.getEmail(),candidate.getPassword());
        RestTemplate restTemplate = new RestTemplate();
        Object result = restTemplate.postForObject( emailserver, receiverInfo, Object.class);
        System.out.println(result.toString());
    }






}
