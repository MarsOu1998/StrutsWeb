<%--
  Created by IntelliJ IDEA.
  User: air
  Date: 2019-08-15
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<html>
<head>
    <title>查询学生信息</title>
</head>
<body>
    显示结果:
<table bgcolor="yellow">
    <tr>
        <td>账号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
    </tr>
    <logic:present name="pc">
        <logic:iterate id="stu" name="pc" property="smallList">
            <tr>
            <td><bean:write name="stu" property="account"></bean:write></td>
            <td><bean:write name="stu" property="name"></bean:write></td>
            <td><bean:write name="stu" property="sex"></bean:write></td>
            <td><bean:write name="stu" property="age"></bean:write></td>
            </tr>
        </logic:iterate>
    </logic:present>
</table>
    <html:link action="/query.do?PageIndex=1">首页</html:link>
    <logic:equal value="false" name="pc" property="first">
    <html:link action="/query.do" paramId="PageIndex" paramName="pc" paramProperty="prePageIndex">上一页</html:link>
    </logic:equal>
    <logic:equal value="false" name="pc" property="last">
    <html:link action="/query.do" paramId="PageIndex" paramName="pc" paramProperty="nextPageIndex">下一页</html:link>
    </logic:equal>
    <html:link action="/query.do" paramId="PageIndex" paramName="pc" paramProperty="pageCount">尾页</html:link>
</body>
</html>
