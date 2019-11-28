package com.provider.user.with.auth.dao;

import com.provider.user.with.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Joinky
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
