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
            <td scope="col" align="center">藏品编号</td>
            <td scope="col" align="center">藏品名称</td>
            <td scope="col" align="center">藏品年代</td>
            <td scope="col" align="center">修改</td>
            <td scope="col" align="center">删除</td>
        </tr>
        </thead>
        <tbody id="tbody">

        </tbody>
        <tfoot>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item">
                    <button class="page-link state" value="year">年代</button>
                </li>
                <li class="page-item">
                    <button class="page-link state" value="clink">点击量</button>
                </li>
                <li class="page-item">
                    <button class="page-link" id="last">上一页</button>
                </li>
                <li class="page-item">
                    <button class="page-link" id="next">下一页</button>
                </li>
                <li class="page-item">
                    <button class="page-link" id="addAnnouncement">添加藏品</button>
                </li>
            </ul>
            <input id="pages" name="page" value="1" hidden>
            <input id="currents" name="current" value="0" hidden>
            <input id="state" name="state" value="" hidden>
        </nav>
        </tfoot>
        <div class="input-group mb-3">
            <form id="selects">
                <input type="text" class="form-control" id="name" placeholder="请输入藏品名称"  name="name" value="">
                <input id="select" type="button" value="搜索">
            </form>
        </div>
    </table>
</div>

<div id="detail_announcement" >

</div>

<div id="update_announcement">

