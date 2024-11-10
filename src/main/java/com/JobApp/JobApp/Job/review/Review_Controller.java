package com.JobApp.JobApp.Job.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class Review_Controller {


    private ReviewService reviewService;

    public Review_Controller(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getreviewById(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addreview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean isreviewissafed = reviewService.addReview(companyId, review);
        if (isreviewissafed) {
            return new ResponseEntity<>("Created review", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("REview not safed", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getreview(@PathVariable Long companyId
            , @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getreview(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        boolean isReviewupdated = reviewService.updateReview(companyId, reviewId, review);
        if (isReviewupdated) {
            return new ResponseEntity<>("Review updates successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not updates", HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/reviews/{reviewId}")
    public  ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isreviewdeleted = reviewService.deleteReview(companyId,reviewId);
        if (isreviewdeleted) {
            return new ResponseEntity<>("Review Deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not deleted", HttpStatus.NOT_FOUND);
        }
    }
}
