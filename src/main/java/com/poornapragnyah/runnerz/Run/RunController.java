package com.poornapragnyah.runnerz.Run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    public List<Run> getRuns() {
        return runRepository.getRuns();
    }

    @GetMapping("/{id}")
    public Run getRunById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isPresent()) {
            return run.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found");
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void addRun(@RequestBody Run run) {
        runRepository.addRun(run);
    }
}
