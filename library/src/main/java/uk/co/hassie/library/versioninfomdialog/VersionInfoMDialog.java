/*
 * Copyright ©2017 Hassie.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.hassie.library.versioninfomdialog;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hassie on 16/03/2017.
 */

public class VersionInfoMDialog{

    private AlertDialog mVersionInfoMaterialDialog = null;
    private Context mContext;
    private CharSequence mVersionPrefix;
    private CharSequence mCopyrightText;

    public static class Builder extends VersionInfoMDialog {

        public Builder(Context context) {
            super.mContext = context;
        }

        public Builder setCopyrightText(@NonNull CharSequence copyrightText) {
            super.mCopyrightText = copyrightText;
            return this;
        }

        public Builder setCopyrightText(@StringRes int copyrightTextId) {
            if (copyrightTextId == 0)
                return this;
            super.mCopyrightText = super.mContext.getResources().getString(copyrightTextId);
            return this;
        }

        public Builder setVersionPrefix(@NonNull CharSequence versionPrefixText) {
            super.mVersionPrefix = versionPrefixText;
            return this;
        }

        public Builder setVersionPrefix(@StringRes int versionPrefixId) {
            if (versionPrefixId == 0)
                return this;
            super.mVersionPrefix = super.mContext.getResources().getString(versionPrefixId);
            return this;
        }

    }

    public VersionInfoMDialog build() {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.alert_dialog_version_info, null);

        ImageView appIcon = (ImageView) view.findViewById(R.id.imgAppIcon);
        TextView appName = (TextView) view.findViewById(R.id.txtAppName);
        TextView appVersion = (TextView) view.findViewById(R.id.txtAppVersionName);
        TextView appCopyright = (TextView) view.findViewById(R.id.txtAppCopyright);

        ApplicationInfo applicationInfo = mContext.getApplicationInfo();
        appIcon.setImageResource(applicationInfo.icon);

        if (applicationInfo.labelRes == 0) {
            appName.setText(applicationInfo.nonLocalizedLabel);
        } else {
            appName.setText(applicationInfo.labelRes);
        }

        try {
            PackageInfo packageInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            if (mVersionPrefix == null || mVersionPrefix.equals("")) {
                appVersion.setText(packageInfo.versionName);
            } else {
                appVersion.setText(mVersionPrefix + " " + packageInfo.versionName);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        appCopyright.setText(mCopyrightText);

        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(mContext)
                .setView(view)
                .create();

        mVersionInfoMaterialDialog = alertDialog;

        return this;
    }

    public VersionInfoMDialog show() {
        if (mVersionInfoMaterialDialog == null)
            build();
        mVersionInfoMaterialDialog.show();
        return this;
    }

}