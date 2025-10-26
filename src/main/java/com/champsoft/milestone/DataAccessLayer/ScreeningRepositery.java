package com.champsoft.milestone.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ScreeningRepositery extends JpaRepository<Screening, Integer>, PagingAndSortingRepository<Screening, Integer> {
    List<Screening> findByMovieId(int id);
}
