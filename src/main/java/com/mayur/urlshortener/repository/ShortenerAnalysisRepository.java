package com.mayur.urlshortener.repository;

import com.mayur.urlshortener.entity.ShortenerAnalysisPOJO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface ShortenerAnalysisRepository extends JpaRepository<ShortenerAnalysisPOJO, Long> {
    
}