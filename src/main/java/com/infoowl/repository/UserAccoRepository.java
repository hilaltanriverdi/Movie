package com.infoowl.repository;

import com.infoowl.model.UserAcco;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hilal on 3/21/2016.
 */
public interface UserAccoRepository extends JpaRepository<UserAcco,Long> {
    public UserAcco findByUsername(String username);
}
