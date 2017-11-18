# jollyday-android
This library is an adaption of the [Jollyday](https://github.com/svendiedrichsen/jollyday) for the Android platform. Just like the original library, it can be used to determine the local holidays for different countries and regions.

The functionality of both libraries are the same. However, some parts have been rewritten, as Jollyday makes use of certain third-party libraries and technologies, which are not compatible with the Android platform. More specifically, [JAXB](https://jaxb.java.net/) has been replaced with [Simple XML](http://simple.sourceforge.net/) and the usage of the Java Beans Introspector has been avoided.   

## Usage

The library can be easily included in Gradle using
```groovy
compile 'de.galgtonold.jollydayandroid:jollyday-android:0.1.8'
```
Afterwards all the functionality is available just as in the original library, with the exception that a different package is used. For instance the set of holidays from New York in the year 2010 can be obtained in the following way.
```java
        HolidayManager m = HolidayManager.getInstance(HolidayCalendar.UNITED_STATES);
        Set<Holiday> holidays = m.getHolidays(2010, "ny");
```
A small android example project displaying a list of holidays can be found in the directory jollyday-android-example.
More usage details can be found in the [documentation of the original project](http://jollyday.sourceforge.net/usage.html).

## ProGuard

Using ProGuard might lead to warning in the compilation process. Those can be eliminated using
```java
-keepattributes EnclosingMethod
-keepattributes InnerClasses
```