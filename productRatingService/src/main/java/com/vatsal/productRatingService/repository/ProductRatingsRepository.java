package com.vatsal.productRatingService.repository;

import com.vatsal.productRatingService.entity.ProductRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRatingsRepository extends JpaRepository<ProductRatings,Long> {
}
