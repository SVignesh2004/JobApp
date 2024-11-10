package com.JobApp.JobApp.Job;

import com.JobApp.JobApp.Job.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("jobs")
public class JobController {

    @Autowired
    JobService js;

    @GetMapping
    public ResponseEntity<List<Job>> showjob(){
        return ResponseEntity.ok(js.findall());
    }

    @PostMapping
    public ResponseEntity<String> createjob(@RequestBody Job job){
        js.createjob(job);

        return new  ResponseEntity<>("Created",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> jobbyid(@PathVariable Long id){
        Job job=js.findbyit(id);

        return  ResponseEntity.ok(job);

    }

   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBYid(@PathVariable Long id){
        boolean delected=js.deletebyid(id);
        if(delected){
            return  new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<String> updatebyid(@PathVariable Long id , @RequestBody Job updatedjob){
        boolean updates=js.updatebyid(id,updatedjob);
        if (updates){
            return  new ResponseEntity<>("Updated",HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }




}
