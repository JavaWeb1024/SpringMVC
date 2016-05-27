public class Child extends Parents  {
	private int k = print("Child.k initialized");
	  public Child() {
	    System.out.println("k = " + k);
	    System.out.println("j = " + j);
	  }
	  private static void dd()
	  {
	 System.out.println("dd ");
	  }
	  private static  int x2 =
	    print("static Child.x2 initialized");
	  public static void main(String[] args) {
	    System.out.println("Child constructor");
	     new Child();
	    
	  }
}
