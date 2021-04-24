<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="label" required="true" %>
<%@ attribute name="id" required="true" %>

<label>${label}</label>
<input type="text" id="${id}" name="${id}" autocomplete="off"/> <br/>

<script type="text/javascript">
	$("#${id}").datepicker();
</script>
