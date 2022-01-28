package assistedprojects;

class Exception2 extends Exception{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String str1;
	   Exception2(String str2) {
		str1=str2;
	   }
	   public String toString(){ 
		return ("MyException Occurred: "+str1) ;
	   }
	}
	class Example1{
	   public static void main(String args[]){
		try{
			System.out.println("Starting of try block");
			// I'm throwing the custom exception using throw
			throw new Exception2("This is My error Message");
		}
		catch(Exception2 exp){
			System.out.println("Catch Block") ;
			System.out.println(exp) ;
		}
	   }
	}

