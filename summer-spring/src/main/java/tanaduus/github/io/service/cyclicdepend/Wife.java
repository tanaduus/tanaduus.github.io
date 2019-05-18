package tanaduus.github.io.service.cyclicdepend;

public class Wife {

    private Hunband hunband;

    public void wantMoney(){
        hunband.sendMoney();
    }

    public void sendLove(){
        System.out.println("love you");
    }
}
