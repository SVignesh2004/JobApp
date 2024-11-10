package com.JobApp.JobApp.Job.company;

import java.util.List;

public interface CompanyService {

      List<Company> getAllCompanys();
      boolean  updatecompany(Long id,Company company);
      void createcompany(Company company);
      boolean deletecompany(Long id);
Company getcompanyidd(Long id);
}
