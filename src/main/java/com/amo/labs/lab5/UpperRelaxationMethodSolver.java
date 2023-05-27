package com.amo.labs.lab5;

public class UpperRelaxationMethodSolver {


    public static void solver(double[][] A, double[] b, double[] x, double omega,
                              int maxIterations, double tolerance) {
        int n = A.length;

        for (int iter = 0; iter < maxIterations; iter++) {
            double maxDiff = 0.0;

            for (int i = 0; i < n; i++) {
                double sum = b[i];
                double diag = A[i][i];

                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= A[i][j] * x[j];
                    }
                }

                x[i] = (1 - omega) * x[i] + (omega / diag) * sum;

                double diff = Math.abs(omega / diag) * Math.abs(sum);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }

            if (maxDiff < tolerance) {
                return;
            }
        }
    }
}


