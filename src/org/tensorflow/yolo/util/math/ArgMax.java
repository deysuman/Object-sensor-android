package org.tensorflow.yolo.util.math;

/**
 * ArgMax function to select the higher value and its index from the array.
 *
 * Created by Luci on 05/05/17.
 * https://github.com/deysuman/Object-sensor-android
 */
public class ArgMax {

    private double[] params;

    public ArgMax(double[] params) {
        this.params = params;
    }

    public Result getResult() {
        int maxIndex = 0;
        for (int i=0; i<params.length; i++) {
            if (params[maxIndex] < params[i]) {
                maxIndex = i;
            }
        }

        return new Result(maxIndex, params[maxIndex]);
    }

    public class Result {
        private int index;
        private double maxValue;

        public Result(int index, double maxValue) {
            this.index = index;
            this.maxValue = maxValue;
        }

        public int getIndex() {
            return index;
        }

        public double getMaxValue() {
            return maxValue;
        }
    }
}
