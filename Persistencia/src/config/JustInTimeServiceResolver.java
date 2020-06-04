package config;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.glassfish.hk2.api.ActiveDescriptor;
import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.JustInTimeInjectionResolver;
import org.jvnet.hk2.annotations.Service;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.jvnet.hk2.annotations.Contract;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

@Service
public class JustInTimeServiceResolver implements JustInTimeInjectionResolver {

	@Inject
	private ServiceLocator serviceLocator;

	private String packageScan = "";
	
	@Override
	public boolean justInTimeResolution(Injectee injectee) {
		final Type requiredType = injectee.getRequiredType();

		if (injectee.getRequiredQualifiers().isEmpty() && requiredType instanceof Class) {
			final Class<?> requiredClass = (Class<?>) requiredType;
			if (requiredClass.getName().startsWith(packageScan)) {
				final List<ActiveDescriptor<?>> descriptors = new ArrayList<>();
				if(requiredClass.isAnnotationPresent(Contract.class)) {
					Set<Class<?>> classes =  getReflections().getSubTypesOf(((Class) requiredClass));
                    for(Class subClass : classes) {
                        descriptors.addAll(ServiceLocatorUtilities.addClasses(serviceLocator, subClass));
                    }
                } else {
                	descriptors.addAll(ServiceLocatorUtilities.addClasses( serviceLocator, requiredClass ));
                }
				if (!descriptors.isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}

	 public Reflections getReflections() {
		 List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
		 classLoadersList.add(ClasspathHelper.contextClassLoader());
		 classLoadersList.add(ClasspathHelper.staticClassLoader());
		 return new Reflections(new ConfigurationBuilder()
				    .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
				    .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
				    .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(packageScan))));
	 }

}