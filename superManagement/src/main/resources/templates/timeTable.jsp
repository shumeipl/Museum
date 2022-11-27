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
            <td scope="col" align="center">排班编号</td>
            <td scope="col" align="center">工作编号</td>
            <td scope="col" align="center">发布日期</td>
            <td scope="col" align="center">排班内容</td>
            <td scope="col" align="center">场馆编号</td>
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
            <input id="pages" name="page" value="1" hidden>
            <input id="currents" name="current" value="0" hidden>
        </nav>
        </tfoot>
        <div class="input-group mb-3">
            <form id="selects">
                <input type="text" class="form-control" id="name" placeholder="请输入场馆名称"  name="name" value="">
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
            url:"selectOneTimePlan",
            type: "get",
            data: {"time_id":res},
            dataType: "json",
            success:function (rest) {
                console.log(rest);
                if (rest.code === "200"){
                    $("#tables").hide();
                    $("#detail_announcement").children().remove();
                    let ann = rest.object;
                    let htmls =
                        "<button onclick=\"returns()\"  type=\"button\" class=\"btn btn-secondary\">返回</button>"+"<div style=\"background: url(\""+ann.photo+"\")\">\n" +
                        "        <p>排班编号："+ann.time_id+"</p>\n" +
                        "        <p>工作编号："+ann.work_id+"</p>\n" +
                        "        <p>发布时间："+ann.creat_time+"</p>\n" +
                        "        <p>排班内容："+ann.contest+"</p> \n" +
                        "        <p>场馆编号："+ann.exhibit_id+"</p> \n" +
                        "    </div>";
                    $("#detail_announcement").append(htmls);
                    $("#detail_announcement").show();
                }
            }
        })
    }

    function toUpdate(res) {
        $.ajax({
            url:"selectOneTimePlan",
            type: "get",
            data: {"time_id":res},
            dataType: "json",
            success:function (rest) {
                console.log(rest);
                if (rest.code === "200"){
                    $("#detail_announcement").hide();
                    $("#tables").hide();
                    $("#update_announcement").children().remove();
                    let ann = rest.object;
                    let htmls = "<form id=\"updateFrom\"'>\n" +
                        "        <input name=\"time_id\" value=\""+ann.time_id+"\" hidden>\n" +
                        "        <div class=\"form-group\">\n" +
                        "            <label for=\"exampleInputEmail1\">工作编号</label>\n" +
                        "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" name=\"work_id\" value=\""+ann.work_id+"\">\n" +
                        "        </div>\n" +
                        "        <div class=\"form-group\">\n" +
                        "            <label for=\"exampleInputEmail2\">发布时间</label>\n" +
                        "            <input type=\"date\" class=\"form-control\" id=\"exampleInputEmail2\" name=\"creat_time\" value=\""+ann.creat_time+"\">\n" +
                        "        </div>\n" +
                        "        <div class=\"form-group\">\n" +
                        "            <label for=\"exampleInputEmail3\">排班内容</label>\n" +
                        "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail3\" name=\"contest\" value=\""+ann.contest+"\">\n" +
                        "        </div>\n" +
                        "        <div>\n" +
                        "            <label for=\"exampleInputEmail4\">场馆编号</label>\n" +
                        "            <input type=\"text\" name=\"exhibit_id\" value=\""+ann.exhibit_id+"\" id=\"exampleInputEmail4\">\n" +
                        "        </div>\n" +
                        "\n" +
                        "        <input type=\"submit\" id=\"updateAnnouncement\" class=\"btn btn-primary\">\n" +"<button onclick=\"returns()\"  type=\"button\" class=\"btn btn-secondary\">返回</button>"+
                        "    </form>";
                    $("#update_announcement").append(htmls);
                    $("#update_announcement").show();
                    $("#updateAnnouncement").click(function () {
                        let query = $("#updateFrom").serialize();
                        $.ajax({
                            url:"updateTimePlan",
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
            url:"deleteTimePlan",
            data:{"time_id":res},
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
            url: "selectAllTimePlan",
            data: {"page": $("#pages").val(), "size": 10,"exhibit_id":$("#name").val()},
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
                        "        <span onclick=\"getDetail("+book.time_id+")\">\n" +
                        "            "+book.time_id+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"getDetail("+book.time_id+")\">\n" +
                        "            "+book.work_id+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"getDetail("+book.time_id+")\">\n" +
                        "            "+book.creat_time+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"getDetail("+book.time_id+")\">\n" +
                        "            "+book.contest+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"getDetail("+book.time_id+")\">\n" +
                        "            "+book.exhibit_id+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"toUpdate("+book.time_id+")\">\n" +
                        "            修改\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td salign=\"center\">\n" +
                        "            <span onclick=\"toDelete("+book.time_id+")\">\n" +
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
            url: "selectAllWorkersList",
            data: "",
            type: "get",
            dataType: "json",
            success: function (res) {
                var bookList = res;
                let html = "  <div class=\"form-group\">\n" +
                    "    <label for=\"exampleFormControlSelect1\">工作编号</label>\n" +
                    "    <select multiple class=\"form-control\" id=\"exampleFormControlSelect1\" name=\"work_id\">\n";
                for (var i = 0; i < bookList.length; i++) {
                    var book = bookList[i];
                    html += "      <option>" + book.work_id + "</option>\n";
                }
                html += "    </select>";

                $.ajax({
                    url: "selectAllExhibitList",
                    data: "",
                    type: "get",
                    dataType: "json",
                    success: function (res) {
                        var bookList = res;
                        let htmlt = "  <div class=\"form-group\">\n" +
                            "    <label for=\"exampleFormControlSelect0\">工作编号</label>\n" +
                            "    <select multiple class=\"form-control\" id=\"exampleFormControlSelect0\" name=\"exhibit_id\">\n";
                        for (var i = 0; i < bookList.length; i++) {
                            var book = bookList[i];
                            htmlt += "      <option>" + book.exhibit_id + "</option>\n";
                        }
                        htmlt += "    </select>";
                        $("#detail_announcement").hide();
                        $("#tables").hide();
                        $("#update_announcement").children().remove();
                        let htmls = "<form id=\"updateFrom\"'>\n" + html +
                            "        <div class=\"form-group\">\n" +
                            "            <label for=\"exampleInputEmail2\">发布日期</label>\n" +
                            "            <input type=\"date\" class=\"form-control\" id=\"exampleInputEmail2\" name=\"creat_time\" >\n" +
                            "        </div>\n" +
                            "        <div class=\"form-group\">\n" +
                            "            <label for=\"exampleInputEmail3\">排班内容</label>\n" +
                            "            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail3\" name=\"contest\" >\n" +
                            "        </div>\n" +
                            htmlt +
                            "\n" +
                            "        <input type=\"submit\" id=\"insertAnnouncement\" class=\"btn btn-primary\">\n" +"<button onclick=\"returns()\"  type=\"button\" class=\"btn btn-secondary\">返回</button>"+
                            "    </form>";
                        $("#update_announcement").append(htmls);
                        $("#update_announcement").show();
                        $("#insertAnnouncement").click(function () {
                            let query = $("#updateFrom").serialize();
                            $.ajax({
                                url:"insertTimePlan",
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

                    }
                })
            }
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
