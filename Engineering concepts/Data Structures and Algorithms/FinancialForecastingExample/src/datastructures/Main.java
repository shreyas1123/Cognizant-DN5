package datastructures;

/**
 * Main class to demonstrate calculating future value of an investment
 * recursively based on an annual growth rate and a number of years.
 */
public class Main {

    /**
     * Calculates the future value of an investment using recursion.
     * 
     * Algorithm Details:
     * 1. Base Case: If years is 0, the future value is simply the initial investment.
     * 2. Recursive Step: Future Value for N years is the Future Value of (N-1) years
     *    multiplied by (1 + annual growth rate).
     * 
     * Time Complexity: O(N) - where N is the number of years (N recursive calls).
     * Space Complexity: O(N) - due to the recursion call stack.
     * 
     * @param initialInvestment the starting investment amount (present value)
     * @param growthRate        the annual growth rate (expressed as a decimal, e.g., 0.05 for 5%)
     * @param years             the number of years to forecast
     * @return the forecasted future value of the investment
     */
    public static double calculateFutureValue(double initialInvestment, double growthRate, int years) {
        // Base Case: If years is 0, no growth has occurred yet.
        // Return the current investment value.
        if (years == 0) {
            return initialInvestment;
        }

        // Recursive Step: Calculate the future value for (years - 1)
        // and multiply it by (1 + growthRate) for the current year's growth.
        return calculateFutureValue(initialInvestment, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        // Step 1: Define initial investment parameters
        double initialInvestment = 1000.00; // $1,000.00 initial principal
        double annualGrowthRate = 0.05;      // 5% annual interest/growth rate
        int forecastYears = 5;               // Forecast duration of 5 years

        System.out.println("==========================================");
        System.out.println("      Financial Forecasting System       ");
        System.out.println("==========================================");
        System.out.printf("Initial Investment: $%,.2f%n", initialInvestment);
        System.out.printf("Annual Growth Rate: %.1f%%%n", (annualGrowthRate * 100));
        System.out.printf("Forecast Period:    %d years%n", forecastYears);
        System.out.println("==========================================");

        // Step 2: Show year-by-year growth utilizing the recursive function
        System.out.println("Year-by-Year Forecast Summary:");
        for (int year = 0; year <= forecastYears; year++) {
            double valueAtYear = calculateFutureValue(initialInvestment, annualGrowthRate, year);
            System.out.printf("Year %d: Future Value = $%,.2f%n", year, valueAtYear);
        }
        System.out.println("==========================================");

        // Step 3: Run and display the final forecast result
        double finalFutureValue = calculateFutureValue(initialInvestment, annualGrowthRate, forecastYears);
        
        System.out.println("Final Result:");
        System.out.printf("After %d years, your initial investment of $%,.2f at a %.1f%% growth rate will grow to: $%,.2f%n",
                forecastYears, initialInvestment, (annualGrowthRate * 100), finalFutureValue);
        System.out.println("==========================================");
    }
}
