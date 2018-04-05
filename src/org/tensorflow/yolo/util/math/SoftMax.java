package org.tensorflow.yolo.util.math;

/**
 * Implementation of the SoftMax function.
 * For more information please read this article:
 * https://en.wikipedia.org/wiki/Softmax_function
 *
 * Created by Luci on 05/05/17.
 * https://github.com/deysuman/Object-sensor-android
 */

public class SoftMax {
    private final double[] params;

    public SoftMax(double[] params) {
        this.params = params;
    }

    public double[] getValue() {
        double sum = 0;

        for (int i=0; i<params.length; i++) {
            params[i] = Math.exp(params[i]);
            sum += params[i];
        }

        if (Double.isNaN(sum) || sum < 0) {
            for (int i=0; i<params.length; i++) {
                params[i] = 1.0 / params.length;
            }
        } else {
            for (int i=0; i<params.length; i++) {
                params[i] = params[i] / sum;
            }
        }

        return params;
    }
}
