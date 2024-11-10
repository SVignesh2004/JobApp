package com.JobApp.JobApp.Job.company.impl;

import com.JobApp.JobApp.Job.Job;
import com.JobApp.JobApp.Job.company.Company;
import com.JobApp.JobApp.Job.company.CompanyService;
import com.JobApp.JobApp.Job.company.Company_Repo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Compantserviceimp implements CompanyService {

    public Compantserviceimp(Company_Repo companyRepo) {
        this.companyRepo = companyRepo;
    }

    private  Company_Repo companyRepo;

    @Override
    public List<Company> getAllCompanys() {
        return companyRepo.findAll();
    }


    @Override
    public boolean updatecompany(Long id, Company company) {
        Optional<Company> companyOptional = companyRepo.findById(id);
        if (companyOptional.isPresent()) {
            Company Comp = companyOptional.get();
            Comp.setName(company.getName());
            Comp.setDesc(company.getDesc());
            Comp.setJob(company.getJob());
            companyRepo.save(Comp);
            return true;
        } else {
            return false;
        }
    }



    @Override
    public void createcompany(Company company) {
        companyRepo.save(company);
    }

    @Override
    public boolean deletecompany(Long id) {
        if(companyRepo.existsById(id)) {
            companyRepo.deleteById(id);
            return  true;
        }
        return false;
    }

    @Override
    public Company getcompanyidd(Long id) {
        return companyRepo.findById(id).orElse(null);
    }


}
