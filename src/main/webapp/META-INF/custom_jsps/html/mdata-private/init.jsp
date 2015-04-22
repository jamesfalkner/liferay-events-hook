<%@ include file="/html/portal/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>

<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>


<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.SortedArrayList" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecord" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoColumn" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoRow" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoTable" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoValue" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoRowLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil" %>
<%@ page import="org.apache.commons.collections.CollectionUtils" %>
<%@ page import="org.apache.commons.collections.Predicate" %>
<%@ page import="java.util.*" %>


