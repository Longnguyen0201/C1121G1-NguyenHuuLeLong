package ss4_lop_va_doi_tuong_trong_java.bai_tap;



public class StopWatch {
    long startTime;
    long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.getEndTime() - this.getStartTime();
    }

    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("Start time: " +stopWatch.getStartTime());
        selectionSort(arr);
        stopWatch.stop();
        System.out.println("End time:"+ stopWatch.getEndTime());
        System.out.println("Execution time: " +stopWatch.getElapsedTime());


    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < 100000; i++) {
            for (int j = i + 1; j < 100000; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

    }


}



