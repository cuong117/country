#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_myapp_country_convert_Secret_gk(
        JNIEnv* env,
        jobject /* this */) {
    std::string k = "tSmbZ0bbHnXefc37";
    return env->NewStringUTF(k.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_myapp_country_convert_Secret_iv(
        JNIEnv* env,
        jobject /* this */) {
    std::string k = "YUtlpkLt5Tr9Ppoo";
    return env->NewStringUTF(k.c_str());
}