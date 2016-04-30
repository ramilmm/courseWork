package mvc.repositories;

import mvc.common.UsersInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepositoryCustom extends JpaRepository<UsersInfo, Long> {

    UsersInfo findById(Long id);

    UsersInfo findByLogin(String login);

}
