package com.codurance.module1.preRequisites.flakyTest.exercise;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class EmployeeTimeService {
    private Map<String, Map<LocalDate, LocalDateTime>> entryTimes = new HashMap<>();
    private Map<String, Map<LocalDate, LocalDateTime>> exitTimes = new HashMap<>();
    private Clock clock;

    public EmployeeTimeService() {
        this.clock = Clock.systemDefaultZone();
    }

    public EmployeeTimeService(Clock clock) {
        this.clock = clock;
    }

    public void markEntry(String employeeId) {
        LocalDate today = LocalDate.now(clock);
        entryTimes.putIfAbsent(employeeId, new HashMap<>());
        entryTimes.get(employeeId).put(today, LocalDateTime.now(clock));
    }

    public void markExit(String employeeId) {
        LocalDate today = LocalDate.now(clock);
        exitTimes.putIfAbsent(employeeId, new HashMap<>());
        exitTimes.get(employeeId).put(today, LocalDateTime.now(clock));
    }

    public LocalDateTime getEntryTime(String employeeId, LocalDate date) {
        return entryTimes.getOrDefault(employeeId, new HashMap<>()).get(date);
    }

    public LocalDateTime getExitTime(String employeeId, LocalDate date) {
        return exitTimes.getOrDefault(employeeId, new HashMap<>()).get(date);
    }

    public boolean hasEnteredToday(String employeeId) {
        LocalDate today = LocalDate.now(clock);
        LocalDateTime entryTime = entryTimes.getOrDefault(employeeId, new HashMap<>()).get(today);
        return entryTime != null;
    }

    public long timeSpent(String employeeId, LocalDate date) {
        LocalDateTime entryTime = entryTimes.getOrDefault(employeeId, new HashMap<>()).get(date);
        LocalDateTime exitTime = exitTimes.getOrDefault(employeeId, new HashMap<>()).get(date);
        if (entryTime != null && exitTime != null) {
            return java.time.Duration.between(entryTime, exitTime).toMinutes();
        }
        return 0;
    }
}
