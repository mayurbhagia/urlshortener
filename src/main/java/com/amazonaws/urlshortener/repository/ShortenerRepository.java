package com.amazonaws.urlshortener.repository;

import com.amazonaws.urlshortener.entity.ShortenerPOJO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface ShortenerRepository extends JpaRepository<ShortenerPOJO, Long> {
    public ShortenerPOJO findByUrl(String url);
}