package domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ResponseBodyCandidate {
    @Getter
    @Setter
    public int candidateId;
    public String email;

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String password;


}
