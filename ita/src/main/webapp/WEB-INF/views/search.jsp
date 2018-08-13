<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<jsp:attribute name="pageTitle">
		<c:out value="Search" />
	</jsp:attribute>
	<jsp:attribute name="currentMenuName">
		<c:out value="Search" />
	</jsp:attribute>
	<jsp:body>





<div class="row">
     <div class="small-3 columns">
        <input type="text" id="txt" name="searchString">
      </div>

       <div class="small-5 columns end">
         <button id="button-id" type="submit">Search Teams</button>
       </div>

   </div>

 <div class="row">
      <div>
         ${users}
     </div>
</div>
