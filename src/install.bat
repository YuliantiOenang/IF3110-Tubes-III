set webappdir=C:\xampp\tomcat\webapps\ruserba
rmdir %webappdir% /S /Q
mkdir %webappdir%
xcopy classes\* %webappdir%\WEB-INF\classes\ /E /Y /I
xcopy web\* %webappdir%\ /E /Y /I
xcopy lib\* %webappdir%\WEB-INF\lib\ /E /Y /I
xcopy jsp\* %webappdir%\WEB-INF\jsp\ /E /Y /I
xcopy etc\web.xml %webappdir%\WEB-INF\ /I /Y
