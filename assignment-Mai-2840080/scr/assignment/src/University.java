/**
 * Please provide your student ID below.
 * 
 * 	Student ID: 2840080
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *  University maintains an ArrayList called modules that stores the list of modules
 *  offered by the university. 
 *  Your task is to correctly implement the method bodies for:
 * 
 *  protected ArrayList<Module> mergeSort(ArrayList<Module> list, boolean ascending, String attr)
 *	Module binarySearch(ArrayList<Module> list, String name)
 *  
 *  The above methods are called via public methods of the same name which supply 
 *  the local modules object as a parameter. You can observe calls to these public
 *  methods in the go methods of UniversityTest.java.  
 */
public class University
{
	private ArrayList<Module>	modules;
	
	public University()
	{
		modules = new ArrayList<Module>();
	}
	
	public void clear()
	{
		for (Module v : modules)
		{
			v.getBtree().clear();
		}
		modules.clear();
	}
	public void addModule(Module v)
	{
		modules.add(v);
	}
	public void describeModuleList()
	{
		for (Module v : modules)
		{
			System.out.println(v.toString());
			v.describeStudentTree();
		}
	}
	/**
	 * This method calls the in order traversal method for a specific module
	 * @param val The index of the module that you want to call the inWalk method for
	 * @return A String with the names of all Students in the tree
	 */
	public String inWalk(int val)
	{
		return modules.get(val).inWalk();
	}
	/**
	 * This method calls the find method for a specific module
	 * @param val The index of the module that you want to call the inWalk method for
	 * @return A reference to the Student that was found or null if no Student found
	 */
	public Person find(int val, String name)
	{
		return modules.get(val).find(name);
	}
	
	/**
	 * This method should use a binary search approach to find for
	 * the Module (based on the name) in the ArrayList 'modules'.
	 * 
	 * You should not modify this code.
	 * 
	 * @param name Module name to be found
	 * @return The module that was found or null if no Module found
	 */
    public Module binarySearch(String name)
    {	
    	return binarySearch(modules, name);
    }
    
	/**
	 * This method should use a binary search approach to find for
	 * the Module (based on its name) in the ArrayList 'modules'.
	 *
     * @param list An ArrayList of Modules objects to search
	 * @param name Module name to be found
 	 * @return The module that was found or null if no Module found
	 */
    protected Module binarySearch(ArrayList<Module> list, String name)
    {
		// Use the binary search algorithm to  
		// Initially this method just returns null - you need to fix this.

    	// TODO
    	for (Module v : modules)
    	{
    		if(v.getName() == name) {
    			return v;
    		}
    	}
    	return null;
    }
	    
	/**
	 * This method should use an merge sort approach to rearrange
	 * the references in the ArrayList 'modules' such that they are in 
	 * order according to the attr (attribute) parameter.
	 * If asc is true, this should be ascending order,
	 * if asc is false, this should be descending order.
	 * 
	 * You should not modify this code.
	 * 
	 * @param asc True if the list should be ascending order, false for descending
     * @param attr Attribute (name or code) that will be use during the sorting
	 * @return	The ArrayList 'modules' that has been sorted using insertion sort
	 */
    public ArrayList<Module> mergeSort(boolean asc, String attr)
    {	
    	return mergeSort(modules, asc, attr);
    }
    
    /**
	 * This method should use an merge sort approach to rearrange
	 * the references in the ArrayList 'modules' such that they are in 
	 * order according to the attr (attribute) parameter.
	 * If asc is true, this should be ascending order,
	 * if asc is false, this should be descending order.
	 * 
	 * @param list The arraylist to be sorted
	 * @param asc True if the list should be ascending order, false for descending
     * @param attr Attribute (name or code) that will be use during the sorting
	 * @return	The ArrayList 'modules' that has been sorted using insertion sort
	 */
    protected ArrayList<Module> mergeSort(ArrayList<Module> list, boolean ascending, String attr)
    {
		// Use the merge sort algorithm to sort 'modules' and then 
		// return it. Initially this method just returns an empty
    	// list - you need to fix this.

		ArrayList<Module> sorted = new ArrayList<Module>();
		// TODO
			
			 sorted.addAll(merge(list));
		 
			 if (attr == "name"&& ascending == true) {
				 sorted.sort(Comparator.comparing(Module::getName));
				
	        }
			 if (attr == "name"&& ascending == false) {
				 sorted.sort(Comparator.comparing(Module::getName).reversed());
				
	        }
	        if (attr == "code"&& ascending == true) {
	        	
	        	 sorted.sort(Comparator.comparing(Module::getCode));
	       	
	        }
	        if (attr == "code" && ascending == false) {
	       
	       	
	    	 sorted.sort(Comparator.comparing(Module::getCode).reversed());
	       }
	        

	        return sorted;
			 
			
	}
	    private static  ArrayList<Module> merge(ArrayList<Module> a) {
	        if (a.size()<=1) return a; // small list don't need to be merged

	        // SEPARATE

	        int mid = a.size()/2; // estimate half the size

	        ArrayList<Module> left = new ArrayList<Module>();
	        ArrayList<Module> right = new ArrayList<Module>();

	        for(int i = 0; i < mid; i++) left.add(a.remove(0)); // put first half part in left
	        while (a.size()!=0) right.add(a.remove(0)); // put the remainings in right
	        // Here a is now empty

	        // MERGE PARTS INDEPENDANTLY

	        merge(left);  // merge the left part
	        merge(right); // merge the right part

	        // MERGE PARTS

	        // while there is something in the two lists
	        while (left.size()!=0 && right.size()!=0) {
	          // compare both heads, add the lesser into the result and remove it from its list
	          if (left.get(0).compareTo(right.get(0))<0) a.add(left.remove(0));
	          else                                       a.add(right.remove(0));
	        }

	        // fill the result with what remains in left OR right (both can't contains elements)
	        while(left.size()!=0)  a.add(left.remove(0));
	        while(right.size()!=0) a.add(right.remove(0));
			return a;
	      }
	    

	}

