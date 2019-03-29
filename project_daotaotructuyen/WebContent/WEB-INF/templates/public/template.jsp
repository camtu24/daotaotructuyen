<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<div class="wrapper row3">
	  <div id="container">
	    <!-- ################################################################################################ -->
	    <div id="homepage" class="clear">
	      <tiles:insertAttribute name="body"></tiles:insertAttribute>
	      <!-- #### -->
	      <tiles:insertAttribute name="rightbar"></tiles:insertAttribute>
	    </div>
	    <!-- ################################################################################################ -->
	    <div class="clear"></div>
	  </div>
	</div>
<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		
