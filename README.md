Reproduction of issues with api 31+ devices when using the androidx splash library 

To highlight the issue either:
Run from android studio onto a 31+ target
or
Launch via manual adb command on a 31+ target
`adb shell am start -a android.intent.action.MAIN -c android.intent.category.LAUNCHER -n com.trevjonez.repro/com.trevjonez.repro.MainActivity`

https://issuetracker.google.com/issues/216136037