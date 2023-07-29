package Generics.bounding;
/*
Upper Bounded Wildcards
You can use an upper bounded wildcard to relax the restrictions on a variable. For example, say you want to
write a method that works on List<Integer>, List<Double>, and List<Number>; you can achieve this by using an upper
bounded wildcard.

To declare an upper-bounded wildcard, use the wildcard character ('?'), followed by the extends keyword, followed by
its upper bound. Note that, in this context, extends is used in a general sense to mean either "extends" (as in classes)
or "implements" (as in interfaces).

To write the method that works on lists of Number and the subtypes of Number, such as Integer, Double, and Float,
you would specify List<? extends Number>. The term List<Number> is more restrictive than List<? extends Number>
because the former matches a list of type Number only, whereas the latter matches a list of type Number or any of its
subclasses.


Below is using upperBound in generic class.... Number will be used for upper bound for numbers String will not be able to
be used with numbers abstract class.
 */
public class GenericUpperBounding <T extends Number>{// setting boundary from upper
    // we can only use sub-class of of Number.
    // With -> Number you can use any number data type such as Integer, Double, Float, Long but if you
    // replace number with Integer this will give you a compile time error for double and any data type other than Integer.
    //
    private T[] numberArray;

    public GenericUpperBounding(T[] numberArray) {
        this.numberArray = numberArray;
    }
        // create a method() find the average of an array

        public double getAverage(){
            double sum=0;
            for(T t: numberArray){
                sum+=t.doubleValue();
            }
            double avg = sum/numberArray.length;
            return avg;

        }

    public static void main(String[] args) {
        Integer [] intArr = {2,4,5,6,7,8,9};
        GenericUpperBounding<Integer> obj1 = new GenericUpperBounding<>(intArr);
        System.out.println(obj1.getAverage());

        Double [] doubleArr = {2.4,4.25,5.7,8.9,10.9};
        GenericUpperBounding<Double> obj2 = new GenericUpperBounding<>(doubleArr);
        System.out.println(obj2.getAverage());

        String [] strArr = {"Ali","Song","Lee","Jim"};
        //GenericUpperBounding<String> obj3 = new GenericUpperBounding<String>(strArr); // will save us from RTE -> Runtime Error
        // Also from Typecasting.

    }

    }

