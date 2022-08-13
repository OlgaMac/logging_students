package ru.aston.logging_students;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.aston.logging_students.config.MyConfig;

public class Application extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class[] getServletConfigClasses() {
        return new Class[] {MyConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class[] getRootConfigClasses() {
        return new Class[] {};
    }
}
