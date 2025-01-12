package com.poornapragnyah.runnerz.Run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> getRuns() {
        return runs;
    }

    void addRun(Run run) {
        runs.add(run);
    }

    void deleteRun(Integer id) {
        runs.removeIf(existingRun -> existingRun.id().equals(id));
    }

    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    void updateRun(Integer id,Run run) {
        Optional<Run> existingRun = findById(run.id());
        if (existingRun.isPresent()) {
            deleteRun(id);
            addRun(run);
        }
    }

    @PostConstruct
    void init() {
        runs.add(new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR));
        runs.add(new Run(2, "Evening Run", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 5, Location.OUTDOOR));
    }


}
