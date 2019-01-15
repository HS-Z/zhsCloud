package com.zhs.basic.dao.JpaRepository;


import com.zhs.basic.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {


}
