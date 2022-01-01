package Practice.chap7;

public class KumhoTire extends Tire {
    //필드
    //생성자
    public KumhoTire(String location, int maxRotation) {
        super(location, maxRotation);
    //부모 클래스의 생성자가 매개변수를 가지고 있는 생성자이기 때문에 super(매개변수,...)를 통해 따로 호출해주어야 한다.
    }

    //메소드
    @Override
    public boolean roll() {
        ++accumulatedRotation;
        if (accumulatedRotation < maxRotation) {
            System.out.println(location+"KumhoTire 수명:"+(maxRotation-accumulatedRotation)+"회");
            return true;
        }else{
            System.out.println("***" + location + "KumhoTire 펑크 ***");
            return false;
        }
    }
}
