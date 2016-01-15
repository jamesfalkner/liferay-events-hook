<%--
/**
 * Copyright 2016 Liferay, Inc. All rights reserved.
 * http://www.liferay.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
--%>
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


