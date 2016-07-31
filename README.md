# jollyday-android
This library is an adaption of the [Jollyday](https://github.com/svendiedrichsen/jollyday) for the Android platform. Just like the original library, it can be used to determine the local holidays for different countries and regions.

The functionality of both libraries are the same. However, some parts have been rewritten, as Jollyday makes use of certain third-party libraries and technologies, which are not compatible with the Android platform. More specifically, [JAXB](https://jaxb.java.net/) has been replaced with [Simple XML](http://simple.sourceforge.net/) and the usage of the Java Beans Introspector has been avoided.  
