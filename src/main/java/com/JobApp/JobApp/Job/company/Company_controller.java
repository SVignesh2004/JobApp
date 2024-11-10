package com.JobApp.JobApp.Job.company;

import org.apache.logging.log4j.spi.CopyOnWrite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class Company_controller {
    private  CompanyService companyService;

    public Company_controller(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
   public List<Company> getallCompanies(){
        return companyService.getAllCompanys();
   }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatecompany(@PathVariable Long id, @RequestBody Company company){
        try {
            System.out.println("Updating company with ID: " + id + ", company data: " + company);
            boolean isUpdated = companyService.updatecompany(id, company);
            if (isUpdated) {
                return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
   public  ResponseEntity<String> addcompany(@RequestBody Company company){
        companyService.createcompany(company);
        return  new ResponseEntity<>("created",HttpStatus.CREATED);
   }
@DeleteMapping("/{id}")
   public  ResponseEntity<String> deletecompany(@PathVariable Long id){
        boolean isdelete=companyService.deletecompany(id);
        if(isdelete){
            return  new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Company> getcompanybyid(@PathVariable Long  id) {


       Company company = companyService.getcompanyidd(id);
       if (company!=null){
           return  new ResponseEntity<>(company,HttpStatus.OK);
       }
       else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

   }
}
