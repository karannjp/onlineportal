package Service;

import Interface.QuesationDao;
import domain.Question;
import domain.SaveSelectedQuestionsRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuesationService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    QuesationDao qDao;

    public Question findById(int id) {
        return qDao.getQuestionById(id);
    }

    public void deleteById(int id) {
        qDao.deleteQuestionById(id);
    }

    public void add(Question question) {
        qDao.addQuestion(question);
    }

    public void update(Question question)
    {
        qDao.updateQuestion(question);
    }

    public void saveSelected(SaveSelectedQuestionsRequestModel req)
    {
        qDao.resetIsSelected();
        if(req.getData() != null && req.getData().size() != 0) {
            for(Integer id: req.getData())
            {
                System.out.println(id);
                qDao.resetQuestion(id);
            }
        }
    }

    public List<Question> findAll() {
        return qDao.getQuestionList();
    }


}
