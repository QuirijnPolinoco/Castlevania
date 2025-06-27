package nl.han.pexe.controller;

import nl.han.pexe.service.GiteaSyncService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sync-gitea")
public class GiteaSyncController {

    private final GiteaSyncService syncService;

    public GiteaSyncController(GiteaSyncService syncService) {
        this.syncService = syncService;
    }

    @PostMapping
    public ResponseEntity<String> syncGitea() {
        syncService.syncGroupsToGitea();
        return ResponseEntity.ok("Sync started");
    }
}
