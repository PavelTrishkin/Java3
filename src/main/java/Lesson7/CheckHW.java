package Lesson7;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckHW {
    public static void main(String[] args) throws Exception {
        check();
    }

    public static void check() throws Exception {
        File file = new File("C:/123");
        String[] str = file.list();

        for (String o : str) {
            String[] mass = o.split("\\.");
            if (!mass[1].equalsIgnoreCase("class")) {
                throw new RuntimeException(o, new Exception());
            }

            Class ch = URLClassLoader.newInstance(new URL[]{file.toURL()}).loadClass(mass[0]);
            Object object = mass[0].split(".class");
            ArrayList<Method> methods = methods(ch);

            System.out.println(Arrays.toString((Object[]) object));

            testMethodOne(methods, object);
            testMethodTwo(methods, object);
            testMethodThree(methods, object);
            testMethodFour(methods, object);
            testMethodFive(methods, object);
            System.out.println();

        }
    }

    /*
     * Сортировка методов
     */
    public static ArrayList<Method> methods(Class ch) {
        Method[] methods = ch.getDeclaredMethods();
        ArrayList<Method> methods1 = new ArrayList<>();
        for (Method o : methods) {
            if (!o.getGenericReturnType().getTypeName().equalsIgnoreCase("void")) {
                methods1.add(o);
            }
        }
        return methods1;
    }

    /*
     * Тестирование методов, при условии что заранее знаем что они должны делать,
     * и какое кол-во аргументов требуется.
     */
    public static void testMethodOne(ArrayList<Method> methods, Object obj) throws Exception {
        int varOne = 1;
        methods.get(0).setAccessible(true);
        boolean bol = (boolean) methods.get(0).invoke(obj, varOne);

        if (bol == true) {
            System.out.println(methods.get(0) + ": Задание выполнено не верно");
        } else {
            System.out.println(methods.get(0) + ": Задание выполнено верно");
        }
    }

    public static void testMethodTwo(ArrayList<Method> methods, Object obj) throws Exception {
        float varOne = 1.0f;
        float varTwo = 2.0f;
        float varThree = 3.0f;
        float varFour = 4.0f;

        methods.get(1).setAccessible(true);
        float result = (float) methods.get(1).invoke(obj, varOne, varTwo, varThree, varFour);

        if (result != 2.75) {
            System.out.println(methods.get(1) + ": Задание выполнено не верно");
        } else {
            System.out.println(methods.get(1) + ": Задание выполнено верно");
        }
    }

    public static void testMethodThree(ArrayList<Method> methods, Object obj) throws Exception {
        int varOne = 1;
        int varTwo = 2;
        int varThree = 3;
        int varFour = 4;

        methods.get(2).setAccessible(true);
        int result = (int) methods.get(2).invoke(obj, varOne, varTwo, varThree, varFour);

        if (result != 2) {
            System.out.println(methods.get(2) + ": Задание выполнено не верно");
        } else {
            System.out.println(methods.get(2) + ": Задание выполнено верно");
        }
    }

    public static void testMethodFour(ArrayList<Method> methods, Object obj) throws Exception {
        int varThree = 3;
        int varFour = 4;

        methods.get(3).setAccessible(true);
        boolean bol = (boolean) methods.get(3).invoke(obj, varThree, varFour);

        if (bol == true) {
            System.out.println(methods.get(0) + ": Задание выполнено не верно");
        } else {
            System.out.println(methods.get(0) + ": Задание выполнено верно");
        }

    }

    public static void testMethodFive(ArrayList<Method> methods, Object obj) throws Exception {
        int year = 1950;

        methods.get(4).setAccessible(true);
        boolean bol = (boolean) methods.get(4).invoke(obj, year);

        if (bol == true) {
            System.out.println(methods.get(4) + ": Задание выполнено не верно");
        } else {
            System.out.println(methods.get(4) + ": Задание выполнено верно");
        }

    }

}
