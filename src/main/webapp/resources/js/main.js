/**
 * Created by chunk on 2017/11/28.
 */

$(document).ready(function () {
    $("#form").submit(function (event) {
        event.preventDefault();
        var form = $(this);

        //普通表单
        $.ajax({
            type: "POST",
            url: $("#generateGeometryInput").attr("formaction"),
            data: form.serialize()
        }).success(function (msg) {

        }).fail(function (jqXHR, textStatus, errorThrown) {
            //错误信息
        });
    });
})


