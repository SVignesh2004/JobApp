package com.JobApp.JobApp.Job.company;

import com.JobApp.JobApp.Job.Job;
import com.JobApp.JobApp.Job.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    public Company(Long id, String name, String desc, List<Job> job) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.job = job;
    }

    public Company() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Job> getJob() {
        return job;
    }

    public void setJob(List<Job> job) {
        this.job = job;
    }

    private String name;
    private  String desc;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> job;

   @OneToMany(mappedBy = "company")
private  List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
