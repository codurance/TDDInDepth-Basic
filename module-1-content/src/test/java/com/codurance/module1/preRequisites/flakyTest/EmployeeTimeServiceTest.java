package com.codurance.module1.preRequisites.flakyTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeTimeServiceTest {

    @Test
    public void testMarkEntryAndExit() {
        EmployeeTimeService employeeTimeService = new EmployeeTimeService();
        String employeeId = "123";
        LocalDate today = LocalDate.now();

        // Mark entry
        employeeTimeService.markEntry(employeeId);
        assertNotNull(employeeTimeService.getEntryTime(employeeId, today));

        // Mark exit
        employeeTimeService.markExit(employeeId);
        assertNotNull(employeeTimeService.getExitTime(employeeId, today));
    }

    @Test
    public void testHasEnteredToday() {
        EmployeeTimeService employeeTimeService = new EmployeeTimeService();
        String employeeId = "123";

        // Mark entry
        employeeTimeService.markEntry(employeeId);

        assertTrue(employeeTimeService.hasEnteredToday(employeeId));
    }

    @Test
    public void testTimeSpent() throws InterruptedException {
        EmployeeTimeService employeeTimeService = new EmployeeTimeService();
        String employeeId = "123";
        LocalDate today = LocalDate.now();

        // Mark entry
        employeeTimeService.markEntry(employeeId);
        // Simulate some work time
        Thread.sleep(60000);
        // Mark exit
        employeeTimeService.markExit(employeeId);

        assertTrue(employeeTimeService.timeSpent(employeeId, today) > 0);
    }
}
