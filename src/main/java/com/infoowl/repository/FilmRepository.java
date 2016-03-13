package com.infoowl.repository;

import com.infoowl.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hilal on 3/11/2016.
 */


/**
 * Spring Data JPA repository for the Film entity.
 */
public interface FilmRepository extends CrudRepository<Film,Long> {

    Page<Film> findAll(Pageable pageable);
}
