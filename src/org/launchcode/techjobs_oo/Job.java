package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        if(getName() == null && getEmployer() == null && getLocation() == null && getPositionType() == null && getCoreCompetency() == null) {
            return "OOPS! This job does not seem to exist.";
        }
        String aName = getName();
        String anEmployer = getEmployer().getValue();
        String aLocation = getLocation().getValue();
        String aPosType = getPositionType().getValue();
        String aCC = getCoreCompetency().getValue();
        String empty = "Data not available";
        if(aName.equals("")) {
            aName = empty;
        }
        if(anEmployer.equals("")) {
            anEmployer = empty;
        }
        if(aLocation.equals("")) {
            aLocation = empty;
        }
        if(aPosType.equals("")) {
            aPosType = empty;
        }
        if(aCC.equals("")) {
            aCC = empty;
        }
        return (
                "ID: " + this.getId() + "\n"
                + "Name: " + aName + "\n"
                + "Employer: " + anEmployer + "\n"
                + "Location: " + aLocation + "\n"
                + "Position Type: " + aPosType + "\n"
                + "Core Competency: " + aCC
        );
    }

    public static void resetId() {
        nextId = 1;
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