</div>
</body>
</html>
<script>
    $(function () {
        IfNext(true);
        $("#btnMore").click(function () {
            IfNext();
        })
    })

    function getDetail(res) {
        $.ajax({
            url:"selectOneCollection",
            type: "get",
            data: {"collection_id":res},
            dataType: "json",
            success:function (rest) {
                console.log(rest);
                if (rest.code === "200"){
                    $("#tables").hide();
                    $("#detail_announcement").children().remove();
                    let ann = rest.object;
                    let htmls =
                        "<button onclick=\"returns()\"  type=\"button\" class=\"btn btn-secondary\">返回</button>"+"<div style=\"background: url(\""+ann.photo+"\")\">\n" +
                        "        <p>藏品名称："+ann.name+"</p>\n" +
                        "        <p>藏品年代："+ann.year+"</p>\n" +
                        "        <p>藏品简介："+ann.profile+"</p>\n" +
                        "        <p>藏品类别："+ann.type+"</p> \n" +
                        "        <p>点击次数："+ann.clink+"</p> \n" +
                        "        <p>有关历史："+ann.history+"</p> \n" +
                        "    </div>";
                    $("#detail_announcement").append(htmls);
                    $("#detail_announcement").show();
                }
            }
        })
    }

    function toUpdate(res) {
        $.ajax({
            url:"selectOneCollection",
            type: "get",
            data: {"collection_id":res},
            dataType: "json",
            success:function (rest) {
                console.log(rest);
                if (rest.code === "200"){
                    $("#detail_announcement").hide();
                    $("#tables").hide();
                    $("#update_announcement").children().remove();
                    let ann = rest.object;
                    let htmls = "<form id=\"updateFrom\"'>\n" +
                        "        <input name=\"collection_id\" value=\""+ann.collection_id+"\" hidden>\n" +
                        "        <div class=\"form-group\">\n" +
                        "            <label for=\"exampleInputEmail1\">藏品名称</label>\n" +
                        "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" name=\"name\" value=\""+ann.name+"\">\n" +
                        "        </div>\n" +
                        "        <div class=\"form-group\">\n" +
                        "            <label for=\"exampleInputEmail2\">藏品类别</label>\n" +
                        "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail2\" name=\"type\" value=\""+ann.type+"\">\n" +
                        "        </div>\n" +
                        "        <div class=\"form-group\">\n" +
                        "            <label for=\"exampleInputEmail3\">藏品简介</label>\n" +
                        "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail3\" name=\"profile\" value=\""+ann.profile+"\">\n" +
                        "        </div>\n" +
                        "        <div>\n" +
                        "            <label for=\"exampleInputEmail4\">藏品年代</label>\n" +
                        "            <input type=\"text\" name=\"year\" value=\""+ann.year+"\" id=\"exampleInputEmail4\">\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <div>\n" +
                        "            <label for=\"exampleInputEmail4\">有关历史</label>\n" +
                        "            <input type=\"text\" name=\"history\" value=\""+ann.history+"\" id=\"exampleInputEmail4\">\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <input type=\"submit\" id=\"updateAnnouncement\" class=\"btn btn-primary\">\n" +"<button onclick=\"returns()\"  type=\"button\" class=\"btn btn-secondary\">返回</button>"+
                        "    </form>";
                    $("#update_announcement").append(htmls);
                    $("#update_announcement").show();
                    $("#updateAnnouncement").click(function () {
                        let query = $("#updateFrom").serialize();
                        $.ajax({
                            url:"updateCollection",
                            type:"get",
                            data:query,
                            dataType:"json",
                            success:function (ress) {
                                if (ress.code==="200"){
                                    alert(ress.msg);
                                }
                            }
                        })
                    })
                }
            }
        })
        IfNext(true);
    }

    function returns() {
        IfNext(true);
    }

    function toDelete(res) {
        $.ajax({
            url:"deleteCollection",
            data:{"collection_id":res},
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
            $("#tables").show();
            // $("#nextPage").val(1);
        }
        // var nextPage = $("#nextPage").val();
        // var poetryTypeId = $("#poetryTypeId").val();
        // var order = $("#order").val();
        $.ajax({
            url: "selectAllCollection",
            data: {"page": $("#pages").val(), "size": 10,"state":$("#state").val(),"name":$("#name").val()},
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
                        "        <span onclick=\"getDetail("+book.collection_id+")\">\n" +
                        "            "+book.collection_id+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"getDetail("+book.collection_id+")\">\n" +
                        "            "+book.name+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"getDetail("+book.collection_id+")\">\n" +
                        "            "+book.year+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"toUpdate("+book.collection_id+")\">\n" +
                        "            修改\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td salign=\"center\">\n" +
                        "            <span onclick=\"toDelete("+book.collection_id+")\">\n" +
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
        $("#detail_announcement").hide();
        $("#tables").hide();
        $("#update_announcement").children().remove();
        let htmls = "<form id=\"updateFrom\"'>\n" +
            "        <div class=\"form-group\">\n" +
            "            <label for=\"exampleInputEmail1\">藏品名称</label>\n" +
            "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" name=\"name\" >\n" +
            "        </div>\n" +
            "        <div class=\"form-group\">\n" +
            "            <label for=\"exampleInputEmail2\">藏品类别</label>\n" +
            "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail2\" name=\"type\" >\n" +
            "        </div>\n" +
            "        <div class=\"form-group\">\n" +
            "            <label for=\"exampleInputEmail3\">相关历史</label>\n" +
            "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail3\" name=\"history\" >\n" +
            "        </div>\n" +
            "        <div>\n" +
            "            <label for=\"exampleInputEmail4\">藏品简介</label>\n" +
            "            <input type=\"text\" name=\"profile\" id=\"exampleInputEmail4\">\n" +
            "        </div>\n" +
            "\n" +
            "        <div>\n" +
            "            <label for=\"exampleInputEmail4\">藏品年代</label>\n" +
            "            <input type=\"text\" name=\"year\" id=\"exampleInputEmail4\">\n" +
            "        </div>\n" +
            "\n" +
            "        <input type=\"submit\" id=\"insertAnnouncement\" class=\"btn btn-primary\">\n" +"<button onclick=\"returns()\"  type=\"button\" class=\"btn btn-secondary\">返回</button>"+
            "    </form>";
        $("#update_announcement").append(htmls);
        $("#update_announcement").show();
        $("#insertAnnouncement").click(function () {
            let query = $("#updateFrom").serialize();
            $.ajax({
                url:"insertCollection",
                type:"get",
                data:query,
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
    })

    $("#select").click(function () {
        let serialize = $("#selects").serialize();
        $("#tbody").children().remove();
        IfNext(false);
    })

    $(".state").click(function () {
        let state = $(this).val();
        $("#state").val(state);
        $("#tbody").children().remove();
        IfNext(false);
    })
</script>
