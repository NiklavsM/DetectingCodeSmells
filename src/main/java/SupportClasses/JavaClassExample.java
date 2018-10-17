package SupportClasses;//Mike Scott
//examples of array manipulations

public class JavaClassExample {
    enum options {
        ENUM1, ENUM2;
    }

    public static void main(String[] args) {
    }


//{	int[] list = {1, 2, 3, 4, 1, 2, 3};
//    findAndPrintPairs(list, 5);
//    bubblesort(list);
//    showList(list);
//
//    list = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
//    bubblesort(list);
//    showList(list);
//
//    list = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2};
//    bubblesort(list);
//    showList(list);
//
//    list = new int[]{1};
//    bubblesort(list);
//    showList(list);
//}
//
//
//    // pre: list != null, list.length > 0
//    // post: return index of minimum element of array
//    public static int findMin(int[] list)
//    {	assert list != null && list.length > 0 : "failed precondition";
//
//        int indexOfMin = 0;
//        for(int i = 1; i < list.length; i++)
//        {	if(list[i] < list[indexOfMin])
//        {	indexOfMin = i;
//        }
//        }
//
//        return indexOfMin;
//    }
//
//
//    /*
//     *pre: list != null, newSize >= 0
//     *post: nothing. the method does not succeed it resizing the
//     * argument
//     */
//    public static void badResize(int[] list, int newSize)
//    {	assert list != null && newSize >= 0 : "failed precondition";
//
//        int[] temp = new int[newSize];
//        int limit = Math.min(list.length, newSize);
//
//        for(int i = 0; i < limit; i++)
//        {	temp[i] = list[i];
//        }
//
//        // uh oh!! Changing pointer, not pointee. This breaks the
//        // relationship between the parameter and argument
//        list = temp;
//    }
//
//
//    /*
//     *pre: list != null, newSize >= 0
//     *post: returns an array of size newSize. Elements from 0 to newSize - 1
//     *	will be copied into the new array
//     */
//    public static int[] goodResize(int[] list, int newSize)
//    {	assert list != null && newSize >= 0 : "failed precondition";
//
//        int[] result = new int[newSize];
//        int limit = Math.min(list.length, newSize);
//
//        for(int i = 0; i < limit; i++)
//        {	result[i] = list[i];
//        }
//
//        return result;
//    }
//
//
//    /*
//     *pre: list != null
//     *post: prints out the indices and values of all pairs of numbers
//     *in list such that list[a] + list[b] = target
//     */
//    public static void findAndPrintPairs(int[] list, int target)
//    {	assert list != null : "failed precondition";
//
//        for(int i = 0; i < list.length; i++)
//        {	for(int j = i + 1; j < list.length; j++)
//        {	if(list[i] + list[j] == target)
//        {	System.out.println("The two elements at indices " + i + " and " + j
//                + " are " + list[i] + " and " + list[j] + " add up to " + target);
//        }
//        }
//        }
//    }
//
//
//    /*
//     *pre: list != null;
//     *post: sort the elements of list so that they are in ascending order
//     */
//    public static void bubblesort(int[] list)
//    {
//        assert list != null : "failed precondition";
//
//        int temp;
//        boolean changed = true;
//        for(int i = 0; i < list.length && changed; i++)
//        {	changed = false;
//            for(int j = 0; j < list.length - i - 1; j++)
//            {	assert (j > 0) && (j + 1 < list.length) : "loop counter j " + j +
//                    "is out of bounds.";
//                if(list[j] > list[j+1])
//                {	changed = true;
//                    temp = list[j + 1];
//                    list[j + 1] = list[j];
//                    list[j] = temp;
//                }
//            }
//        }
//
//        assert isAscending( list );
//    }
//
//
//    public static void showList(int[] list)
//    {	for(int i = 0; i < list.length; i++)
//        System.out.print( list[i] + " " );
//        System.out.println();
//    }
//
//    /* 	pre: list != null
//        post: return true if list is sorted in ascedning order, false otherwise
//    */
//    public static boolean isAscending( int[] list )
//    {	boolean ascending = true;
//        int index = 1;
//        while( ascending && index < list.length )
//        {	assert index >= 0 && index < list.length;
//
//            ascending = (list[index - 1] <= list[index]);
//            index++;
//        }
//
//        return ascending;
//    }


//    class MethodClassTest {
//        int test = 324;
//
//        public void test() {
//            if (true) {
//                test = 1;
//                test = 2;
//                test = 3;
//            } else {
//                test = 1;
//                test = 2;
//                test = 3;
//            }
//            if (true) {
//                test = 1;
//            }
//            for (int i = 0; i < 10; i++) {
//                test = 4;
//            }
//            switch (test) {
//                case 1:
//                    test = 2;
//                case 2:
//                    test = 1;
//            }
//         class InsideClass {
//             int test = 200;
//
//             public void opaa() {
//                 test = 100;
//             }
//         }
//         class InsideClass2 {
//             int test = 200;
//
//             public void opaa() {
//                 test = 100;
//             }
//         }
//        }
//    }

