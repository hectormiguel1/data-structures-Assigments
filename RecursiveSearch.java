/**************************************************************
 Purpose/Description: ARRAY MUST BE SORTED!!!!
 This function is designed to find an item in an array, by splitting the array into 3 distinct sections and then
 comparing around the boundaries to determine which section of the array to search. This allows for discarding of 2/3
 of the array on each pass through the array, adding great efficiency to the search. In order to do this we start by
 checking if our desired item is at the begging or the end of the array, if it is not and the array is larger than 1
 then we can start to split the array. We are going to have three distinct sections in the array. We will have from
 left -> directionOne, directionOne -> directionTwo, and directionTwo -> right. we then if the desired item is
 less then or greater than directionOne, and if it is less than or greater than Direction two, depending on the result
 a the function will be called recursely with the leftPosition and right positions moved accordingly. At the end
 either the index of the item desired will be returned or -1 to indicate that the item could not be found in the array.
 Author’s Panther ID: 5708475
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/
public class RecursiveSearch {

    static final int NOT_FOUND = -1;

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int index = terSearch(numbers, 0, numbers.length - 1, 4);
        System.out.println(index);
    }

    /**
     * !!!ARRAY MUST BE SORTED TO USE THIS METHOD AND SORTED IN INCREASING ORDER.!!!!
     *
     * This function is designed to find an item in an array, by splitting the array into 3 distinct sections and then
     * comparing around the boundaries to determine which section of the array to search. This allows for discarding of 2/3
     * of the array on each pass through the array, adding great efficiency to the search. In order to do this we start by
     * checking if our desired item is at the begging or the end of the array, if it is not and the array is larger than 1
     * then we can start to split the array. We are going to have three distinct sections in the array. We will have from
     * left -> directionOne, directionOne -> directionTwo, and directionTwo -> right. we then if the desired item is
     * less then or greater than directionOne, and if it is less than or greater than Direction two, depending on the result
     * a the function will be called recursely with the leftPosition and right positions moved accordingly. At the end
     * either the index of the item desired will be returned or -1 to indicate that the item could not be found in the array.
     * @param intArray : Array to be searched in the example is an integer array.
     * @param leftPosition: Left most position index
     * @param rightPosition: right position index
     * @param itemToFind: Desired item to find.
     * @return index position of the desired item, -1 if not found in the array.
     */
    public static int terSearch(int[] intArray, int leftPosition, int rightPosition, int itemToFind) {
        if(intArray[leftPosition] == itemToFind)
        {
            return leftPosition;
        }
        if(intArray[rightPosition] == itemToFind)
        {
            return rightPosition;
        }
        if (rightPosition >= 1)
        {
            int directionOne = leftPosition + ((rightPosition - leftPosition) / 3);
            int directionTwo = directionOne + ((rightPosition - leftPosition) / 3);

            if (intArray[directionOne] == itemToFind) {
                return directionOne;
            }
            if (intArray[directionTwo] == itemToFind) {
                return directionTwo;
            }

            if (intArray[directionOne] > itemToFind) {
                return terSearch(intArray, leftPosition, directionOne - 1, itemToFind);
            }
            if (intArray[directionTwo] < itemToFind) {
                return terSearch(intArray, directionTwo + 1, rightPosition, itemToFind);
            }
        }
        return NOT_FOUND;

    }
}