//
// Created by jeremy on 12/6/2020.
//

#include <jni.h>
#include <stdlib.h>

JNIEXPORT jint JNICALL Java_id_ac_ui_cs_mobileprogramming_jeremy_lab06_MainActivity_sumValues( JNIEnv* env, jobject obj,jint a, jint b){

    return a+b;
 }