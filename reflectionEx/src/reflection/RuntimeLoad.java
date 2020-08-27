package reflection;

public class RuntimeLoad {

	public static void main(String[] args) {
		IoCContainer c = new IoCContainer();
		
		Money m = c.invokeAnnotation(new Money());
		
		try {
			int money = m.minus();
			System.out.println("남은 금액은 : " + money);
		} catch (Exception e) {
			System.out.println("Money 객체가 만들어지지 않았어요.");
		}
		
	}
}
