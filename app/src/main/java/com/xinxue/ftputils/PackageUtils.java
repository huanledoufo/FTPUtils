package com.xinxue.ftputils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/13.
 */
public class PackageUtils {
    public static List<PackageInfo> getPackageInfo(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pList = new ArrayList<>();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = installedPackages.get(i);
            if ((packageInfo.applicationInfo.flags & packageInfo.applicationInfo.FLAG_SYSTEM) <= 0) {
                pList.add(packageInfo);
            }
        }
        return pList;
    }
}
