package amazonviewer.model;

public class Player extends Thread{
	public static boolean running;
	
	@Override
	public void run(){
		running = true;
		while(running) {
			try {
				Thread.sleep(1000);
				System.out.println("...Viendo....");							
			} catch (InterruptedException e) { 
				running = false;
			}
		}			
	}
	
	public void stopPlayer(){
		this.interrupt();
	}
	
}
