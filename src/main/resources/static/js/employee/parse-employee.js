function updateEmployee(id, firstName, lastName, email, phoneNumber, hireDate, salary, commissionPct, job, manager, department){
    $("#employeeForm").attr('action', "/employee/"+id);
    $("#employeeForm #hidden").attr('method', 'PUT');
    $("#employeeForm #firstName").val(firstName);
    $("#employeeForm #lastName").val(lastName);
    $("#employeeForm #email").val(email);
    $("#employeeForm #phoneNumber").val(phoneNumber);
    $("#employeeForm #hireDate").val(hireDate);
    $("#employeeForm #salary").val(salary);
    $("#employeeForm #commissionPct").val(commissionPct);
    $("#employeeForm #job").val(job);
    $("#employeeForm #manager").val(manager);
    $("#employeeForm #department").val(department);
}

function addEmployee(){
    $("#employeeForm").attr('action', "/employee/add");
    $("#employeeForm #hidden").remove();
    $("#employeeForm #firstName").val("");
    $("#employeeForm #lastName").val("");
    $("#employeeForm #email").val("");
    $("#employeeForm #phoneNumber").val("");
    $("#employeeForm #hireDate").val("");
    $("#employeeForm #salary").val("");
    $("#employeeForm #commissionPct").val("");
    $("#employeeForm #job").val("");
    $("#employeeForm #manager").val("");
    $("#employeeForm #department").val("");
}


function ajaxEdit(id, firstName, lastName, email, phoneNumber, hireDate, salary, commissionPct, job, manager, department){
    $("#editEmployeeModal").attr('action', "/employee/"+id);
    $("#editEmployeeModal #hidden").attr('method', 'PUT');
    $("#editEmployeeModal #id").val(id);
    $("#editEmployeeModal #firstName").val(firstName);
    $("#editEmployeeModal #lastName").val(lastName);
    $("#editEmployeeModal #email").val(email);
    $("#editEmployeeModal #phoneNumber").val(phoneNumber);
    $("#editEmployeeModal #hireDate").val(hireDate);
    $("#editEmployeeModal #salary").val(salary);
    $("#editEmployeeModal #commissionPct").val(commissionPct);
    $("#editEmployeeModal #jobId").val(job);
    $("#editEmployeeModal #managerId").val(manager);
    $("#editEmployeeModal #departmentId").val(department);
}

