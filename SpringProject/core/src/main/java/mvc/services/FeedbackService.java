package mvc.services;

import mvc.common.Feedback;
import mvc.repositories.FeedbackRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepositoryCustom feedbackRep;

    @Transactional
    public void add(Feedback feedback){
        feedbackRep.saveAndFlush(feedback);
    }

}
