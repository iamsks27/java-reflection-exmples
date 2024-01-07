package org.example.util;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.util.Set;

/**
 * @author sksingh created on 05/01/24
 */
public class ReflectionUtil {

    public static Set<Class<?>> getAllClasses(String basePackage) {
        Reflections reflections =
                // FilterResultBy => NO filter
                new Reflections(basePackage, Scanners.SubTypes.filterResultsBy(c -> true));

        return reflections.getSubTypesOf(Object.class);
    }

    public static <T> Set<Class<? extends T>> getSubClassesOf(String basePackage, Class<T> clazz) {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder()
                .forPackage(basePackage);
        Reflections reflections = new Reflections(configurationBuilder);

        return reflections.getSubTypesOf(clazz);
    }
}
