package kim.eren.oca_8_certificate.mthread.ufukuzun.chapter_1;

public class Runner extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Selam : " + i +" : "+ this.getName());
		}
	}

}
