import java.util.Scanner;

abstract class Vehicle {
    int maxsonnim = 20;
    int sonnim;
    int fee = 1000;
    int busnum;
    int fuel;
    int velocity;
    String status;

    abstract void drive(String status, int velocity, int fuel);
    abstract void change_status(String status, int fuel);
    abstract void sonnim_getin(int sonnim);
    abstract void sonnim_getoff(int sonnim);
    abstract void change_velocity(int velocity, int fuel);
    abstract void endofdrive(String status);
}

class Bus extends Vehicle {
    void drive(String status, int velocity, int fuel){
        this.status = "운행";
        this.velocity = velocity;
        this.fuel = fuel;
        System.out.println("추상클래스 Vehicle 상속, Bus로 구현 - drive 메소드");
        System.out.println("상태는 " + status);
        System.out.println("속도는 " + velocity);
        System.out.println("연료는 " + fuel);
    }

    @Override
    void change_status(String status, int fuel) {
        if(fuel < 10) {
            this.status = "차고지행";
            System.out.print("주유가 필요합니다.");
        }
    }

    @Override
    void endofdrive(String status) {
        this.status = "차고지행";
        System.out.println("운행을 종료합니다.");
    }

    @Override
    void sonnim_getin(int sonnim) {
        this.sonnim += sonnim;
        if (sonnim > 20) {
            System.out.println("탑승 가능한 인원 수 초과입니다.");
        }
    }

    @Override
    void sonnim_getoff(int sonnim) {
        this.sonnim -= sonnim;
        if (sonnim < 1) {
            System.out.println("손님이 아무도 없습니다.");
        }
    }

    @Override
    void change_velocity(int velocity, int fuel) {
        System.out.println("현재 속도: " + this.velocity + " , 변경속도를 입력하세요.");
        Scanner scan = new Scanner(System.in);
        velocity = scan.nextInt();
        this.velocity += velocity;
        this.fuel -= fuel;
        System.out.println("속도 변경. 현재 속도는: " + this.velocity);

        if (fuel < 10) {
            this.velocity = velocity;
            System.out.print("주유량을 확인해주세요.");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Bus b = new Bus();
        b.drive("운행", 10, 19);
    }
}