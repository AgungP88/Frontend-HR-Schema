$("#addEmployeeModal").submit((event) => {
    event.preventDefault();
    const data = {
//        id: $('#addEmployeeModal #id').val(),
        firstName: $('#addEmployeeModal #firstName').val(),
        lastName: $('#addEmployeeModal #lastName').val(),
        email: $('#addEmployeeModal #email').val(),
        phoneNumber: $('#addEmployeeModal #phoneNumber').val(),
        hireDate: $('#addEmployeeModal #hireDate').val(),
        salary: $('#addEmployeeModal #salary').val(),
        commissionPct: $('#addEmployeeModal #commissionPct').val(),
        jobId: $('#addEmployeeModal #jobId').val(),
        managerId: $('#addEmployeeModal #managerId').val(),
        departmentId: $('#addEmployeeModal #departmentId').val(),
    };
    const _csrf = $('input[name=_csrf]').val();
    
    $.ajax({
        url: '/employee/add',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        beforeSend: (request) => {
            request.setRequestHeader('X-CSRF-TOKEN', _csrf);
        },
        success: (result) => {
            console.log(result);
            Swal.fire('Data has been saved');
            location.href="/employee";
        },
        error: (error) => {
            console.log(error)
        }
    });
});

$("#editEmployeeModal").submit((event) => {
    event.preventDefault();
    const url = $('#editEmployeeModal').attr('action');
    const data = {
        id: $('#editEmployeeModal #id').val(),
        firstName: $('#editEmployeeModal #firstName').val(),
        lastName: $('#editEmployeeModal #lastName').val(),
        email: $('#editEmployeeModal #email').val(),
        phoneNumber: $('#editEmployeeModal #phoneNumber').val(),
        hireDate: $('#editEmployeeModal #hireDate').val(),
        salary: $('#editEmployeeModal #salary').val(),
        commissionPct: $('#editEmployeeModal #commissionPct').val(),
        jobId: $('#editEmployeeModal #jobId').val(),
        managerId: $('#editEmployeeModal #managerId').val(),
        departmentId: $('#editEmployeeModal #departmentId').val(),
    };
    const _csrf = $('input[name=_csrf]').val();
    
    $.ajax({
        url: url,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        beforeSend: (request) => {
            request.setRequestHeader('X-CSRF-TOKEN', _csrf);
        },
        success: (result) => {
            console.log(result);
            Swal.fire('Data has been saved');
            location.href="/employee";
            
        },
        error: (error) => {
            console.log(error)
        }
    });
});

