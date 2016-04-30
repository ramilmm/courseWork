package mvc.services;


import mvc.common.AddressInfo;
import mvc.repositories.AddressRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepositoryCustom addressRepositoryCustom;

    public AddressInfo getByUserId(Long userId){
        return addressRepositoryCustom.findAddressByUser_Id(userId);
    }

    public AddressInfo getById(Long id){
        return addressRepositoryCustom.findById(id);
    }

    @Transactional
    public void add(AddressInfo addressInfo){
        addressRepositoryCustom.saveAndFlush(addressInfo);
    }

    @Transactional
    public void delete(AddressInfo addressInfo){
        addressRepositoryCustom.delete(addressInfo);
    }

}
