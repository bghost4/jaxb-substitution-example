#Substituiton Example

####uses java 17 (openjdk) and Gradle 7.2

This project marks a difficulty I am having with the JAXB-Substitution plugin

###Problem #1
####getters and setters for Substituted fields are lowercase:

ex: Garage.getvehicle 
should be Garage.getVehicle()

###Problem #2 
####Running main class gives IllegalAnnotationException:

    BUILD SUCCESSFUL in 596ms
    4 actionable tasks: 1 executed, 3 up-to-date
    com.sun.xml.bind.v2.runtime.IllegalAnnotationsException: 1 counts of IllegalAnnotationExceptions
    Invalid @XmlElementRef : Type "class com.example.sub.VehicleType" or any of its subclasses are not known to this context.
    this problem is related to the following location:
    at protected java.util.List com.example.sub.GarageType.vehicle
    at com.example.sub.GarageType
    at public com.example.sub.GarageType com.example.sub.ObjectFactory.createGarageType()
    at com.example.sub.ObjectFactory
    
        at com.sun.xml.bind.v2.runtime.IllegalAnnotationsException$Builder.check(IllegalAnnotationsException.java:106)
        at com.sun.xml.bind.v2.runtime.JAXBContextImpl.getTypeInfoSet(JAXBContextImpl.java:471)
        at com.sun.xml.bind.v2.runtime.JAXBContextImpl.<init>(JAXBContextImpl.java:303)
        at com.sun.xml.bind.v2.runtime.JAXBContextImpl.<init>(JAXBContextImpl.java:139)
        at com.sun.xml.bind.v2.runtime.JAXBContextImpl$JAXBContextBuilder.build(JAXBContextImpl.java:1156)
        at com.sun.xml.bind.v2.ContextFactory.createContext(ContextFactory.java:165)
        at com.sun.xml.bind.v2.ContextFactory.createContext(ContextFactory.java:289)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:568)
        at javax.xml.bind.ContextFinder.newInstance(ContextFinder.java:217)
        at javax.xml.bind.ContextFinder.newInstance(ContextFinder.java:175)
        at javax.xml.bind.ContextFinder.find(ContextFinder.java:353)
        at javax.xml.bind.JAXBContext.newInstance(JAXBContext.java:508)
        at javax.xml.bind.JAXBContext.newInstance(JAXBContext.java:465)
        at javax.xml.bind.JAXBContext.newInstance(JAXBContext.java:366)
        at com.derpderphurr.Example.main(Example.java:17)