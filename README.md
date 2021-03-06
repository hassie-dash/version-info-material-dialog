Version Info Material Dialog
============================

[![Build Status](https://travis-ci.org/hassie-dash/version-info-material-dialog.svg?branch=master)](https://travis-ci.org/hassie-dash/version-info-material-dialog) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/ee4f42264d0146f895374dffbeda0cdc)](https://www.codacy.com/app/hassie-dash/version-info-material-dialog?utm_source=github.com&utm_medium=referral&utm_content=hassie-dash/version-info-material-dialog&utm_campaign=badger) [![Download](https://api.bintray.com/packages/hassie/maven/version-info-material-dialog/images/download.svg) ](https://bintray.com/hassie/maven/version-info-material-dialog/_latestVersion) [![codecov](https://codecov.io/gh/hassie-dash/version-info-material-dialog/branch/master/graph/badge.svg)](https://codecov.io/gh/hassie-dash/version-info-material-dialog)

A simple Android library compatible all the way down to API 14, which builds a material dialog with version info for the app, including app icon, app name, app version and copyright notice; using the same style as Google's version info dialogs.

Screenshots
-----------
<img src="/screenshots/screenshot-01.png" height="500"> <img src="/screenshots/screenshot-02.png" height="500">

Dependencies
------------
To use the library, add the dependency to your app module's build.grade file:
```gradle
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    
    // Add this dependency.
    compile 'uk.co.hassie:version-info-material-dialog:0.1.0'
}
```

Example usage
-------------
HomeActivity.java
```java
new VersionInfoMDialog.Builder(HomeActivity.this)
    .setCopyrightText(R.string.app_copyright)
    .setVersionPrefix(R.string.version_prefix)
    .show();
```

strings.xml
```xml
<string name="app_copyright">&#169;2017 Hassie.</string>
<string name="version_prefix">Version</string>
```

Example usage 2
---------------
You can also build the dialog and call the show method at a later point in your code.

HomeActivity.java
```java
VersionInfoMDialog versionInfoMDialog = new VersionInfoMDialog.Builder(HomeActivity.this)
    .setCopyrightText(R.string.app_copyright)
    .setVersionPrefix(R.string.version_prefix)
    .build();
    
versionInfoMDialog.show();
```

Support for API 9 - API 13
--------------------------
Due to incompatible API changes in the Android Support Library, these APIs are no longer supported. Use version 0.0.9 which uses the old support library to support these APIs.

License
-------
Copyright ©2017 Hassie.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
