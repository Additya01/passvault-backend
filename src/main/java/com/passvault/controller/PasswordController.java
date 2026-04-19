package com.passvault.controller;

import com.passvault.model.PasswordEntry;
import com.passvault.repository.PasswordRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/passwords")
@CrossOrigin(origins = "*") // Allow all origins — restrict in production
public class PasswordController {

    private final PasswordRepository repo;

    public PasswordController(PasswordRepository repo) {
        this.repo = repo;
    }

    /**
     * POST /api/passwords
     * Called by frontend when user clicks Analyze.
     * Saves the password + metadata to DB.
     */
    @PostMapping
    public ResponseEntity<Map<String, String>> save(@RequestBody PasswordEntry entry) {
        repo.save(entry);
        return ResponseEntity.ok(Map.of("status", "saved"));
    }

    /**
     * GET /api/passwords
     * Admin endpoint — returns all saved entries.
     * Secure this with Spring Security in production!
     */
    @GetMapping
    public ResponseEntity<List<PasswordEntry>> getAll() {
        return ResponseEntity.ok(repo.findAll());
    }
}
