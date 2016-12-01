function deleteBatch(basePath) {
	$("#mainForm").attr("action", basePath + "DeleteBatch.action");
	$("#mainForm").submit();
}