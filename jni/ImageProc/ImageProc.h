#include <jni.h>
#include <android/log.h>
#include <android/bitmap.h>

#include <string.h>

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

#include <fcntl.h>              /* low-level i/o */
#include <unistd.h>
#include <errno.h>
#include <malloc.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <sys/time.h>
#include <sys/mman.h>
#include <sys/ioctl.h>

#include <asm/types.h>          /* for videodev2.h */

#include <linux/videodev2.h>

#define  LOG_TAG    "DoubleWebCam"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

#define abs_mcr(x) ((x)>0 ? (x) : -(x))


#define CLEAR(x) memset (&(x), 0, sizeof (x))
#define CAMERANUM 1

struct buffer {
        void *                  start;
        size_t                  length;
};


static int camerabase=-1;
static char            dev_name[16];
static int              fd              = {-1,-1};
struct buffer *         buffers         = {NULL,NULL};
static unsigned int     n_buffers       = {0,0};

int *rgb = NULL;
int *ybuf = NULL;

#define IMG_WIDTH 1280
#define IMG_HEIGHT 720

#define ERROR_LOCAL -1
#define SUCCESS_LOCAL 0


int errnoexit(const char *s);

int xioctl(int fd, int request, void *arg);

int opendevice(int videoid);
int initdevice(void);
int initmmap(void);
int startcapturing(void);

int readframeonce(int processcamera);
int readframe(void);
void processimage (int camid, const void *p, int l);

int stopcapturing(void);
int uninitdevice(void);
int closedevice(void);

//void Java_com_pupil_pupil_mobile_capture_CaptureDevice_pixeltobmp(JNIEnv* env,jobject thiz, jobject bitmap1, jobject bitmap2);
jint Java_com_pupil_pupil_1mobile_capture_CaptureDevice_prepareCamera(JNIEnv* env,jobject thiz, jint videoid);
//jint Java_com_pupil_mobile_capture_CaptureDevice_prepareCameraWithBase(JNIEnv* env,jobject thiz, jint videoid, jint videobase);
//void Java_com_pupil_pupil_mobile_capture_CaptureDevice_processCamera(JNIEnv* env,jobject thiz,jint videoid);
//void Java_com_pupil_pupil_mobile_capture_CaptureDevice_stopCamera(JNIEnv* env,jobject thiz);
//void Java_com_pupil_pupil_mobile_capture_CaptureDevice_processRBCamera(JNIEnv* env,jobject thiz, jint lrmode);
