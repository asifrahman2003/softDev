/* Author: Muhammad Asifur Rahman
 * Course: CSc 210 (ICA 3)
 * Program purpose: The DescriptiveStatistics program is a versatile
 * tool for statistical analysis, specializing in standard deviation calculation.
 * Users can dynamically add data points, ensuring a robust dataset for accurate
 * insights. The program checks for a sufficient number of data points before proceeding,
 * guaranteeing meaningful results. Employing established statistical formulas, it
 * computes the mean, variance, and standard deviation. With a capacity to handle diverse
 * datasets, this program offers a flexible and powerful solution for descriptive statistics.
 */

class DescriptiveStatistics {
    private double sum = 0;
    private int count = 0;
    private double[] data = new double[1000];

    public void add(double number) {
        sum += number;
        data[count] = number;
        count++;
    }

    public double standardDeviation() {
        if (count < 2) {
            return 0.0;
        }
        int i = 0;
        double mean = sum / count;
        double variance = 0;
        while (i < count) {
            double temporary = mean - data[i];
            variance += temporary * temporary;
            i++;
        }
        variance /= (count - 1);
        double standardDev = Math.sqrt(variance);
        return standardDev;
    }
}
