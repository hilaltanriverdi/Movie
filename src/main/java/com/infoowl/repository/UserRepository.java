package com.infoowl.repository;

import com.infoowl.model.Film;
import com.infoowl.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hilal on 3/21/2016.
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
