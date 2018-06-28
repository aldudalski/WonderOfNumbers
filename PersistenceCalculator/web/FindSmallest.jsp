<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{FindSmallest.page1}" id="page1">
            <webuijsf:html binding="#{FindSmallest.html1}" id="html1">
                <webuijsf:head binding="#{FindSmallest.head1}" id="head1">
                    <webuijsf:link binding="#{FindSmallest.link1}" id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{FindSmallest.body1}" id="body1" style="-rave-layout: grid">
                    <webuijsf:form binding="#{FindSmallest.form1}" id="form1">
                        <webuijsf:dropDown binding="#{FindSmallest.dropDown1}" id="dropDown1" items="#{FindSmallest.values}" style="position: absolute; left: 120px; top: 24px"/>
                        <webuijsf:hyperlink actionExpression="#{FindSmallest.hyperlink1_action}" binding="#{FindSmallest.hyperlink1}" id="hyperlink1"
                            style="left: 144px; top: 72px; position: absolute" text="Hyperlink"/>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
