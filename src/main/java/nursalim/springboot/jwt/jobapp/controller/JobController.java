package nursalim.springboot.jwt.jobapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import nursalim.springboot.jwt.jobapp.dto.JobDto;
import nursalim.springboot.jwt.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<JobDto>> findAll() throws JsonProcessingException {
        List<JobDto> allJob = jobService.findAllJob();
        return new ResponseEntity<>(allJob, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDto> findById(@PathVariable("id") String id){
        JobDto jobById = jobService.findJobById(id);
        return new ResponseEntity<>(jobById, HttpStatus.OK);
    }
}
