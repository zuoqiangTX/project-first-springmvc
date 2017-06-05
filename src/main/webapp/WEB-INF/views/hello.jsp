<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>${requestScope.message}</h2>

<p>
    使用EL表达式“$\{requestScope.message”，发现浏览器解释不出来，上网查找资料后得知：主要原因是EL表达式无法被解析到.
    其实从后台取值并传值到前台来根本就没有错，而前台JSP页面EL表达式无效，解析不到EL表达式</p>

<p>引起的原因是web.xml中：
    <web-app version="2.5" xmlns="http://Java.sun.com/xml/ns/javaee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
        注意里面的web-app_2_5.xsd，就是这个引起的，在web-app_2_4.xsd中就不会出现这种问题(这个版本的isELIgnored默认设置为false)。 在不改变web.xml2.5版本的情况下解决办法是：
        在jsp页面头加:<%@page isELIgnored="false" %> 问题得以解决。
</p>
<p>还有就是:
    <%@page isELIgnored="false" %>
    的优先级要高于web.xml中的设置,所以在JSP中的设置会盖掉web.xml中的设置.</p>
</body>
</html>
