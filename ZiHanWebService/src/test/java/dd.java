public class dd {
	
	public dd(){
		check("第一次加载");
	}
	public dd(String ss){
		check(ss);
	}
	
	public void check(String name){
		System.out.println(name+"-----------");
	}
	
	public static void main(String[] args) {
		new dd("11");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Runnable" + Thread.currentThread().getId()
						+ "--------" + Thread.currentThread().getName());
			}
		}) {
			public void run() {
				System.out.println("Thread" + Thread.currentThread().getId()
						+ "--------" + Thread.currentThread().getName());
			}
		}.start();
	}
}
