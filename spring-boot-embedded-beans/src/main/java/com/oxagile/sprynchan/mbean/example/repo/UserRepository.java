package com.oxagile.sprynchan.mbean.example.repo;

import com.oxagile.sprynchan.mbean.example.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kirylsprynchan on 13.07.17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
