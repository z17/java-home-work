package javase07.t03;

import java.util.Random;

class IntegerSetterGetter extends Thread {
    private static int countThreads = 0;
    private static int countWaitingThreads = 0;
    private SharedResource resource;
    private boolean run;

    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;
        synchronized (this) {
            countThreads++;
        }

        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            countThreads--;
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;

        synchronized (resource) {
            System.out.println("Поток " + getName()
                    + " хочет извлечь число.");
            number = resource.getELement();
            if (number == null) {
                synchronized (this) {
                    // если число ождающих потоков на 1 меньше общего числа потоков - мы не должны давать последнему ожидать значения
                    if (countWaitingThreads + 1 == countThreads) {
                        return;
                    }
                    countWaitingThreads++;
                }
                while (number == null) {
                    System.out.println("Поток " + getName() + " ждет пока очередь заполнится.");
                    resource.wait();
                    System.out.println("Поток " + getName() + " возобновил работу.");
                    number = resource.getELement();
                }
                synchronized (this) {
                    countWaitingThreads--;
                }
            }
            System.out.println("Поток " + getName() + " извлек число " + number);
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число " + number);
            resource.notify();
        }
    }
}


