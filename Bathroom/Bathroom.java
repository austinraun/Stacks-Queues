import java.util.*;

public class Bathroom {

	public static void main(String[] args) {
		int values[][] = {{1, 2, 3, 4},{ 4, 5, 4, 3}, {4, 3, 2, 1}, {7,2,1,6}};
		int maxValue = maxPath(values);
		System.out.println(maxValue);
	}
	
	//variables to use
	char P = 'E'; //Present : Empty = E, Woman =W, Man =M

	//procedures to slove gender segregation problem
//	void woman_wants_to_enter();
//	void woman_leaves();
//	void man_wants_to_enter();
//	void man_leaves();


	//waiting queue for person to wait if bathroom is occiped

//	int put_in_queue();
//	int get_out_queue();

	int first = 0;
	int  last = 0;
	    
	    int option;
	    int quit = 0; //  use to quit  the program  0 = false, 1 = true 
	    while(quit == 0){
	        System.out.println("\n ----MENU---- \n");
	        System.out.println("\n 1 : Woman wants to enter");
	        System.out.println("\n 2 : Man wants to enter");
	        System.out.println("\n 3 : Woman wants to leave");
	        System.out.println("\n 4 : Man wants to leave ");
	        System.out.println("\n 5 : Quit");
	        System.out.println("\n Select your option :\t ");
			Scanner in = new Scanner(System.in);
			option = in.nextInt();
			

			if( option  == 1 ){
				woman_wants_to_enter();
			}  else if( option  == 2 ){
				man_wants_to_enter();
			}   else if( option  == 3 ){
				woman_leaves();
			}   else if( option  == 4 ){
				man_leaves();
			}   else if( option  == 5 ){
				quit = 1;
			}  else {
				System.out.println(" Please select option from the Menu only.");
			}

	    }
	 //  return 0;
	}


	public int put_in_queue()
	{   
	    if(first == 0)
			first = last = 1;
	    else
			last++;

	return last;
	}



	int get_out_queue()
	{
	    if(first == last)
	    {
			first = last = 0;
			P = 'E';
	    }
	    else
			last--;
	return last;
	}

	void  woman_wants_to_enter()
	{
		switch (P)
	   {
	     case 'W':
			 put_in_queue();
		System.out.println("\n Already woman inside -wait in queue - your number in queue is " + last);
	       break;
		 case 'M':
			 System.out.println("\n Man inside cannot use");
	       break;
		 case 'E': 
	     default:
	    	 System.out.println("\n Bathroom is empty can use it");
			P = 'W';
	       break;
	   }
	}


	void  man_wants_to_enter()
	{
		switch (P)
	   {
	     case 'M':
			 put_in_queue();
			 System.out.println("\n Already woman inside -wait in queue - your number in queue is " + last);
	       break;
		 case 'W':
			 System.out.println("\n Man inside cannot use");
	       break;
		 case 'E': 
	     default:
	    	 System.out.println("\nBathroom is empty can use it");
			P = 'M';
	       break;
	   }
	}



	void woman_leaves()
	    {
	    if(P == 'W')
	    return;
	    if(first == 0)
	    P = 'E';
	    else
		get_out_queue();
	    System.out.println("\n Woman left Another woman entered bathroom - there are " + last + " remaining in queue.");
	}



	void man_leaves()
	    {
	    if(P == 'M')
	    return;
	    if(first == 0)
	    P = 'E';
	    else
	    get_out_queue();
	    System.out.println("\n Man left  another  man entered bathroom - there are " + last + " remaining  in queue");
	}
	
	
}
