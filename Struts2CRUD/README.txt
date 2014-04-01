This is an example that demonstrates using Struts 2 to 
create an application that can run as a portlet inside
a portlet container such as Pluto or uPortal and also
as a standalone web application.

Run mvn -e clean package to create the war file.

Copy the war file to Tomcat's webapps folder.

This application was tested with the Pluto portlet 
container running under Tomcat 6.  The application's
web.xml is configured with the necessary information
for deploying the portlet in Pluto's portlet container.
