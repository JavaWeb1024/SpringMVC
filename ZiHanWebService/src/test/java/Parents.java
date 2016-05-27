public class Parents {
	private Integer i = 9;
	private int p = print(" Parents.p initialized");
	protected Integer j;
	{
		System.out.println("语句块" + "i = " + i + ", j = " + j);
	}

	Parents() {
		System.out.println("i = " + i + ", j = " + j);
		j = 39;
	}

	private static int x1 = print("static Parents.x1 initialized");

	static int print(String s) {
		System.out.println(s);
		return 47;
	}

}
