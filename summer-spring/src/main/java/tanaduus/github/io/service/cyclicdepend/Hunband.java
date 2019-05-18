package tanaduus.github.io.service.cyclicdepend;

public class Hunband {

    private Wife wife;

    public void wantLove(){
        wife.sendLove();
    }

    public void sendMoney(){
        System.out.println("give money");
    }
}
