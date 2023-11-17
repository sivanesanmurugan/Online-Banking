package com.restapi.repository;

import com.restapi.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {

//    @Query("select u from user_detail u inner join u.appUser a where a.id=?1")
//    Optional<UserDetail> findUserDetail(Long id);
}
