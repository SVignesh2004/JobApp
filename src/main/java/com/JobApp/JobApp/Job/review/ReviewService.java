package com.JobApp.JobApp.Job.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    Boolean addReview (Long companyId,Review review);
    Review getreview (Long companyId, Long reviewId);
    Boolean updateReview(Long companyId,Long reviewId,Review review);

    boolean deleteReview(Long companyId, Long reviewId);
}
