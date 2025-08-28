package dev.m3s.programming2.homework3;


public abstract class Person {
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private String birthDate = ConstantValues.NO_BIRTHDATE;
    private PersonID personIDHandler = new PersonID();

    public Person(String lname, String fname) {
        this.lastName = (lname != null) ? lname : ConstantValues.NO_NAME;
        this.firstName = (fname != null) ? fname : ConstantValues.NO_NAME;
    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.trim().isEmpty()) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName;
        } 
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String setBirthDate(String personId) {
        if (personId == null) {
            return "No change";
        }
        String result = personIDHandler.setPersonId(personId);
        if ("OK".equals(result)) {
            this.birthDate = personIDHandler.getBirthDate();
           return birthDate; 
        }
        return "No change";
    }

    protected int getRandomId(final int min, final int max)  {
        int randomId = (int) (Math.random() * (max - min + 1)) + min; 
        return randomId;
    }

    abstract String getIdString();
}



