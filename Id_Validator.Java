// ValidateSaId.java
public class ValidateSaId {
    public static boolean isIdNumberValid(String idNumber) {
    
        if (idNumber.length() != 13) return false;

        
        if (!idNumber.matches("\\d+")) return false;

       
        int year = Integer.parseInt(idNumber.substring(0, 2));
        int month = Integer.parseInt(idNumber.substring(2, 4));
        int day = Integer.parseInt(idNumber.substring(4, 6));

        if (year < 0 || year > 99) return false;
        if (month < 1 || month > 12) return false;
        if (day < 1 || day > 31) return false;

        
        int gender = Integer.parseInt(idNumber.substring(6, 10));
        if (gender < 0 || gender > 9999) return false;

        
        char citizenship = idNumber.charAt(10);
        if (citizenship != '0' && citizenship != '1') return false;

       
        int sum = 0;
        for (int i = 0; i < 13; i++) {
            int digit = Integer.parseInt(String.valueOf(idNumber.charAt(i)));
            if (i % 2 == 0) {
                sum += digit;
            } else {
                sum += digit * 2 > 9 ? digit * 2 - 9 : digit * 2;
            }
        }
        if (sum % 10 != 0) return false;

        return true;
    }
}
