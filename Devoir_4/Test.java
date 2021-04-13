package Devoir_4;

public class Test {

    public static void main(String[] args) {

        LinkedList1 list;        // The list of strings.

        String typed;       // An item typed in by the user.

        String[] elem;       // The elements in the list, obtained by
                            //  calling list.getList().  
      
        boolean done;       // This will be set to true then the user
                            // wants to exit from the program.

        done = false;

        list = new LinkedList1();  // Start with an empty list.
        
        System.out.println("\n\nHello !");

        while (done == false) {
 
           // Get and display the elements that are currently in the list.
            elem = list.getList();
            
            if (elem.length == 0)
                System.out.println("\n\nYour list is empty!");
            else {
                System.out.println("\n\nThe elements of your list are:");
                for (int i = 0; i < elem.length; i++)
                    System.out.println("   " + elem[i]);              
            }

            // Display a menu of operations, and get the
            // user's choice.
            System.out.println("\n\nChoose an operation:");
            System.out.println("    1.  Add an item.");
            System.out.println("    2.  Remove an item.");
            System.out.println("    3.  Find an item.");
            System.out.println("    4.  Exit.");
            System.out.print("Enter the number of your choice:  ");
            int menu = Keyboard.getlnInt();

            // Carry out the operation selected by the user.  For
            // items 1 to 3, get a string from the user and call
            // the appropriate method from the list.

            switch (menu) {
                case 1:  // Add an item.
                    System.out.print("\nEnter the item to be added:  ");
                    typed = Keyboard.getln().trim().toLowerCase();
                    list.add(typed);
                    System.out.println("OK");
                    break;
                case 2:  // Remove an item.
                    System.out.print("\nEnter the item to be deleted:  ");
                    typed = Keyboard.getln().trim().toLowerCase();
                    if ( list.remove(typed) )
                        System.out.println("OK");
                    else
                        System.out.println("That item was not found in the list.");
                    break;
                case 3:  // Check whether an item occurs in the list.
                    System.out.print("\nEnter an item to find:  ");
                    typed = Keyboard.getln().trim().toLowerCase();
                    if ( list.find(typed) )
                        System.out.println("Yes, that item is in your list.");
                    else
                        System.out.println("No, that item is not in your list.");
                    break;
                case 4:  // Exit from this program.
                    done = true;
                    break;
                default:
                    System.out.println("Illegal choice.");
                    break;
            } // end of switch
            System.out.println("List representation... kinda... i did my best");
            System.out.println(list);
        } // end of while

        System.out.println("\n\nBye!");

    } // end of main()

}  // end of Test class

