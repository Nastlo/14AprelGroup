package lesson49;

class SchoolBell {

    private static SchoolBell instance;


    private SchoolBell() {
    }


    public static SchoolBell getInstance() {
        if (instance == null) {
            instance = new SchoolBell();
        }
        return instance;
    }


    public void ring() {
        System.out.println("Zəng çalındı");
    }
}

	public class Main {
	    public static void main(String[] args) {
	
	        SchoolBell bell1 = SchoolBell.getInstance();
	        SchoolBell bell2 = SchoolBell.getInstance();
	
	        bell1.ring();
	
	        System.out.println(bell1 == bell2); 
	    }
}
