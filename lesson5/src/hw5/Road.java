package hw5;

public class Road extends Stage {
    private static volatile int count = 0;

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            count++;
            if (count == MainClass.CARS_COUNT + 1){
                System.out.println(c.getName() + " победил в гонке!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
