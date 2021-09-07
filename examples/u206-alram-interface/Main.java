import java.util.Calendar;

interface Alarm {
    public void setAlram(int hours, int min);

    public void arm();

    public void disarm();

    public void snooz(int min);

    public void ring();

    public boolean isArmed();
}

class DigitalClock implements Alarm {
    private int hours;
    private int min;
    private boolean armed = false;

    public void setAlram(int hours, int min) {
        this.hours = hours;
        this.min = min;
    }

    public void arm() {
        this.armed = true;
    }

    public void disarm() {
        this.armed = false;
        System.out.println("Alram Disarmed");
    }

    public void snooz(int min) {
        this.min += min;
    }

    public boolean isArmed() {
        return armed;
    }

    public void ring() {
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMin = calendar.get(Calendar.MINUTE);
        while (true) {
            if (hours == currentHour && min == currentMin && isArmed()) {
                System.out.println("Rings with a sound");
                continue;
            } else {
                disarm();
                break;
            }
        }
    }
}

interface Radio {
    public void turnOnRadio();

    public void turnOffRadio();

    public void tuneIn(String frequency);

    public void play();
}

class DigitalRadio implements Radio {
    private String frequency;
    private boolean on = false;

    public void turnOnRadio() {
        this.on = true;
    }

    public void turnOffRadio() {
        this.on = false;
    }

    public void tuneIn(String frequency) {
        if (isRadioOn()) {
            this.frequency = frequency;
        }
    }

    public boolean isRadioOn() {
        return on;
    }

    public void play() {
        System.out.println("Radio is playing at " + frequency + " Mhz");
    }
}

interface InternetRadio extends Radio {
    public void connetToInternet();

    public void disconnectFromInternet();

}

class FeaturePhone implements Alarm, Radio {

}

class Main {
    public static void main(String[] args) throws InterruptedException {
        Alarm alarm = new AnalogClock();
        alarm.setAlram(13, 35);
        alarm.arm();
        while (alarm.isArmed()) {
            alarm.ring();
            Thread.sleep(1000);
        }
    }
}