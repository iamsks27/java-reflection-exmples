package org.example;

import org.example.model.Person;
import org.example.util.ReflectionUtil;

import java.util.Set;

/**
 * @author sksingh created on 05/01/24
 */
public class Main {

    public static void main(String[] args) {

        Set<Class<?>> allClassesInPackage =
                ReflectionUtil.getAllClasses("org.example.model");

        for (Class<?> clazz : allClassesInPackage) {
            System.out.printf("Class: %s is present in the given package%n", clazz.getSimpleName());
        }

        System.out.println("---------------------------------------");

        Set<Class<? extends Person>> subClassesInPackage =
                ReflectionUtil.getSubClassesOf("org.example.model", Person.class);

        for (Class<? extends Person> clazz : subClassesInPackage) {
            System.out.printf("Class: %s is sub class of %s%n", clazz.getSimpleName(), Person.class.getSimpleName());
        }
    }
}