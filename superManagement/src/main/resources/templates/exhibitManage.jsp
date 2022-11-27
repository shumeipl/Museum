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
            <td scope="col" align="center">展览编号</td>
            <td scope="col" align="center">开放时间</td>
            <td scope="col" align="center">场馆名称</td>
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
                    <button class="page-link" id="last">上一页</button>
                </li>
                <li class="page-item">
                    <button class="page-link" id="next">下一页</button>
                </li>
                <li class="page-item">
                    <button class="page-link" id="addAnnouncement">添加排班</button>
                </li>
            </ul>
            <input id="pages" name="page" value="0" hidden>
            <input id="currents" name="current" value="0" hidden>
        </nav>
        </tfoot>
        <div class="input-group mb-3">
            <form id="selects">
                <input type="text" class="form-control" id="venue_name" placeholder="请输入场馆名称"  name="venue_name">
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
    })

    function getDetail(res) {
        $.ajax({
            url:"selectOneExhibit",
            type: "get",
            data: {"exhibit_id":res},
            dataType: "json",
            success:function (rest) {
                console.log(rest);
                if (rest.code === "200"){
                    $("#tables").hide();
                    $("#detail_announcement").children().remove();
                    let ann = rest.object;
                    let htmls =
                        "<button onclick=\"returns()\"  type=\"button\" class=\"btn btn-secondary\">返回</button>"+"<div style=\"background: url(\""+ann.photo+"\")\">\n" +
                        "        <p>场馆名称："+ann.venue_name+"</p>\n" +
                        "        <p>开放时间："+ann.open_time+"</p>\n" +
                        "        <p>场馆类型："+ann.type+"</p>\n" +
                        "        <p>场馆位置："+ann.location+"</p>\n" +
                        "        <p>点击量："+ann.clink+"</p>\n" +
                        "        <p>最大参观量："+ann.capacity+"</p>\n" +
                        "        <p>场馆介绍："+ann.content+"</p> \n" +
                        "    </div>";
                    $("#detail_announcement").append(htmls);
                    $("#detail_announcement").show();
                }
            }
        })
    }

    function toUpdate(res) {
        $.ajax({
            url:"selectOneExhibit",
            type: "get",
            data: {"exhibit_id":res},
            dataType: "json",
            success:function (rest) {
                console.log(rest);
                if (rest.code === "200"){
                    $("#detail_announcement").hide();
                    $("#tables").hide();
                    $("#update_announcement").children().remove();
                    let ann = rest.object;
                    let htmls = "<form id=\"updateFrom\"'>\n" +
                        "        <input name=\"exhibit_id\" value=\""+ann.exhibit_id+"\" hidden>\n" +
                        "        <div class=\"form-group\">\n" +
                        "            <label for=\"exampleInputEmail1\">场馆名称</label>\n" +
                        "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" name=\"venue_name\" value=\""+ann.venue_name+"\">\n" +
                        "        </div>\n" +
                        "        <div class=\"form-group\">\n" +
                        "            <label for=\"exampleInputEmail2\">场馆类型</label>\n" +
                        "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail2\" name=\"type\" value=\""+ann.type+"\">\n" +
                        "        </div>\n" +
                        "        <div class=\"form-group\">\n" +
                        "            <label for=\"exampleInputEmail3\">场馆位置</label>\n" +
                        "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail3\" name=\"location\" value=\""+ann.location+"\">\n" +
                        "        </div>\n" +
                        "        <div>\n" +
                        "            <label for=\"exampleInputEmail4\">开放时间</label>\n" +
                        "            <input type=\"date\" name=\"open_time\" value=\""+ann.open_time+"\" id=\"exampleInputEmail4\">\n" +
                        "        </div>\n" +
                        "\n" +
                        "            <label for=\"exampleInputEmail5\">参观人数</label>\n" +
                        "            <input required type=\"text\" name=\"capacity\" value=\""+ann.capacity+"\" id=\"exampleInputEmail5\">\n" +
                        "        </div>\n" +
                        "\n" +
                        "            <label for=\"exampleInputEmail6\">点击次数</label>\n" +
                        "            <input type=\"text\" name=\"clink\" value=\""+ann.clink+"\" id=\"exampleInputEmail6\" readonly>\n" +
                        "            <label for=\"exampleInputEmail8\">场馆介绍</label>\n" +
                        "            <input type=\"text\" name=\"content\" value=\""+ann.content+"\" id=\"exampleInputEmail8\">\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <input type=\"submit\" id=\"updateAnnouncement\" class=\"btn btn-primary\">\n" +"<button onclick=\"returns()\"  type=\"button\" class=\"btn btn-secondary\">返回</button>"+
                        "    </form>";
                    $("#update_announcement").append(htmls);
                    $("#update_announcement").show();
                    $("#updateAnnouncement").click(function () {
                        let query = $("#updateFrom").serialize();
                        $.ajax({
                            url:"updateExhibit",
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
            url:"deleteExhibit",
            data:{"exhibit_id":res},
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
        $.ajax({
            url: "selectAllExhibit",
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
                        "        <span onclick=\"getDetail("+book.exhibit_id+")\">\n" +
                        "            "+book.exhibit_id+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"getDetail("+book.exhibit_id+")\">\n" +
                        "            "+book.open_time+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"getDetail("+book.exhibit_id+")\">\n" +
                        "            "+book.venue_name+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"toUpdate("+book.exhibit_id+")\">\n" +
                        "            修改\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td salign=\"center\">\n" +
                        "            <span onclick=\"toDelete("+book.exhibit_id+")\">\n" +
                        "            删除\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "    </tr>";
                    $("#tbody").append(html);
                }
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
        let htmls = "<form id=\"updateFroms\">\n" +
            "        <div class=\"form-group\">\n" +
            "            <label for=\"exampleInputEmail1\">场馆名称</label>\n" +
            "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" name=\"venue_name\" >\n" +
            "        </div>\n" +
            "        <div class=\"form-group\">\n" +
            "            <label for=\"exampleInputEmail2\">场馆类型</label>\n" +
            "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail2\" name=\"type\" >\n" +
            "        </div>\n" +
            "        <div class=\"form-group\">\n" +
            "            <label for=\"exampleInputEmail3\">场馆位置</label>\n" +
            "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail3\" name=\"location\" >\n" +
            "        </div>\n" +
            "        <div>\n" +
            "            <label for=\"exampleInputEmail4\">开放时间</label>\n" +
            "            <input type=\"date\" name=\"open_time\" id=\"exampleInputEmail4\">\n" +
            "        </div>\n" +
            "\n" +
            "            <label for=\"exampleInputEmail5\">参观人数</label>\n" +
            "            <input type=\"text\" name=\"capacity\" id=\"exampleInputEmail5\" required>\n" +
            "        </div>\n" +
            "\n" +
            "            <label for=\"exampleInputEmail8\">场馆介绍</label>\n" +
            "            <input type=\"text\" name=\"content\" id=\"exampleInputEmail8\">\n" +
            "        </div>\n" +
            "\n" +
            "        <input type=\"submit\" id=\"insertAnnouncement\" class=\"btn btn-primary\">\n" +"<button onclick=\"returns()\"  type=\"button\" class=\"btn btn-secondary\">返回</button>"+
            "    </form>";
        $("#update_announcement").append(htmls);
        $("#update_announcement").show();
        $("#insertAnnouncement").click(function () {
            let query = $("#updateFroms").serialize();
            $.ajax({
                url:"insertExhibit",
                type:"get",
                data:query,
                dataType:"json",
                success:function (ress) {
                    console.log(ress);
                    alert(ress.msg);
                    if (ress.code==="200"){
                        alert(ress.msg);
                    }
                    IfNext(true);
                }
            })
        })
    })


</script>
<script>
    $("#select").click(function () {
        $("#tbody").children().remove();
        $.ajax({
            url: "selectAllExhibitOfState",
            data: {"page": $("#pages").val(), "size": 10,"venue_name":$("#venue_name").val()},
            type: "get",
            dataType: "json",
            success: function (res) {
                $("#venue_name").val(venue_name);
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
                        "        <span onclick=\"getDetail("+book.exhibit_id+")\">\n" +
                        "            "+book.exhibit_id+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"getDetail("+book.exhibit_id+")\">\n" +
                        "            "+book.open_time+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"getDetail("+book.exhibit_id+")\">\n" +
                        "            "+book.venue_name+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"toUpdate("+book.exhibit_id+")\">\n" +
                        "            修改\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td salign=\"center\">\n" +
                        "            <span onclick=\"toDelete("+book.exhibit_id+")\">\n" +
                        "            删除\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "    </tr>";
                    $("#tbody").append(html);
                }
            }
        });
    })
</script>
