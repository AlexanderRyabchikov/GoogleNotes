-optimizationpasses 5
-dontskipnonpubliclibraryclasses
-allowaccessmodification
-dontpreverify
-dontobfuscate

# Retrofit 2.X
-dontwarn retrofit2.**
-dontnote retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

# OkHttp
-keepattributes Signature
-keepattributes *Annotation*
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
-dontnote okhttp3.**


# okio
-keep class sun.misc.Unsafe { *; }
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn okio.**
-dontnote okio.**

-keep public class com.google.android.gms.* { public *; }
-dontwarn com.google.android.gms.**

-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}

-keepclassmembers class android.support.design.internal.BottomNavigationMenuView {
    boolean mShiftingMode;
}

-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
   long producerIndex;
   long consumerIndex;
}

-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}

-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

-dontnote rx.internal.util.PlatformDependent

-dontnote pl.droidsonroids.**, io.reactivex.**

-dontwarn **$$Lambda$*

# di
-keep class javax.inject.**
-keep class **$$Factory{ *; }
-keep class **$$MemberInjector{ *; }
-keepclasseswithmembernames class * { @javax.inject.Inject <init>(...); }
-keepclasseswithmembernames class * { @javax.inject.Inject <fields>; }
-keepclasseswithmembernames class * { @javax.inject.Inject <methods>; }
-dontwarn com.google.errorprone.annotations.**

# prevent any notes
-dontnote **

-keep class com.client.client.**
-keep @com.client.client.** class * { *; }
-dontwarn com.client.**

# Crashlytics
# https://firebase.google.com/docs/crashlytics/get-deobfuscated-reports
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception

-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**

-dontwarn org.xmlpull.v1.**
-keep class org.xmlpull.v1.** { *; }

##---------------Begin: proguard configuration for Gson  ----------
# Gson specific classes
-dontwarn sun.misc.**
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

##---------------End: proguard configuration for Gson  ----------

-keep public enum * {*; }
-keepclassmembers enum * { *; }
-keep class com.client.core.data.models.request.** { *; }