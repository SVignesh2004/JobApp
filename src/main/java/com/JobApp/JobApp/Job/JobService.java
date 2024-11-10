package com.JobApp.JobApp.Job;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> findall();
    void createjob(Job job);

    Job findbyit(Long id);

    boolean deletebyid(Long id);

    boolean updatebyid(Long id, Job updatedjob);

    @Service
    class Jobservice implements JobService {

        public Jobservice(Job_Repo jobRepo) {
            this.jobRepo = jobRepo;
        }

        //   private List<Job> jobs =new ArrayList<>();
        Job_Repo jobRepo;


        @Override
        public List<Job> findall() {
            return jobRepo.findAll();
        }

        @Override
        public void createjob(Job job) {

            jobRepo.save(job);
        }

        @Override
        public Job findbyit(Long id) {
          return jobRepo.findById(id).orElse(null);

        }

        @Override
        public boolean deletebyid(Long id) {
            try {
                jobRepo.deleteById(id);
                return true;
            }
            catch (Exception e){
                return  false;
            }

        }

        @Override
        public boolean updatebyid(Long id, Job updatedjob) {
            Optional<Job> jobOptional = jobRepo.findById(id);
                if (jobOptional.isPresent()){
                    Job jobs=jobOptional.get();
                    jobs.setTitle(updatedjob.getTitle());
                    jobs.setDesc(updatedjob.getDesc());
                    jobs.setLocation(updatedjob.getLocation());
                    jobs.setSalary(updatedjob.getSalary());
                    jobRepo.save(jobs);
                    return  true;
                }
            return false;
            }

        }
}
