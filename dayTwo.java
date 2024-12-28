public class dayTwo {
    
    public Boolean isSafeReport(int[] report){
        //*The levels are either all increasing or all decreasing.
        //*Any two adjacent levels differ by at least one and at most three
        
        // Returns 1 if pos; -1 if neg; 0 if 0 diff
        float initialSign = Math.signum(report[1]- report[0]);

        if (initialSign == 0){
            return false;
        }
        
        for (int i = 1; i < report.length; i++){
            // if not in bounds, return False (is Unsafe)
            int diff = report[i] - report[i-1];
            if (diff < 1 || diff > 3){
                return false;
            }

            // if change in direction, return False (is Unsafe)
            if (Math.signum(diff) != initialSign){
                return false;
            }
        }
        return true;
    }
}
