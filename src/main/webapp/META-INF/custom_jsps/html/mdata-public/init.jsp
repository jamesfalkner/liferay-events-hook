<%@ include file="/html/portal/init.jsp" %>
<%@ page
        import="com.liferay.mail.service.MailServiceUtil" %>

<%@ page
        import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page
        import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>

<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.mail.MailMessage" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecord" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoColumn" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoRow" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoTable" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoValue" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoRowLocalServiceUtil" %>

<%@ page
        import="com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil" %>

<%@ page
        import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil" %>
<%@ page
        import="javax.mail.internet.InternetAddress" %>

<%@ page import="java.util.*" %>
<%@ page import="java.util.regex.Pattern" %>


