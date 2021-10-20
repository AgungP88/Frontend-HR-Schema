const _csrf = $('meta[name=_csrf]').attr('content');

$.ajax({
    url: "/employee/getAll",
    type: "GET",
    data: 'JSON',
    success: function (data) {
        console.log(data);
        $('#table-data').DataTable({
            "data": data,
            columns: [
                {'data': 'id', render: function (data, type, row, meta) {
                        return meta.row + meta.settings._iDisplayStart + 1;
                    }},
//                { "data": "id"},
                { "data": "firstName"},
//                { "data": "lastName"},
                { "data": "email"},
                { "data": "phoneNumber"},
                { "data": "hireDate"},
//                { "data": "salary"},
//                { "data": "commissionPct"},
                { "data": "job.title"},
                { "data": "manager.firstName"},
                { "data": "department.name"},
                {'data': 'id', render: function (data, type, row, meta) {
                        let editButton = `<a class="text-white" href="/employee/edit/${row.id}">
                                <button class="btn btn-success">
                                Edit
                                </button>
                        </a>`;
                        var updateButton = `<button type="button" class="btn btn-warning" 
                                data-toggle="modal" data-target="#ajaxEditEmployee"
                                onclick="ajaxEdit(${row.id}, '${row.firstName}', '${row.lastName}', '${row.email}',
                                '${row.phoneNumber}', '${row.hireDate}', '${row.salary}', '${row.commissionPct}',
                                '${row.job.id}', '${row.manager.id}', '${row.department.id}')">
                                Modal Edit
                        </button>`;
                        var deleteButton = `<form 
                            action="/employee/${row.id}" 
                            method="POST" id="deleteForm">
                            <input type="hidden" name="_method" value="DELETE">
                            <input type="hidden" name="_csrf" value="${_csrf}">
                            <button type="submit" class="btn btn-danger" onclick="deleteConfirm(${row.id})">
                            Delete</button>
                        </form>`;
                            return editButton + updateButton + deleteButton;
                    }}
            ]
        });
    }
});
