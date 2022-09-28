package models;

public class CalcThread extends Thread {

    private float[] array;
    private boolean isActive;


    CalcThread(String name, float[] array) {
        super(name);
        this.array = array;
        isActive = true;
    }

    @Override
    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());

        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.printf("%s finished... \n", Thread.currentThread().getName());
        isActive = false;
    }

    public float[] getArray() {
        return array;
    }

    public boolean isActive() {
        return isActive;
    }
}
