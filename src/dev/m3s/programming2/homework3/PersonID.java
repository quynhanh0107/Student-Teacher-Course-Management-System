package dev.m3s.programming2.homework3;

public class PersonID {
    private String birthDate = ConstantValues.NO_BIRTHDATE;

    public String getBirthDate() {
        return this.birthDate;
    }

    public String setPersonId(final String personID) {
        if (personID == null) {
            return ConstantValues.INVALID_BIRTHDAY;
        }

        if (!checkPersonIDNumber(personID)) {
            return ConstantValues.INVALID_BIRTHDAY;
        }
    
        String day = personID.substring(0, 2);
        String month = personID.substring(2, 4);
        String year = personID.substring(4, 6);
        String fullYear = "";
        String formattedDate = "";
        char midChar = personID.charAt(6);
        
        // Only allow valid century characters: '+', '-', 'A'
        if (midChar == '+') {
            fullYear = "18" + year;
            formattedDate = String.format("%s.%s.%s", day, month, fullYear);
        } else if (midChar == '-') {
            fullYear = "19" + year;
            formattedDate = String.format("%s.%s.%s", day, month, fullYear);
        } else if (midChar == 'A') {
            fullYear = "20" + year;
            formattedDate = String.format("%s.%s.%s", day, month, fullYear);
        } else {
            return ConstantValues.INVALID_BIRTHDAY;
        }
        
        if (!checkBirthDate(formattedDate)) {
            return ConstantValues.INVALID_BIRTHDAY;
        }
        
        boolean isValidCharacter = checkValidCharacter(personID);

        // Debugging output
        //System.out.println("Debug: checkValidCharacter result = " + isValidCharacter);

        if (!isValidCharacter) {
            return ConstantValues.INCORRECT_CHECKMARK;
        }

        this.birthDate = formattedDate; 

        return "OK";
    }

    private boolean checkPersonIDNumber(final String personID) {
        if (personID.length() == 11 
            && (personID.charAt(6) == '+'
            || personID.charAt(6) == '-'
            || personID.charAt(6) == 'A')) {
                return true;
            }
        return false;
    }

    private boolean checkLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }

    private boolean checkValidCharacter(final String personID) {
        String birthDatePart = personID.substring(0, 6);
        String individualPart = personID.substring(7, 10);
        char providedCheckMark = personID.charAt(10);

        String numericPart = birthDatePart + individualPart; 
        
        int dividendNum = Integer.parseInt(numericPart); 
        char expectedCheckMark = ConstantValues.CHECK_MARK.charAt(dividendNum % 31); 

        //System.out.println("Debug: Provided Check Mark = " + providedCheckMark);
        //System.out.println("Debug: Expected Check Mark = " + expectedCheckMark);
        
        if (providedCheckMark == expectedCheckMark) {
            return true;
        }
        
        return false;
    }

    private boolean checkBirthDate(final String date) {

        if (date == null || !date.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) { 
            return false;
        }

        try {
            String[] parts = date.split("\\.");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            if (month < 1 || month > 12) {
                return false;
            }

            int[] daysInMonth = {31, 28 + (checkLeapYear(year) ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            if (day < 1 || day > daysInMonth[month - 1]) {
                return false;
            }
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
        
    }
}
