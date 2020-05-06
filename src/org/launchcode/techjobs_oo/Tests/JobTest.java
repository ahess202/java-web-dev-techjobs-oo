package org.launchcode.techjobs_oo.Tests;
import org.junit.Test;
import org.junit.Before;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job emptyJob1;
    Job emptyJob2;
    Job test_job1;
    Job test_job2;
    Job stringEmptyTest_job3;

    @Before
    public void createJobObjects() {
        emptyJob1 = new Job();
        emptyJob2 = new Job();
        test_job1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job2 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        stringEmptyTest_job3 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

    }

    @Test
    public void testSettingJobId() {
        assertFalse(emptyJob1.getId() == emptyJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product Tester", test_job2.getName());
        assertTrue(test_job2.getEmployer() instanceof Employer);
        assertTrue(test_job2.getLocation() instanceof Location);
        assertTrue(test_job2.getPositionType() instanceof PositionType);
        assertTrue(test_job2.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("ACME", test_job2.getEmployer().getValue());
        assertEquals("Desert", test_job2.getLocation().getValue());
        assertEquals("Quality control", test_job2.getPositionType().getValue());
        assertEquals("Persistence", test_job2.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job test_job1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job2 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(test_job1.equals(test_job2));
    }

    @Test
    public void testJobToStringDisplay() { //tests job with empty constructor for .toString()
        assertEquals(
                "OOPS! This job does not seem to exist.", emptyJob1.toString()); //ToStringTest 1 refactored for test 4(Bonus)
    }

    @Test
    public void testEmptyStringJobToStringDisplay() { // tests job with full constructor but empty fields for .toString()
        assertEquals(
                "ID: " + stringEmptyTest_job3.getId() + "\n"
                        + "Name: " + "Data not available" + "\n"
                        + "Employer: " + "Data not available" + "\n"
                        + "Location: " + "Data not available" +  "\n"
                        + "Position Type: " + "Data not available" + "\n"
                        + "Core Competency: " + "Data not available", stringEmptyTest_job3.toString());
    }

    @Test
    public void testJobToStringFieldsFilled() { //tests job with complete constructor and fields for .toString()
        assertEquals(
                "ID: " + test_job1.getId() + "\n"
                        + "Name: " + "Product Tester" + "\n"
                        + "Employer: " + "ACME" + "\n"
                        + "Location: " + "Desert" +  "\n"
                        + "Position Type: " + "Quality control" + "\n"
                        + "Core Competency: " + "Persistence", test_job1.toString());
    }
}