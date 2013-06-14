<%@ taglib uri="simpleTagSupportBodies" prefix = "simple"%>
Text in included page before exception<br/>
<simple:skipPageException throwException="true">Included body</simple:skipPageException><br/>
You will never see this text in included page after exception.<br/>