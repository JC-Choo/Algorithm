package com.example.cnwlc.algorithm.coding_dictionary;

public class RamenCook implements Runnable {
    private int ramenCount;
    private String[] burners = {"_", "_", "_", "_"};

    public RamenCook(int count) {
        ramenCount = count;
    }

    @Override
    public void run() {
        while(ramenCount > 0) {
            synchronized (this){
                ramenCount--;
                System.out.println(Thread.currentThread().getName()+" : "+ramenCount+"개 남음");
            }

            for(int i = 0; i < burners.length; i++) {
                if(!burners[i].equals("_")) continue;

                synchronized (this) {
                    burners[i] = Thread.currentThread().getName();
                    System.out.println(
                            "              "
                                    + Thread.currentThread().getName()
                                    +": ["+(i+1)+"]번 버너 ON"
                    );
                    showBurners();
                }

                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (this) {
                    burners[i] = "_";
                    System.out.println(
                            "                                    "
                                    +Thread.currentThread().getName()
                                    +": ["+(i+1)+"] 번 배너 OFF"
                    );
                }
                break;
            }

            try {
                Thread.sleep(Math.round(1000 * Math.random()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showBurners() {
        StringBuilder stringToPrint = new StringBuilder("                                             ");
        for(int i=0; i<burners.length; i++) {
            stringToPrint.append(" ").append(burners[i]);
        }

        System.out.println(stringToPrint);
    }
}