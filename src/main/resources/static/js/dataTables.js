$(document).ready(() => {
    var person = $("#table-data").DataTable();
    
    person.on('order.dt search.dt', function () {
        person.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
});
