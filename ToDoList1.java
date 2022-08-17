package com.pro;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ToDoList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    Scanner sc1 = new Scanner(System.in);
	    String desc;
	    int choice=0;

	    List<Task1> todoList = new ArrayList<Task1>();

	    while(choice != 8)
	    {
	      System.out.println("Give 1 for Creating a Task ");
	      System.out.println("Give 2 for Updating a description");
	      System.out.println("Give 3 for List entire tasks");
	      System.out.println("Give 4 for List all the pending tasks");
	      System.out.println("Give 5 for Mark the completed tasks");
	      System.out.println("Give 6 for List the completed tasks");
	      System.out.println("Give 7 for List the tasks that are assigned for today");
	      System.out.println("Give 8 for Exit!!!");
	      choice = sc.nextInt();

	    
	      switch(choice)
	      {
	      case 1:
	        
	        System.out.println("Create a task name :");
	        String name1=sc1.nextLine();
	        System.out.println("Give description for the task");
	        desc=sc1.nextLine();
	        System.out.println("Enter a date in dd/MM/yyyy format");
	        String sDate1=sc1.nextLine();
	        Date date1;
	      
	        try
	        {
	        	date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
	        	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	            String str = formatter.format(date1);
	        	Task1 t1 = new Task1(name1,desc,str);
	        	todoList.add(t1);
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	        
	       
	        break;
	        
	      case 2 : 
	    	  System.out.println("Enter a task name for which you need to update!!");
	    	  String taskName2 = sc1.nextLine();
	    	  System.out.println("Enter new description");
			  desc=sc1.nextLine();
			  for(Task1 t : todoList)
	    	  {
	    		  if(t.taskName.equals(taskName2))
	    		  {
	    			  t.description=desc;
	    		  }
	    	  }
		      System.out.println("Description updated ");
		      break;
	        
	     
	     
		      
	      case 3 :
	    	  for(Task1 t : todoList)
	    	  {
	    		  System.out.println("Task Name : "+t.taskName);
	    		  System.out.println("Description : "+t.description);
	    		  System.out.println("Created Time : "+t.date);
	    		  if(t.taskStatus==true)
	    			  System.out.println("Task Status : Completed");
	    		  else
	    			  System.out.println("Task Status : Pending");
	    		  
	    		  System.out.println();
	    		  
	    	  }
	    	  break;
	    	  
	      case 4 : 
	    	  System.out.println("Listing pending tasks...!!!!!!!!!!!!!!!!!");
	    	  for(Task1 t : todoList)
	    	  {
	    		  if(t.taskStatus==false)
	    		  {
	    			  System.out.println(t.taskName);
	    		  }
	    	  }
	    	  break;
	    	  
	    	  
	      case 5 : 
	    	  System.out.println("Enter the task name that you want mark as completed");
	    	  String taskName1 = sc1.nextLine();
	    	  for(Task1 t : todoList)
	    	  {
	    		  if(t.taskName.equals(taskName1))
	    		  {
	    			  t.taskStatus=true;
	    		  }
	    	  }
	    	  break;
	    	  
	      case 6 : 
	    	  System.out.println("Listing completed tasks...!!!!!!!!!!!");
	    	  for(Task1 t : todoList)
	    	  {
	    		  if(t.taskStatus==true)
	    		  {
	    			  System.out.println(t.taskName);
	    		  }
	    	  }
	    	  break;
	      case 7 : System.out.println("Listing today's tasks");
	      		   Date date = new Date();
	               SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	               String str = formatter.format(date);
			       for(Task1 t : todoList)
				   {
					   if(t.date.equals(str))
					   {
						   System.out.println(t.taskName);
					   }
				   }
			       break;
	      case 8 : System.out.println("Thank you!!!!!!!!!!!! please exit............");
	      break;
	      default : System.out.println("Please enter a valid number between 1-8");
	      break;
	      		}
	    	}
	  	}

	}


