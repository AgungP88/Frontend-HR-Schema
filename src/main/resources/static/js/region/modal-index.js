$("#addFormModal").submit((event) => {
    event.preventDefault();
    const data = {
        id: $('#addFormModal #id').val(),
        name: $('#addFormModal #name').val()
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

$("#editFormModal").submit((event) => {
    event.preventDefault();
    const url = $('#editFormModal').attr('action');
    const data = {
        id: $('#editFormModal #id').val(),
        name: $('#editFormModal #name').val()
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
//            location.href="/region";
            
        },
        error: (error) => {
            console.log(error)
        }
    });
});
