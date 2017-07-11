Kaffeine
========
Kaffeine is a Kotlin-flavored Android library for accelerating development.

Several Words of Caution
------------------------
Besides the obvious productivity advantages, if you are using this project - be prepared to shoot
yourself in the foot or to blow your legs off. This is an experimental project that I am working on
while I learn Kotlin and functional programming. Some of the lucrative approaches used in
this project may not be best practices and I don't have any guarantees over the API. Don't be
surprised if the API changes for every SNAPSHOT. If you are trending along a safe path, this project
is definitely not for you. I may highlight caveats in some of the approaches if I am smart enough
to figure them out. But, feel free to throw some light if you spot some dumbness (or a lot) along
the lane.

Activities & Services
---------------------
<h4>Example: Start an Activity</h4>

**Java**
````java
Intent intent = new Intent(this, SuperPowersActivity.class);
intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
startActivity(intent);
````

**Kotlin**
````kotlin
val flags = flags(Intent.FLAG_ACTIVITY_NEW_TASK, Intent.FLAG_ACTIVITY_CLEAR_TOP)
startActivity<SuperPowersActivity>(flags)
````

Layout Inflation
----------------

**Java**
````java
LayoutInflater layoutInflater = LayoutInflater.from(this);
View awesomeView = layoutInflater.inflate(R.layout.my_awesome_layout, null);
````

**Kotlin**
````kotlin
val awesomeView = inflateLayout(R.layout.my_awesome_layout)
````

Logs
----
<h4>Example: Logging</h4>

**Java**
````java
String tag = this.getClass().getName();
Log.i(tag, "Howdy! Info");
Log.d(tag, "Knock knock! Debug");
Log.e(tag, "Grim, Error");
Log.wtf(tag, "Damn! WTF"); // Nope, not what you think. Refer the docs :P
````

**Kotlin**
````kotlin
i("Howdy! Info")
d("Knock knock! Debug")
e("Grim, Error")
wtf("Damn! WTF")
````

Preferences
-----------
<h4>Example: Single Preference</h4>

**Java**
````java
SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
Editor editor = preferences.edit();
editor.putBoolean("KEY_WALKTHROUGH_COMPLETE", complete);
if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
  editor.commit();
} else {
  editor.apply();
}
````

**Kotlin**
````kotlin
getDefaultSharedPreferences().putBoolean("KEY_WALKTHROUGH_COMPLETE", complete)
````

<h4>Example: Bulk Preferences</h4>

**Kotlin**
````kotlin
getDefaultSharedPreferences()
  .bulk()
  .putBoolean("KEY_WALKTHROUGH_COMPLETE", complete)
  .putString("KEY_LAST_USED", lastUsedIso8601Date)
  .applyBulk()
````

Toasts
------
<h4>Example: Short Message</h4>

**Java**
````java
Toast.makeText(this, R.string.welcome, Toast.LENGTH_SHORT).show();
````

**Kotlin**
````kotlin
showShortToast(R.string.welcome)
````

<h4>Example: Custom Toast</h4>

**Java**
````java
Toast toast = new Toast(this);
toast.setView(view);
toast.setDuration(Toast.LENGTH_LONG);
toast.show();
````

**Kotlin**
````kotlin
showShortToast(view)
````

System Services
---------------

**Java**
````java
AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
````

**Kotlin**
````kotlin
val alarmManager = context.alarmManager()
val notificationManager = context.notificationManager()
````

Resources
---------
<h4>Example: Typeface from Assets</h4>

**Java**
````java
AssetManager assetManager = getAssets();
Typeface sourceSansPro = Typeface.createFromAsset(assetManager, "fonts/source-sans-pro.ttf");
````

**Kotlin**
````kotlin
val sourceSansPro = typefaceFromAssets("fonts/source-sans-pro.ttf")
````

More...
-------
More extensions under development.

Maven
-----
    <dependency>
        <groupId>com.mobsandgeeks</groupId>
        <artifactId>kaffeine</artifactId>
        <version>0.1-SNAPSHOT</version>
    </dependency>

Gradle
------
    dependencies {
        compile 'com.mobsandgeeks:kaffeine:0.1-SNAPSHOT'
    }

Snapshots
---------
In your `{project_base}/build.gradle` file, include the following.

    allprojects {
        repositories {
            mavenCentral()
            maven {
                url "https://oss.sonatype.org/content/repositories/snapshots/"
            }
        }
    }

License
-------
    Copyright 2015 Mobs & Geeks

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
