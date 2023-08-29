package RoughWork;

import Vehicles.*;

import java.lang.reflect.Field;

public class ReflectionApi {

    public static void main(String[] args) {

        Motorcycles m = new Motorcycles();

        m.setBikeName("ninja");
        m.setVIN("1234");
        m.setKeyLocks("2");
        m.setRegistration("texas");


        m.getBikeName();




        V v = new V();

        System.out.println(v.getClass());

        Field[] fields = v.getClass().getDeclaredFields();

        for (Field field : fields){
            System.out.println("- "+field.getName());
        }

        int a = 10, b= 312334234;

        try {
                System.out.println(a/0);
        } catch (ArithmeticException ae) {
            ae.printStackTrace();
        } catch (NullPointerException ne) {
            ne.printStackTrace();
        } catch (ClassCastException ce) {
            ce.printStackTrace();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("I will execute anyway");
        }

        if (b==0){
            throw new ArithmeticException("divided by zero");
        }


        /*                      Types of Exceptions
                                            Object
                                                |
                                     throwable superclass
                                               |
                           ______________subclasses of throwable_______________
                          |                                                    |
                    Exceptions                                               error
                          |                                                    |
         ________________________________________                             ___________________
        |                                       |                                    |
 checked (compile time)exception     unchecked (runtime)exception              - stack overflow error
        - file not found exep            - null pointer                        - virtual Machine error
        - i/o exceptions                 - arithmetic                          - out of memory error
        - sql exceptions                 - Index out of bound
        - class not found                        - array out of bounds
                                                 - String out of index bounds
                                         - number format exceptions



        * */

    }
}
