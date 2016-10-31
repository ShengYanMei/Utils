    
	// 网络请求及SDCard读写请求
	
	// 在Android Mainfest中首先定义permission
	
	<uses-permission-sdk-23 android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission-sdk-23 android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission-sdk-23 android:name="android.permission.INTERNET"/>
		
	// android 23 以上，网络请求代码，粘贴至MainActivity 后面即可
	private final static int MY_PERMISSION_REQUEST = 1;
    // sdcard请求
    public void requestSDCardPermission(){
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSION_REQUEST);
            }
        }
    }

    // 读取存储卡请求响应，Android 23 以上
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }

    }
