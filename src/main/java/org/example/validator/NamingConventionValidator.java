package org.example.validator;

import org.example.util.ReflectionUtil;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author sksingh created on 07/01/24
 */
public class NamingConventionValidator {

    /**
     * Some examples of valid class names:
     * <p>
     * com.example.MyClass     *
     * _MyClass
     * $SomeClass
     * <p>
     * Some invalid examples:
     * <p>
     * 1MyClass (can't start with number)
     * My Class (no spaces allowed)
     */
    private static final Pattern CLASS_NAME_PATTERN =
            Pattern.compile("([a-zA-Z_$][a-zA-Z\\\\d_$]*\\\\.)*[a-zA-Z_$][a-zA-Z\\\\d_$]*");
    /**
     * The regex used checks:
     * <p>
     * Must start with a lowercase letter
     * Can contain letters, numbers, underscores after first character
     * Some examples of valid method names:
     * <p>
     * getUser
     * calculateTotal
     * _processData
     * <p>
     * Some invalid examples:
     * <p>
     * 1calculate (can't start with number)
     * GetUser (must start lowercase)
     * <p>
     * Some best practices for method name validation:
     * <p>
     * Start with lowercase letter
     * Use camelCase notation
     * No spaces or special characters besides _
     * Use verb or verb phrase names for methods
     * Use nouns for getters and setters
     * Avoid overly long names
     */
    private static final Pattern METHOD_NAME_PATTERN = Pattern.compile("[a-z][a-zA-Z0-9_]*");

    public static void validateNamingConventions(String basePackage) {
        Set<Class<?>> allClasses = ReflectionUtil.getAllClasses(basePackage);

        String className, methodName;
        for (Class<?> clazz : allClasses) {
            className = clazz.getSimpleName();
            if (!CLASS_NAME_PATTERN.matcher(className).matches()) {
                throw new RuntimeException(String.format("Invalid class name: %s", className));
            }

            List<Method> methods = ReflectionUtil.getDeclaredMethods(clazz);
            for (Method method : methods) {
                methodName = method.getName();
                if (!METHOD_NAME_PATTERN.matcher(methodName).matches()) {
                    throw new RuntimeException(
                            String.format("Invalid method: %s name in class: %s", methodName, className));
                }
            }
        }
    }
}
