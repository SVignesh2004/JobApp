package com.JobApp.JobApp.Job.review.impl;

import com.JobApp.JobApp.Job.company.Company;
import com.JobApp.JobApp.Job.company.CompanyService;
import com.JobApp.JobApp.Job.review.Review;
import com.JobApp.JobApp.Job.review.ReviewRepo;
import com.JobApp.JobApp.Job.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Review_Service_impl implements ReviewService {

    private ReviewRepo reviewRepo;
    private CompanyService companyService;

    public Review_Service_impl(ReviewRepo reviewRepo, CompanyService companyService) {
        this.reviewRepo = reviewRepo;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Boolean addReview(Long companyId, Review review) {
        Company company = companyService.getcompanyidd(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepo.save(review);
            return true;
        }

        return false;
    }

    @Override
    public Review getreview(Long companyId, Long reviewId) {
        List<Review> reviews=reviewRepo.findByCompanyId(companyId);
        return  reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public Boolean updateReview(Long companyId, Long reviewId, Review updatedreview) {
        if (companyService.getcompanyidd(companyId) != null){
            updatedreview.setCompany(companyService.getcompanyidd(companyId));
            updatedreview.setId(reviewId);
            reviewRepo.save(updatedreview);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if (companyService.getcompanyidd(companyId)!=null && reviewRepo.existsById(reviewId)){
            Review review=reviewRepo.findById(reviewId).orElse(null);
            Company company=review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updatecompany(companyId,company);
            reviewRepo.deleteById(reviewId);
            return true;
        }
        else {
            return false;
        }
    }
}

