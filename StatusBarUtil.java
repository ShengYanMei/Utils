

// ״̬��������

// ״̬��͸�����������������״̬������

// step 1: layout.xml�ļ��У��趨theme����theme��style�ļ��У�һ��Ҫ����	<item name="android:windowTranslucentStatus">true</item>
// step 2: ��layout.xml�Ĳ��������У�����һ��layout�����£�

/*	example:
	<RelativeLayout
        android:id="@+id/ImageBackground"
        android:layout_width="match_parent"
        android:layout_height="290dp"				// ���ñ������ָ߶ȣ��Զ���
        android:background="@drawable/bg_photo3">	// ����Ĭ�ϱ���
    </RelativeLayout>
*/

// step 3: �ڶ�Ӧactivity�ж������·�������������͸��״̬�����ص��Ǻ����У������е����þ��ǣ�ʹ��relativeLayout���������״̬��

/**
 * ʹ״̬��͸��
 * <p>
 * ������ͼƬ��Ϊ�����Ľ���,��ʱ��ҪͼƬ��䵽״̬��
 *
 * @param activity ��Ҫ���õ�activity
 */
 private static void setTranslucent(Activity activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        // ����״̬��͸��
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // ���ø����ֵĲ����������״̬��
        RelativeLayout rootView = (RelativeLayout) activity.findViewById(R.id.ImageBackground);
        rootView.setFitsSystemWindows(true);
        rootView.setClipToPadding(true);
    }
}    

// step 4: ��onCreate()�����У�setcontentview()֮�󣬵���setTranslucent������



// ���ǣ��������裬������Щ�ֻ���״̬�����������˰�ɫ����״̬��������ĳ���ԭ������ɫ���÷������£�

// ���ҽ��������������״̬���ķ��������ϵõ����¹�����  source: 3D BoBo 

public class StatusBarUtil {

    public static void setDefaultStateBar(Activity activity){
        if(StatusBarLightMode(activity) == 0){
            setStatusBarColor(activity, R.color.black);
        }else{
            setStatusBarColor(activity, R.color.color_f9);
        }
    }


    /**
     * �޸�״̬��Ϊȫ͸��
     * @param activity
     */
    @TargetApi(19)
    public static void transparencyBar(Activity activity){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        } else
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window =activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * �޸�״̬����ɫ��֧��4.4���ϰ汾
     * @param activity
     * @param colorId
     */
    public static void setStatusBarColor(Activity activity,int colorId) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
//      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(colorId));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //ʹ��SystemBarTint��ʹ4.4�汾״̬����ɫ����Ҫ�Ƚ�״̬������Ϊ͸��
            transparencyBar(activity);
            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(colorId);
        }
    }

    /**
     *����״̬����ɫ����ͼ�꣬
     * ����4.4���ϰ汾MIUIV��Flyme��6.0���ϰ汾����Android
     * @param activity
     * @return 1:MIUUI 2:Flyme 3:android6.0
     */
    public static int StatusBarLightMode(Activity activity){
        int result=0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if(MIUISetStatusBarLightMode(activity.getWindow(), true)){
                result=1;
            }else if(FlymeSetStatusBarLightMode(activity.getWindow(), true)){
                result=2;
            }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                result=3;
            }
        }
        return result;
    }

    /**
     * ��֪ϵͳ����ʱ������״̬����ɫ����ͼ�ꡣ
     * ����4.4���ϰ汾MIUIV��Flyme��6.0���ϰ汾����Android
     * @param activity
     * @param type 1:MIUUI 2:Flyme 3:android6.0
     */
    public static void StatusBarLightMode(Activity activity,int type){
        if(type==1){
            MIUISetStatusBarLightMode(activity.getWindow(), true);
        }else if(type==2){
            FlymeSetStatusBarLightMode(activity.getWindow(), true);
        }else if(type==3){
            activity.getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }

    /**
     * ���MIUI��flyme��6.0���ϰ汾״̬����ɫ����
     */
    public static void StatusBarDarkMode(Activity activity,int type){
        if(type==1){
            MIUISetStatusBarLightMode(activity.getWindow(), false);
        }else if(type==2){
            FlymeSetStatusBarLightMode(activity.getWindow(), false);
        }else if(type==3){
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }

    }


    /**
     * ����״̬��ͼ��Ϊ��ɫ�������ض������ַ��
     * ���������ж��Ƿ�ΪFlyme�û�
     * @param window ��Ҫ���õĴ���
     * @param dark �Ƿ��״̬�����弰ͼ����ɫ����Ϊ��ɫ
     * @return  boolean �ɹ�ִ�з���true
     *
     */
    public static boolean FlymeSetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                window.setAttributes(lp);
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }

    /**
     * ����״̬������ͼ��Ϊ��ɫ����ҪMIUIV6����
     * @param window ��Ҫ���õĴ���
     * @param dark �Ƿ��״̬�����弰ͼ����ɫ����Ϊ��ɫ
     * @return  boolean �ɹ�ִ�з���true
     *
     */
    public static boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field  field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if(dark){
                    extraFlagField.invoke(window,darkModeFlag,darkModeFlag);//״̬��͸���Һ�ɫ����
                }else{
                    extraFlagField.invoke(window, 0, darkModeFlag);//�����ɫ����
                }
                result=true;
            }catch (Exception e){

            }
        }
        return result;
    }
	
	/**
	* ʹ״̬��͸��
	* 
	* ������ͼƬ��Ϊ�����Ľ���,��ʱ��ҪͼƬ��䵽״̬��
	* 
	* @param activity ��Ҫ���õ�activity
	* @param resourceId latyout��id����������ͼƬbackground�����״̬��
	*/
	private static void setTranslucent(Activity activity, int resourceId) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			// ����״̬��͸��
			activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			// ���ø����ֵĲ����������״̬��
			ViewGroup rootView = (ViewGroup) activity.findViewById(resourceId);
			rootView.setFitsSystemWindows(true);
			rootView.setClipToPadding(true);
		}
	} 
	
}
