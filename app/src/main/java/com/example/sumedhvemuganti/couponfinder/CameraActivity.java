package com.example.sumedhvemuganti.couponfinder;

import android.Manifest;
import android.app.Activity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.hardware.camera2.*;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;



public class CameraActivity extends Activity {

    private String cameraId;
    protected CameraDevice cameraDevice;

    private final CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(CameraDevice camera) {
            //This is called when the camera is open
            cameraDevice = camera;
            //createCameraPreview();
        }
        @Override
        public void onDisconnected(CameraDevice camera) {
            cameraDevice.close();
        }
        @Override
        public void onError(CameraDevice camera, int error) {
            cameraDevice.close();
            cameraDevice = null;
            System.out.println("error");
        }
    };
protected void onCreate(Bundle bundle)
{
    super.onCreate(bundle);
    setContentView(R.layout.camera_main);
    //ActivityCompat.requestPermissions(AndroidCameraApi.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CAMERA_PERMISSION);
    System.out.print("Camera Activity");
    final Context context= this;
    if (checkCameraHardware(context))
    {
       // getCameraInstance();
    }

    android.hardware.camera2.CameraManager manager = (CameraManager) (this.getSystemService(Context.CAMERA_SERVICE));
    try
    {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            String[] arr = manager.getCameraIdList();
            manager.openCamera(arr[0], stateCallback, null);
            System.out.print("fukfguk");

            // This is a comment
        }

    }
    catch(Exception e)
    {

    }



}

    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            //c = Camera.takePicture(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }





    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

}
