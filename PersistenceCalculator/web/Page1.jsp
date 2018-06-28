<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{Page1.page1}" id="page1">
            <webuijsf:html binding="#{Page1.html1}" id="html1">
                <webuijsf:head binding="#{Page1.head1}" id="head1">
                    <webuijsf:link binding="#{Page1.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{Page1.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{Page1.form1}" id="form1">
                        <webuijsf:staticText binding="#{Page1.staticText1}" id="staticText1" style="font-size: 24px; left: 120px; top: 48px; position: absolute" text="Persistence Calculator"/>
                        <webuijsf:textField binding="#{Page1.textField1}" id="textField1" style="position: absolute; left: 120px; top: 96px; width: 96px; height: 24px"/>
                        <webuijsf:button actionExpression="#{Page1.button1_action}" binding="#{Page1.button1}" id="button1"
                            style="position: absolute; left: 264px; top: 96px; width: 96px; height: 24px" text="Calc!"/>
                        <webuijsf:textField binding="#{Page1.textField2}" id="textField2" style="position: absolute; left: 120px; top: 144px; width: 240px; height: 24px"/>
                        <webuijsf:staticText binding="#{Page1.staticText2}" id="staticText2"
                            style="height: 166px; left: 120px; top: 264px; position: absolute; width: 238px" text="Persistence is a mathematical idea.It works as follow. multiply all the digits in an integer together to find a new number. Repeat until only one digit remains. Count how persistent things are by counting the number of terms"/>
                        <webuijsf:textField binding="#{Page1.textField3}" id="textField3" style="position: absolute; left: 120px; top: 192px; width: 240px; height: 24px"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
