
public class RecursiveSearch {
    static final int NOT_FOUND = -1;

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int index = terSearch(numbers, 0, numbers.length - 1, 4);
        System.out.println(index);
    }

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