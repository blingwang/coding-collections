public class ValidateNumber {
    public boolean isNumber(String s) {
        String pattern = "^\\s*[+-]?((\\d+\\.?\\d*)|(\\d*\\.?\\d+))(e[+-]?\\d+)?\\s*$";
        return s.matches(pattern);    
    }
}
