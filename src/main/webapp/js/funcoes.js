
$(function () {
    $('#add').click(function () {
        var input = '<div class="form-group col-md-4">';
        input += '<label for="telefone">Telefone: </label>';
        input += '<input type="text" class="form-control" name="telefone" id="telefone" required>';
        input += '<a href="#" class="btn btn-danger btn-xs">X</a></div>';

        $("#telefones").append(input);
        return false;
    });

    $('#telefones').delegate('a', 'click', function (e) {
        e.preventDefault();
        $(this).parent('div').remove();
    });
});
