$("#addForm").submit((event) => {
    event.preventDefault();
    const data = {
//        id: $('#addEmployeeModal #id').val(),
        firstName: $('#firstName').val(),
        lastName: $('#lastName').val(),
        email: $('#email').val(),
        phoneNumber: $('#phoneNumber').val(),
        hireDate: $('#hireDate').val(),
        salary: $('#salary').val(),
        commissionPct: $('#commissionPct').val(),
        jobId: $('#jobId').val(),
        managerId: $('#managerId').val(),
        departmentId: $('#departmentId').val(),
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

$("#editForm").submit((event) => {
    event.preventDefault();
    const url = $('#editForm').attr('action');
    const data = {
        id: $('#id').val(),
        firstName: $('#firstName').val(),
        lastName: $('#lastName').val(),
        email: $('#email').val(),
        phoneNumber: $('#phoneNumber').val(),
        hireDate: $('#hireDate').val(),
        salary: $('#salary').val(),
        commissionPct: $('#commissionPct').val(),
        jobId: $('#jobId').val(),
        managerId: $('#managerId').val(),
        departmentId: $('#departmentId').val(),
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


const deleteEmployee = (id) => {
    event.preventDefault();
    const url = $('#deleteForm').attr('action');
    const _csrf = $('input[name=_csrf]').val();
    
    $.ajax({
        url: url,
        method: 'DELETE',
        contentType: 'application/json',
        dataType: 'json',
        beforeSend: (request) => {
            request.setRequestHeader('X-CSRF-TOKEN', _csrf);
        },
        success: (result) => {
            console.log(result);
            Swal.fire('Data has been deleted');
            location.href="/employee";
        },
        error: (error) => {
            console.log(error)
        }
    });
}

const deleteConfirm = (id) => {
    event.preventDefault();
    Swal.fire({
            title: 'Are you sure to Delete?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.value) {
                deleteEmployee(id);
                Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                  );
            }
        });
};

