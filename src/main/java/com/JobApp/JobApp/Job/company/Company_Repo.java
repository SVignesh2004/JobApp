package com.JobApp.JobApp.Job.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Company_Repo extends JpaRepository<Company,Long> {
}
