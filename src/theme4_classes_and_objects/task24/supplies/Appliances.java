package theme4_classes_and_objects.task24.supplies;

import theme4_classes_and_objects.task24.Model;
import utils.ConsoleHelper;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/*Бытовая техника*/
public abstract class Appliances implements Pluggable {
    private Model model;
    private final String brand;
    private final String mark;
    private final double width;
    private final double height;
    private final double length;
    private Thread workingThread;
    private BigDecimal price;
    private boolean turnedOn;

    public Appliances(Model model,String brand, String mark, double width, double height, double length, BigDecimal price) {
        this.brand = brand;
        this.model = model;
        this.mark = mark;
        this.width = width;
        this.height = height;
        this.length = length;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getClass().getSimpleName(), brand, mark);
    }

    public String getMark() {
        return mark;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void plug() {
        if (turnedOn) {
            throw new PlugException("Already plugged");
        } else {
            turnedOn = true;
            workingThread = new Thread(() -> {
                try {
                    while (true) {
                        TimeUnit.SECONDS.sleep(1);
                        model.sendMessage(String.format("%s is %s",toString(),makeWork()));
                    }
                } catch (InterruptedException e) {
                    model.sendMessage(String.format("%s stopped working",toString()));
                }
            });
            workingThread.start();
        }
    }

    @Override
    public void unPlug() {
        if (!turnedOn) {
            throw new PlugException("Already unplugged");
        } else {
            turnedOn = false;
            if (workingThread.isAlive()) {
                workingThread.interrupt();
            }
        }

    }

    protected abstract String makeWork();

    public boolean isTurnedOn() {
        return turnedOn;
    }

    private void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


    public double getLength() {
        return length;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
