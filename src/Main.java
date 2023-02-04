import java.util.Scanner;

class Bus extends PublicTransportation {
    int vehiclenum = (int) (Math.random() * 5000);
    int fee = 1500;

    public Bus() {
        this.vehiclenum = vehiclenum + 1500;
        maxsonnim = 20;
        status = true;
        System.out.println(vehiclenum + "번 버스 객체 생성");
        System.out.println("연료: " + fuel);
        System.out.println("속도: " + velocity);
        System.out.println("승객: " + sonnim);
        System.out.println("최대승객: " + maxsonnim);
        System.out.println("요금: " + fee);
        System.out.println("상태: " + stat);
    }

    @Override
    void sonnim_getin(int sonnim) {
        this.sonnim += sonnim;
        if (this.sonnim > maxsonnim) {
            System.out.println("탑승 가능한 인원 수 초과입니다!");
            this.sonnim = sonnim;
        } else {
            System.out.println("탑승 승객 수: " + this.sonnim);
            System.out.println("잔여 좌석 수: " + (maxsonnim - this.sonnim));
            System.out.println("요금 확인: " + (this.sonnim * fee));
        }
    }

    @Override
    void drive_status() {
        if (status) {
            stat = "운행";
            System.out.println("현재 상태: " + stat);
        } else {
            stat = "차고지행";
            System.out.println("현재 상태: " + stat);
        }
    }

    @Override
    void sonnim_getoff(int sonnim) {
        this.sonnim -= sonnim;
        if (maxsonnim - this.sonnim < 0) {
            System.out.println("손님은 0명보다 적을 수 없습니다!");
            this.sonnim = sonnim;
        } else {
            System.out.println("하차 승객 수: " + this.sonnim);
            System.out.println("잔여 좌석 수: " + (maxsonnim - this.sonnim));
            if (sonnim == 0) {
                System.out.println("손님이 아무도 없습니다.");
            }
        }
    }

    @Override
    void change_fuel(int fuel) {
        this.fuel += fuel;
        if (this.fuel > 100) {
            System.out.println("주유량은 100을 넘을 수 없습니다!");
        } else if (this.fuel < 10) {
            this.status = false;
            System.out.println("주유량: " + this.fuel);
            System.out.println("주유가 필요합니다.");
            drive_status();
        } else {
            System.out.println("주유량: " + this.fuel);
        }
    }

    @Override
    void change_velocity(int velocity) {
        this.velocity = velocity;
        System.out.println("현재 속도: " + this.velocity + " , 연료는 " + this.fuel + ". 변경속도를 입력하세요.");
        Scanner scan = new Scanner(System.in);
        int change_velocity = scan.nextInt();
        this.velocity = change_velocity;
        System.out.println("변경된 속도: " + this.velocity);
    }

    @Override
    void endofdrive(){
        super.endofdrive();
    }
}

public class Main {
    public static void main(String[] args) {
        Bus b = new Bus();
        Bus b2 = new Bus();
//        b.drive();
        b.sonnim_getin(7);
        b.change_velocity(30);
        b.change_fuel(-50);
        b.drive_status();
        b.sonnim_getin(59);
        b.sonnim_getoff(4);
        b.change_fuel(-45);
    }
}
