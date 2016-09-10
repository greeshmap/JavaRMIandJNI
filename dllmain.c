/* Replace "dll.h" with the name of your header */
#include "dllheader.h"
#include <windows.h>
#include <stdio.h>

/*DLLIMPORT void HelloWorld()
{
	MessageBox(0,"Hello World from DLL!\n","Hi",MB_ICONINFORMATION);
}*/

BOOL WINAPI DllMain(HINSTANCE hinstDLL,DWORD fdwReason,LPVOID lpvReserved)
{
	switch(fdwReason)
	{
		case DLL_PROCESS_ATTACH:
		{
			break;
		}
		case DLL_PROCESS_DETACH:
		{
			break;
		}
		case DLL_THREAD_ATTACH:
		{
			break;
		}
		case DLL_THREAD_DETACH:
		{
			break;
		}
	}
	
	/* Return TRUE on success, FALSE on failure */
	return TRUE;
}



JNIEXPORT jobject JNICALL Java_CmdRegisterImpl_getlocaltime
  (JNIEnv *env, jobject obj1, jobject obj2)
  {
	jfieldID fieldId,fieldid2;jchar ch;
    time_t tym;int sec;
    struct timeval tv;
    srand((unsigned) time(&tym));
    gettimeofday(&tv, NULL); 
    sec = tv.tv_sec;
    jclass mycls = (*env)->GetObjectClass(env, obj2);
    fieldId = (*env)->GetFieldID(env, mycls, "time", "I");
    jint num=(*env)->GetIntField(env, obj2, fieldId);
    num=sec; 
    (*env)->SetIntField(env, obj2, fieldId, num);
  	return obj2;
  }

JNIEXPORT jobject JNICALL Java_CmdRegisterImpl_getversion
  (JNIEnv *env, jobject obj1, jobject obj2)
  {
  jfieldID fieldId;
  jclass mycls = (*env)->GetObjectClass(env, obj2);
  fieldId = (*env)->GetFieldID(env, mycls, "version", "I");
  
  jint i=(*env)->GetIntField(env, obj2, fieldId);
		i=3;
  (*env)->SetIntField(env, obj2, fieldId, i);
    
  	return obj2;
  }
