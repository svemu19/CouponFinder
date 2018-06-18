package com.example.sumedhvemuganti.couponfinder;

import android.Manifest;
import android.app.Activity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.*;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

public class CameraActivity extends Activity {

protected void onCreate(Bundle bundle)
{
    super.onCreate(bundle);
    setContentView(R.layout.camera_main);
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
            manager.openCamera(arr[0], null, null);
            // This is a comment
        }

    }
    catch(Exception e)
    {

    }


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
