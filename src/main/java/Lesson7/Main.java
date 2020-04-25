package Lesson7;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {
        Class aClass = ClassForTest.class;
        Method[] methods = aClass.getDeclaredMethods();
        Object classForTest = aClass.newInstance();
        ArrayList<Method> testMethods = new ArrayList<>();
        Method afterSuite = null;
        Method beforeSuite = null;

        for (Method o: methods) {
            if (o.isAnnotationPresent(Test.class)){
                testMethods.add(o);
            }
            if (o.isAnnotationPresent(AfterSuite.class)){
                if(afterSuite == null){
                    afterSuite = o;
                }
                else throw new RuntimeException("Method with Annotation 'AfterSuite' is not one!");
            }
            if (o.isAnnotationPresent(BeforeSuite.class)){
                if(beforeSuite == null){
                    beforeSuite = o;
                }
                else throw new RuntimeException("Method with Annotation 'BeforeSuite' is not one!");
            }
            testMethods.sort(new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
                }
            });
        }

        if (beforeSuite != null){
            beforeSuite.invoke(classForTest);
        }
        for (Method o: testMethods) {

            o.invoke(classForTest);
        }
        if (afterSuite != null){
            afterSuite.invoke(classForTest);
        }
    }
}
