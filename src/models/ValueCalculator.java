package models;

import java.util.Arrays;

public class ValueCalculator {

    private final int arrSize = 1000000;
    private final int halfSize = arrSize / 2;
    private float[] array = new float[arrSize];
    private float[] arraycopy = new float[halfSize];
    private float[] arraycopy2 = new float[halfSize];
    private long start;

    public void doCalc() {
        start = System.currentTimeMillis();

        Arrays.fill(array, 1);

        System.arraycopy(array, 0, arraycopy, 0, halfSize);
        System.arraycopy(array, halfSize, arraycopy2, 0, halfSize);

        CalcThread th1 = new CalcThread("1", arraycopy);
        CalcThread th2 = new CalcThread("2", arraycopy2);

        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.arraycopy(th1.getArray(), 0, array, 0, halfSize);
        System.arraycopy(th2.getArray(), 0, array, halfSize, halfSize);

        showStats();


    }

    private void showStats() {
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
