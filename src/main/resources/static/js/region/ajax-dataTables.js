const _csrf = $('meta[name=_csrf]').attr('content');

$.ajax({
    url: "/region/getAll",
    type: "GET",
    data: 'JSON',
    success: function (data) {
//        console.log(data);
        $('#table-data').DataTable({
            "data": data,
            columns: [
//                {'data': 'id', render: function (data, type, row, meta) {
//                        return meta.row + meta.settings._iDisplayStart + 1;
//                    }},
                { "data": "id"},
                { "data": "name"},
                {'data': 'id', render: function (data, type, row, meta) {
                        let editButton = `<a class="text-white" href="/region/edit/${row.id}">
                                <button class="btn btn-success">
                                Edit
                                </button>
                        </a>`;
                        var updateButton = `<button type="button" class="btn btn-warning" 
                                data-toggle="modal" data-target="#ajaxEditForm"
                                onclick="ajaxEdit(${row.id}, '${row.name}')">
                                Modal Ajax Edit
                        </button>`;
                        var deleteButton = `<form 
                            action="/region/${row.id}" 
                            method="POST" id="deleteForm">
                            <input type="hidden" name="_method" value="DELETE">
                            <input type="hidden" name="_csrf" value="${_csrf}">
                            <button type="submit" class="btn btn-danger" id="submitForm">Delete</button>
                        </form>`;
                            return editButton + updateButton + deleteButton;
                    }}
            ]
        });
    }
});



