package mvc.services;

import mvc.common.ReviewInfo;
import mvc.repositories.GoodRepositoryCustom;
import mvc.repositories.ReviewRepositoryCustom;
import mvc.repositories.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepositoryCustom reviewRepositoryCustom;
    @Autowired
    private GoodRepositoryCustom goodRepositoryCustom;
    @Autowired
    private UserRepositoryCustom userRepositoryCustom;


    @Transactional
    public void add(Long goodId, Long userId, String comment, String fName, String email){
        reviewRepositoryCustom.saveAndFlush(new ReviewInfo(goodRepositoryCustom.findById(goodId),userRepositoryCustom.findById(userId),comment));
    }



    @Transactional
    public ReviewInfo getById(Long id){
        return reviewRepositoryCustom.findById(id);
    }
    @Transactional
    public List<ReviewInfo> getByGoodId(Long goodId){
        return reviewRepositoryCustom.findByGood_Id(goodId);
    }
    @Transactional
    public List<ReviewInfo> getByUserId(Long userId){
        return reviewRepositoryCustom.findByUser_Id(userId);
    }

}
