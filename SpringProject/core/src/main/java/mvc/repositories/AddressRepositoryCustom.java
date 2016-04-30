package mvc.repositories;


import mvc.common.AddressInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepositoryCustom extends JpaRepository<AddressInfo, Long>{

    AddressInfo findById(Long id);

    AddressInfo findAddressByUser_Id(Long user_id);

}