    //    class LongClassTest {
//        int test = 324;
//
//        public void test() {
//            if (true) {
//                test = 1;
//                test = 2;
//                test = 3;
//            }
//            if (true) {
//                test = 1;
//                test = 2;
//                test = 3;
//            }
//            class InsideClass {
//                int test = 200;
//
//                public void opaa() {
//                    test = 100;
//                }
//            }
//        }
//
//        public void test2() {
//            if (true) {
//                test = 1;
//                test = 2;
//                test = 3;
//            }
//            if (true) {
//                test = 1;
//                test = 2;
//                test = 3;
//            }
//            class InsideClass2 {
//                int test = 200;
//
//                public void opaa() {
//                    test = 100;
//                }
//            }
//        }
//    }
//    class SwitchNoEnumTest {
//        int test = 324;
//
//        public void test() {
//            if (true) {
//                test = 1;
//                test = 2;
//                test = 3;
//            } else {
//                test = 1;
//                test = 2;
//                test = 3;
//            }
//            if (true) {
//                test = 1;
//            }
//            class InsideClass {
//                int test = 200;
//                String switchVariable = "Test";
//
//                public void opaa() {
//                    test = 100;
//
//                    switch (switchVariable) {
//                        case ("Test"):
//                            test = 101;
//
//                        case ("asdasd"):
//                            test = 102;
//
//                    }
//                }
//            }
//            class InsideClass2 {
//                int test = 200;
//
//                public void opaa() {
//                    test = 100;
//                }
//            }
//        }
//    }
//    class SwitchEnumTest {
//
//        int test = 324;
//
//        public void test() {
//            if (true) {
//                test = 1;
//                test = 2;
//                test = 3;
//            } else {
//                test = 1;
//                test = 2;
//                test = 3;
//            }
//            if (true) {
//                test = 1;
//            }
//            class InsideClass {
//
//
//                int test = 200;
//                options switchVariable, switchVariable2 = options.ENUM1;
//
//                public void opaa() {
//                    test = 100;
//
//                    switch (switchVariable) {
//                        case ENUM1:
//                            test = 101;
//
//                        case ENUM2:
//                            test = 102;
//
//                    }
//                    switch (switchVariable2) {
//                        case ENUM1:
//                            test = 101;
//
//                        case ENUM2:
//                            test = 102;
//
//                    }
//                }
//            }
//            class InsideClass2 {
//                int test = 200;
//
//                public void opaa() {
//                    test = 100;
//                }
//            }
//        }
//    }

//    class DataClass{
//
//        int data1 = 0;
//
//        public DataClass(int int1,int int2,int int3,int int4,int int5,int int6){
//
//        }
//
//        public int getData1() {
//            System.out.println("someother stuff");
//            return data1;
//        }
//
//        public void setData1(int data1) {
//            this.data1 = data1;
//        }
//
//    }

//    class PrimitiveObsession {
//        int i1;
//        int i2 = 0;
//        int i3 = 0;
//        int i4 = 0;
//        int i5 = 0;
//        int i6 = 0;
//        int i7 = 0;
//        int i8 = 0;
//        int i9 = 0;
//        int i10 = 0;
//        int i11 = 0;
//
//        public void testMethod() {
//            ArrayList notPrimitive;
//            boolean bool1 = true;
//            boolean bool2, bool3, bool4, bool5, bool6, bool7 = true;
//            boolean bool8;
//            boolean bool9;
//            boolean bool10;
//            boolean bool11;
//            if(bool1){
//                int int1 = 1;
//            }
//
//        }
//    }

    class MessageChainTest {
        class FirstClass {
            String string1 = "Test";

            public FirstClass() {
                test1();
            }

            public void test1() {
                boolean b;
                b = string1.toString().toString().toString().equals("asd");
            }
        }
    }

}
