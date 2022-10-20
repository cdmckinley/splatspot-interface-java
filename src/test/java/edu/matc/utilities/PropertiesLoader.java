package edu.matc.utilities;

import java.util.*;

/**
 * This interface contains a default method that can be used anywhere a Properties
 * object is needed to be loaded.
 * @author Eric Knapp
 *
 * Modified by Craig McKinley, to throw exceptions instead of printing their stack trace
 *
 */
public interface PropertiesLoader{

    /**
     * This default method will load a properties file into a Properties instance
     * and return it.
     * @param propertiesFilePath a path to a file on the java classpath list
     * @return a populated Properties instance or an empty Properties instance if
     * the file path was not found.
     */
    default Properties loadProperties(String propertiesFilePath) throws Exception{
        Properties properties = new Properties();

        properties.load(this.getClass().getResourceAsStream(propertiesFilePath));

        return properties;
    }
}
