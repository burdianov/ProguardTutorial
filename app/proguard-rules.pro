# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\Lilian\AppData\Local\Android\Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
-renamesourcefileattribute AnyWord

-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn retrofit2.**

# keep class members one by one
#-keep public class com.crackncrunch.proguardtutorial.response.PersonResponse {
#    java.lang.String name;
#    java.lang.String secondName;
#    int age;
#}

##### keep all class members
#-keep public class com.crackncrunch.proguardtutorial.response.PersonResponse2 {
#    *;
#}

##### keep interface BaseResponse and all the class members of the classes
##### which implement it
#-keep class com.crackncrunch.proguardtutorial.BaseResponse
#-keepclassmembers class * implements com.crackncrunch.proguardtutorial.BaseResponse {<fields>;}

##### keep all the classes inside the response package
-keepclassmembers class com.crackncrunch.proguardtutorial.response.* {<fields>;}

-keepnames class * implements java.io.Serializable
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}