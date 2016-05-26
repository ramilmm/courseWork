package mvc.repositories;

import mvc.common.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FeedbackRepositoryCustom extends JpaRepository<Feedback, Long> {

    Feedback findById(Long id);

}
