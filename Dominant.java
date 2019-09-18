/**************************************************************
 Purpose/Description: <a brief description of the program>
 Author’s Panther ID: <your Panther ID number>
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/
public class Dominant{

    static final int ZERO_INITIALIZER = 0;

    public static void main(String[] args)
    {
       int[] array = {16,17,4,3,5,2};
       int[] arrayTwo = {3,5,1,2,6,4,14,23,1};
       boolean[] dominants = findDominant(array);
       printDominants(array, dominants);
       boolean[] dominantsTwo = findDominant(arrayTwo);
       printDominants(arrayTwo, dominantsTwo);

    }

    /**
     * Linear Algorithm which takes an array of integers and finds the dominant elements. Dominant elements are
     * defined as the element larger than an element to its right. For this reason we use a loop to iterate through the 
     * array once, if the element which fallows any particular element is less than the before element, then the previous 
     * element is said to be dominant. 
     * @param array: array containing integers to be tested
     * @return: Parallel array of boolean indicating which element is dominant. 
     */
    public static boolean[] findDominant(int array[])
    {
        boolean[] dominants = new boolean[array.length];
	int lastDominantFoundIndex = 0;
	for (int index = (array.length - 1) ; index >= 0; index--)
	{
		if(index == (array.length -1) )
		{
            System.out.println("index = " + index + " array[index] = " + array[index] );
			lastDominantFoundIndex = index; 
			dominants[index] = true;	
		}
	
		else if(array[lastDominantFoundIndex] < array[index])
		{
                System.out.println(array[index] + " is greater than " + array[lastDominantFoundIndex]);
				lastDominantFoundIndex = index;
				dominants[index] = true;
		}
        else
        {
            dominants[index] = false;
        }
	
	}

        return dominants;
}
/**
 * Used to print the dominants found in the function findDominant
 * Iterates through the array and prints the numbers determined to be dominant
 * @param array : Array containing integers.
 * @param dominants: Parrallel array to array containing boolean value if array[index] is dominant
 */
    public static void printDominants(int array[], boolean dominants[])
    {
        System.out.println(array.toString());
        System.out.print("Dominant: {");
        for (int iterator = ZERO_INITIALIZER; iterator < array.length; iterator++)
        {
            if(dominants[iterator])
            {
                System.out.print(array[iterator] + ",");
            }
        }
        System.out.println("}");
    }
}
