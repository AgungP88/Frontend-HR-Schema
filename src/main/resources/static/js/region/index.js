$("#addForm").submit((event) => {
    event.preventDefault();
    const data = {
        id: $('#id').val(),
        name: $('#name').val()
    };
    const _csrf = $('input[name=_csrf]').val();
    
    $.ajax({
        url: '/region/add',
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
            location.href="/region";
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
        name: $('#name').val()
    };
    const _csrf = $('input[name=_csrf]').val();
    
    $.ajax({
        url: url,
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        beforeSend: (request) => {
            request.setRequestHeader('X-CSRF-TOKEN', _csrf);
        },
        success: (result) => {
            console.log(result);
            Swal.fire('Data has been saved');
            location.href="/region";
        },
        error: (error) => {
            console.log(error)
        }
    });
});


$("#deleteForm").submit((event) => {
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
            location.href="/region";
        },
        error: (error) => {
            console.log(error)
        }
    });
});


