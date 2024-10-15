public class ValidateSaId {
    public static boolean isIdNumberValid(String idNumber) {
        
        if (idNumber.length() != 13) return false;

        if (!idNumber.matches("\\d+")) return false;

        
        int year = Integer.parseInt(idNumber.substring(0, 2));
        int month = Integer.parseInt(idNumber.substring(2, 4));
        int day = Integer.parseInt(idNumber.substring(4, 6));

        if (month < 1 || month > 12) return false;
        if (day < 1 || day > 31) return false;

        
        int gender = Integer.parseInt(idNumber.substring(6, 10));
        if (gender < 0 || gender > 9999) return false;

        
        char citizenship = idNumber.charAt(10);
        if (citizenship != '0' && citizenship != '1') return false;

       
        int sum = 0;
        boolean alternate = false;
        for (int i = idNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(idNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}

