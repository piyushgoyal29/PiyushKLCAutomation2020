package utils;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class IAnnotationTransformerClass implements IAnnotationTransformer
{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) 
	{
		annotation.setRetryAnalyzer(IRetryAnalyzerClass.class);	
		//Here inside setRetryAnalyzer() method, we have to pass the name of the class 
		//which implements the IRetryAnalyzer interface.		
	}

}
