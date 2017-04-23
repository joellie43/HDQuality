public class Ticket<T> implements Comparable{
    private int _ID;
    public String descr;
    private int priority;
    private String name;

    public Ticket(int ID, String Descr, int Pri, String nam){
	_ID = ID;
	descr = Descr;
	priority = Pri;
	name = nam;
    }

    public int getID(){
	return _ID;
    }

    public String getDescr(){
	return descr;
    }
    
    public String getName(){
	return name;
    }

    public int getPriority(){
	return priority;
    }

    public int compareTo(Object x){
	if (this.getPriority() >((Ticket) x).getPriority()){
	    return 1;
	}

	else if(this.getPriority() == ((Ticket) x).getPriority()){
	    return 0;
	}

	else{return -1;}
    }
}
