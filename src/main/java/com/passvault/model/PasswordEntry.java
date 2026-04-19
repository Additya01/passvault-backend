package com.passvault.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "passwords")
public class PasswordEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(name = "strength_level")
    private String strengthLevel;

    @Column(name = "crack_time")
    private String crackTime;

    @Column
    private Integer length;

    @Column(name = "hack_risk")
    private String hackRisk;

    @Column
    private String variety;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    // ── Lifecycle ──────────────────────────────────────────
    @PrePersist
    public void prePersist() {
        this.submittedAt = LocalDateTime.now();
    }

    // ── Getters & Setters ──────────────────────────────────
    public Long getId()                        { return id; }
    public String getPassword()                { return password; }
    public void setPassword(String password)   { this.password = password; }
    public String getStrengthLevel()           { return strengthLevel; }
    public void setStrengthLevel(String s)     { this.strengthLevel = s; }
    public String getCrackTime()               { return crackTime; }
    public void setCrackTime(String c)         { this.crackTime = c; }
    public Integer getLength()                 { return length; }
    public void setLength(Integer l)           { this.length = l; }
    public String getHackRisk()               { return hackRisk; }
    public void setHackRisk(String h)         { this.hackRisk = h; }
    public String getVariety()                { return variety; }
    public void setVariety(String v)          { this.variety = v; }
    public LocalDateTime getSubmittedAt()     { return submittedAt; }
}
