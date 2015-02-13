# MubalooOrgChartTest
Android native test project.
to run the test use the following command

adb shell am instrument -w com.mubaloo.org.chart.test.tests/android.test.InstrumentationTestRunner

Four tests in total alone with one UI test.

TestHTTPProxyRequest - To test HTTP GET request
TestEmployeeDbHelper - To insert/delete record (local sqlite database)
TestFragmentStack - To test Fragment push and pop methods (Functional test)
TestImageDownloader - To test remote image download and set on ImageView (not completed yet)
TestEmployeeChartActivity - To test UI activity


