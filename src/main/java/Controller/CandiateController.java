package Controller;

import Service.CandiateService;
import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candiate")
public class CandiateController {
    public static final int passLength=10;
@Autowired
CandiateService candiateService;
    @CrossOrigin
    @RequestMapping(value="/addCandidate", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addCandidate(@RequestBody RequestBodyCandidate candidate)
    {
        System.out.println(candidate.getEmail());
        if(candiateService.isEmailPresent(candidate)>0) {
//			String message = isValid > 0 ? "Candidate is Valid!":"Candidate is not valid!";
            return new ResponseEntity<>(new ResponseBodyValidateCandidate(0,"candidate email is already present!"), HttpStatus.OK);
        }
        else {
            String password=candiateService.passwordCreation(passLength);
            candiateService.autoGeneratePassword(candidate,password);
            return new ResponseEntity<>(new ResponseBodyValidateCandidate(1,"candidate added successfully!"), HttpStatus.OK);
        }
    }
    @CrossOrigin
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<ResponseBodyCandidate> getAllCandidates(){
        return candiateService.findAllCandidates();
    }

    @CrossOrigin
    @RequestMapping(value="/validateCandidate", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> validationOfCandidate(@RequestBody RequestBodyValidateCandidate candidate)
    {
        Integer isValid= candiateService.validateCandidate(candidate);
        String message = isValid > 0 ? "Candidate is Valid!":"Candidate is not valid!";
        return new ResponseEntity<>(new ResponseBodyValidateCandidate(isValid,message), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value="/assignTest", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<AssignedTestCandidateResponse> assignTest(@RequestBody AssignedTestCandidateRequestBody req)
    {
        System.out.println(req);
        candiateService.saveSelectedCandidates(req);
        return candiateService.findAllSelectedCandidate();
    }








}
