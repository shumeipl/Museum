<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0, maximum-scale=1.0,user-scalable=no">
    <script src="js/jquery.3.3.1.min.js"></script>
    <link rel="stylesheet" href="js/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="js/jquery.raty.css">
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <script src="js/art-template.js"></script>
    <script src="js/jquery.raty.js"></script>
    <script src="js/jquery-3.6.0.js"></script>
    <script src="js/bootstrap.bundle.js"></script>
    <script src="js/bootstrap.js"></script>
</head>
<body>

<div id="tables">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <td scope="col" align="center">管理员编号</td>
            <td scope="col" align="center">修改密码</td>
            <td scope="col" align="center">删除</td>
        </tr>
        </thead>
        <tbody id="tbody">

        </tbody>
        <tfoot>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item">
                    <button class="page-link" id="last">上一页</button>
                </li>
                <li class="page-item">
                    <button class="page-link" id="next">下一页</button>
                </li>
                <li class="page-item">
                    <button class="page-link" id="addAnnouncement">添加管理员</button>
                </li>
            </ul>
            <input id="pages" name="page" value="1" hidden>
            <input id="currents" name="current" value="0" hidden>
        </nav>
        </tfoot>
    </table>
</div>

<div id="detail_announcement" >

</div>

<div id="update_announcement" >

</div>
</body>
</html>
<script>
    $(function () {
        IfNext(true);
    })

    function returns() {
        IfNext(true);
    }

    function toUpdate(res) {
        $("#update_announcement").children().remove();
        let htmls = "<form id=\"updatePassword\">\n" +
            "        <div class=\"form-group\">\n" +
            "            <label for=\"manage_id\">旧密码</label>\n" +
            "        <input readonly name=\"manage_id\" id=\"manage_id\" class=\"form-control\">\n" +
            "        </div>\n" +
            "        <div class=\"form-group\">\n" +
            "            <label for=\"oldPass\">旧密码</label>\n" +
            "            <input  name=\"oldPass\" type=\"password\" class=\"form-control\" id=\"oldPass\">\n" +
            "        </div>\n" +
            "        <div class=\"form-group\">\n" +
            "            <label for=\"password\">新密码</label>\n" +
            "            <input name=\"password\" type=\"password\" class=\"form-control\" id=\"password\">\n" +
            "        </div>\n" +
            "        <input type=\"button\" value=\"修改密码\" id=\"submitPass\">\n" +
            "    </form>";
        $("#update_announcement").append(htmls)
        $("#detail_announcement").hide();
        $("#tables").hide();
        $("#manage_id").val(res);
        $("#update_announcement").show();
        $("#submitPass").click(function () {
            let query = $("#updatePassword").serialize();
            $.ajax({
                url:"updatePassword",
                type:"get",
                data:query,
                dataType:"json",
                success:function (ress) {
                        alert(ress.msg);
                }
            })
            IfNext(true);
        })

    }

    function toDelete(res) {
        $.ajax({
            url:"deleteManager",
            data:{"delete_id":res},
            type:"get",
            dataType:"json",
            success:function (rest) {
                alert(rest.msg);
            }
        })
        IfNext(true);
    }

    function IfNext(isFirst) {
        if (isFirst) {
            $("#tbody").children().remove();
            $("#detail_announcement").hide();
            $("#update_announcement").hide();
            $("#tables").show();
        }
            $.ajax({
                url: "getAllManage",
                data: {"page": $("#pages").val(), "size": 10},
                type: "get",
                dataType: "json",
                success: function (res) {
                    console.log(res);
                    let total = res.total;
                    let size = res.size;
                    total = parseInt(total);
                    size = parseInt(size);
                    if (res.total % res.size == 0) {
                        let number = total / size;
                        $("#currents").val(number);
                    } else {
                        let number = (total / size) + 1;
                        number = parseInt(number);
                        $("#currents").val(number);
                    }

                    var bookList = res.records;
                    for (var i = 0; i < bookList.length; i++) {
                        var book = bookList[i];
                        let html ="    <tr>\n" +
                            "        <td align=\"center\">\n" +
                            "        <span>\n" +
                            "            "+book.manage_id+"\n" +
                            "        </span>\n" +
                            "        </td>\n" +
                            "        <td salign=\"center\">\n" +
                            "            <span onclick=\"toUpdate("+book.manage_id+")\">\n" +
                            "            修改密码\n" +
                            "        </span>\n" +
                            "        </td>\n" +
                            "        <td salign=\"center\">\n" +
                            "            <span onclick=\"toDelete("+book.manage_id+")\">\n" +
                            "            删除\n" +
                            "        </span>\n" +
                            "        </td>\n" +
                            "    </tr>";
                        $("#tbody").append(html);
                    }
                    $("a").click(function () {
                        let text = $(this).val();
                        alert(text)
                    })
                }
            });
    }

    $("#last").click(function () {
        let val = $("#pages").val();
        if (val > 1) {
            val--;
        }
        $("#pages").val(val);
        $("#tbody").children().remove();
        IfNext(false);
    })

    $("#next").click(function () {
        let val = $("#pages").val();
        if (val < $("#currents").val()) {
            val++;
        }
        $("#pages").val(val);
        $("#tbody").children().remove();
        IfNext(false);
    })

    $("#addAnnouncement").click(function () {
            $.ajax({
                url:"insertManage",
                data:"",
                type:"get",
                dataType:"json",
                success:function (ress) {
                    console.log(ress);
                    if (ress.code==="200"){
                        alert(ress.msg);
                    }
                    IfNext(true);
                }
            })
        })



</script>
