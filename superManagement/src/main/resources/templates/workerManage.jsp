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
            <td scope="col" align="center">员工编号</td>
            <td scope="col" align="center">员工姓名</td>
            <td scope="col" align="center">联系方式</td>
            <td scope="col" align="center">删除</td>
        </tr>
        </thead>
        <tbody id="tbody">

        </tbody>
        <tfoot>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item">
                    <button class="page-link" id="unassigned" value="unassigned">未分配的工号列表</button>
                </li>
                <li class="page-item">
                    <button class="page-link" id="allWorkers" value="allWorkers">所有员工列表</button>
                </li>
                <li class="page-item">
                    <button class="page-link" id="last">上一页</button>
                </li>
                <li class="page-item">
                    <button class="page-link" id="next">下一页</button>
                </li>
                <li class="page-item">
                    <button class="page-link" id="addAnnouncement">添加员工</button>
                </li>
            </ul>
            <input id="pages" name="page" value="1" hidden>
            <input id="currents" name="current" value="0" hidden>
            <input id="state" name="state" value="allWorkers" hidden>
        </nav>
        </tfoot>
        <div class="input-group mb-3">
            <form id="selects">
                <input type="text" class="form-control" id="name" placeholder="请输入员工名字或电话号码"  name="name" value="">
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
            url:"selectWorkByID",
            type: "get",
            data: {"work_id":res},
            dataType: "json",
            success:function (rest) {
                console.log(rest);
                if (rest.code === "200"){
                    $("#tables").hide();
                    $("#detail_announcement").children().remove();
                    let ann = rest.object;
                    let htmls =
                        "<button onclick=\"returns()\"  type=\"button\" class=\"btn btn-secondary\">返回</button>"+"<div style=\"background: url(\""+ann.avatar+"\")\">\n" +
                        "        <p>员工编号"+ann.work_id+"</p>\n" +
                        "        <p>员工姓名"+ann.workname+"</p>\n" +
                        "        <p>员工性别："+ann.sex+"</p>\n" +
                        "        <p>联系电话："+ann.phone+"</p>\n" +
                        "    </div>";
                    $("#detail_announcement").append(htmls);
                    $("#detail_announcement").show();
                }
            }
        })
    }

    function returns() {
        IfNext(true);
    }

    function toDelete(res) {
        $.ajax({
            url:"deleteWork",
            data:{"work_id":res},
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
        }

        // let val = $("#state").val();
        // if (val==="allWorkers"){
        $.ajax({
            url: "selectAllWorkers",
            data: {"page": $("#pages").val(), "size": 10,"name":$("#name").val(),"state":$("#state").val()},
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
                        "        <span onclick=\"getDetail("+book.work_id+")\">\n" +
                        "            "+book.work_id+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"getDetail("+book.work_id+")\">\n" +
                        "            "+book.workname+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td align=\"center\">\n" +
                        "            <span onclick=\"getDetail("+book.work_id+")\">\n" +
                        "            "+book.phone+"\n" +
                        "        </span>\n" +
                        "        </td>\n" +
                        "        <td salign=\"center\">\n" +
                        "            <span onclick=\"toDelete("+book.work_id+")\">\n" +
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

    $("#allWorkers").click(function () {
        let state = $(this).val();
        $("#state").val(state);
        $("#tbody").children().remove();
        IfNext(false);
    })

    $("#unassigned").click(function () {
        let state = $(this).val();
        $("#state").val(state);
        $("#tbody").children().remove();
        IfNext(false);
    })

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
            url:"insertWork",
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

    $("#select").click(function () {
        let serialize = $("#selects").serialize();
        $("#tbody").children().remove();
        IfNext(false);
    })
</script>
