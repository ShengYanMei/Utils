	
	// FileUtil  文件操作工具类
	
	// （1）判断文件是否存在
	// （2）删除 目录及内部文件 或 文件
	// （3）存储卡是否可用
	// （4）获取手机内部剩余存储空间
	// （5）获取文件名
	// （6）判断下载目录是否存在，不存在的话则创建
	// （7）获取文件长度
	// （8）Java文件操作 获取不带扩展名的文件名
	
public class FileUtil{
		
	/**
     * FileUtil对象
     */
    private static FileUtil mFileUtil = null;
		
	/**
     * 单例获取FileUtil
     *
     * @param context
     * @return
     */
    public static FileUtil getFileUtil(Context context) {
        if (mFileUtil == null) {
            mFileUtil = new FileUtil(context);
        }
        return mFileUtil;
    }
	
	/**
	*  （1）判断文件是否存在
	*/
    public static boolean isExsistsFile(String filepath) {
        try {
            if (filepath.isEmpty()) {
                return false;
            }
            File file = new File(filepath);
            return file.exists();
        } catch (Exception e) {
            return false;

        }
    }
	
	/**
    *  （2）删除   目录及内部文件 或 文件
    */
    private void folderDelete(String folderName) {
        File file = new File(folderName);
        if (file.exists()) { 			// 判断文件是否存在
            if (file.isFile()) { 		// 判断是否是文件
                file.delete();
            } else if (file.isDirectory()) { 				// 否则如果它是一个目录
                File files[] = file.listFiles(); 			// 声明目录下所有的文件 files[];
                for (int i = 0; i < files.length; i++) { 	// 遍历目录下所有的文件
                    files[i].delete();
                }
            }
            file.delete();
        } else {
            // Log.i("FileUtil", "文件或目录不存在");
        }
    }
	
	/**
     * （3）存储卡是否可用 
     */
    public boolean SDCardExists() {
		// 内部存储卡，/Download/ 目录
        return Environment.getExternalStorageState().equals(android.os.Environment.DIRECTORY_DOWNLOADS);
    }
	
	/**
     * （4）获取手机内部剩余存储空间 
	 * @return
     */
    public static long getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return availableBlocks * blockSize;
    }
	
	/**
	*  （5）获取文件名
	*/
	public static String getFileName(String pathandname) {
        int start = pathandname.lastIndexOf("/");
        int end = pathandname.lastIndexOf(".");
        if (start != -1 && end != -1) {
            return pathandname.substring(start + 1);
        } else {
            return null;
        }
    }
	
	/**
     * （6）判断下载目录是否存在，不存在的话则创建
     *
     * @param path 下载目录完整路径名
     */
    public static boolean checkDownloadDir(String path) {
        boolean res = false;
        File downloadDir = new File(path.trim());

        boolean exists = downloadDir.exists();
        boolean isDirectory = downloadDir.isDirectory();

        if (!exists || !isDirectory) {
            res = downloadDir.mkdirs();
        }
        return res;
    }
	
	/**
	*  （7）获取文件长度
	*/
	public static long getFileSize(String path) {
        if (path.isEmpty()) {
            return -1;
        }
        File file = new File(path);
        return (file.exists() && file.isFile() ? file.length() : -1);
    }
	
	/**
     * （8）Java文件操作 获取不带扩展名的文件名
     */
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }
	
	
	
}
