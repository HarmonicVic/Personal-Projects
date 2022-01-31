public class BasicCalculations {

    /*DISCLAIMER: The Math class is better for doing math operations, these following implementations
    * may be worse than those present in the Math class. This program is just a practice exercise,
    * for real efficient code, I would've used Math in every calculation function.*/
    public double sumDoubles(double a, double b) {
        return a + b;
    }

    public double subtractDoubles(double a, double b){
        return a - b;
    }

    public double multiplyDoubles(double a, double b) {
        return a * b;
    }

    public double divideDoubles(double a, double b) {
        return a / b;
    }

    public double powerDoubles(double a, double b) {
        double result = a;
        for (int i = 1; i < (int)b; ++i){
            result *= a;
        }
        return result;
    }

    /*TODO make something more interesting than just using Math class*/
    public double squareRootDouble(double a) {
        return Math.sqrt(a);
    }
}
