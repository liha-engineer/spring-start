public abstract class PublicTransportation {
    int fuel;
    int velocity;
    int sonnim;
    int maxsonnim;
    int vehiclenum;
    int fee;
    boolean status;
    String stat;

    PublicTransportation() {
        fuel = 100;
        velocity = 0;
        sonnim = 0;
        vehiclenum = (int) (Math.random() * 9999);
    }

    void endofdrive() {
        System.out.println("운행을 종료합니다.");
    }

    abstract void sonnim_getin(int sonnim);

    abstract void sonnim_getoff(int sonnim);

    abstract void drive_status();

    abstract void change_fuel(int fuel);

    abstract void change_velocity(int velocity);

}