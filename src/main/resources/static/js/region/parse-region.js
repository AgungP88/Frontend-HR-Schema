function updateRegion(id, name){
    $("#regionForm").attr('action', "/region/"+id);
    $("#regionForm #hidden").attr('method', 'PUT');
    $("#regionForm #id").val(id);
    $("#regionForm #name").val(name);
}

function addRegion(){
    $("#regionForm").attr('action', "/region/add");
    $("#regionForm #hidden").remove();
    $("#regionForm #id").val("");
    $("#regionForm #name").val("");
}

function ajaxEdit(id, name){
    $("#editFormModal").attr('action', "/region/"+id);
    $("#editFormModal #hidden").attr('method', 'PUT');
    $("#editFormModal #id").val(id);
    $("#editFormModal #name").val(name);
}







