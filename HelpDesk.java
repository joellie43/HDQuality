import java.util.ArrayList;
import java.util.Scanner;
public class HelpDesk{
    private static ArrayPriorityQueue _data;
    private static ArrayList services; 

    public HelpDesk(){
	_data = new ArrayPriorityQueue();
	services = new ArrayList<String>();
	//services from most to lease priority
	services.add("please save my computer");
	services.add("my cursor doesn't move");
	services.add("I need to reset my password");
	services.add("I need help with installing Microsoft Word");
	
    }

    public static void printServices(){
	for (int i = 0; i < services.size(); i++){
	    System.out.println((i+1) + ". " + services.get(i));
	}
    }

    public String toString(){
	String retStr = "";
	for (Object o : _data._data){
	    retStr += "ID: " + ((Ticket) o).getID();
	    retStr += "Description: " + ((Ticket) o).getDescr();
	    retStr += "Priority: " + ((Ticket) o).getPriority();
	    retStr += "Name: " + ((Ticket) o).getName() + "\n";
	}
	return retStr;
    }
    
    public static void main(String[] args){
	HelpDesk x = new HelpDesk();
	int goOn = 0;
	int ticketNum = 1;
	while (goOn == 0){
	    //prompting user for Ticket info
	    
	    //getting description and priority
	    System.out.println("How may we help you? (Please enter the corresponding number)");
	    printServices();
	    Scanner s = new Scanner(System.in);
	    String i = s.next();
	    int servIndex = Integer.parseInt(i);
	    String description = (String) services.get(servIndex-1);
	    int priority = services.indexOf(description) + 1;
	    
	    //getting name
	    System.out.println("\nWhat is your name?");
	    Scanner c = new Scanner(System.in);
	    String name = c.nextLine();
	    
	    //Creates new ticket with info
	    Ticket t = new Ticket(ticketNum, description, priority, name);
	    //Enters ticket into _data(takes time to fix)
	    _data.add(t);

	    //to check order of tickets
	    //System.out.println(x);

	    //option of adding more tickets
	    System.out.println("\nDo you have any other problems?");
	    System.out.println("Input 0 for yes, 1 for no");
	    Scanner m = new Scanner(System.in);
	    goOn = Integer.parseInt(m.nextLine());
	    if (goOn == 0){
		    ticketNum++;}
	    else{
		System.out.println("Thank you for your cooperation. We will begin to process your information shortly.");
	    }
	}
    }
    
}
