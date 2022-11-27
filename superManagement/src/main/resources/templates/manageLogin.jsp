<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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
<div >
    <form id="manageLogin">
        <div class="form-group">
            <label for="exampleInputEmail1">管理员编号</label>
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   name="manage_id" required>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">密码</label>
            <input name="password" type="password" class="form-control" id="exampleInputPassword1" required>
        </div>
        <div>
            是否保存密码
            <div class="form-check">
                <input class="form-check-input" type="radio" name="cook" id="exampleRadios1" value="是" checked>
                <label class="form-check-label" for="exampleRadios1">
                    是
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="cook" id="exampleRadios2" value="否">
                <label class="form-check-label" for="exampleRadios2">
                    否
                </label>
            </div>
        </div>
        选择头像：<input type="file" name="img" id="imgs">

        <input type="submit"  id="submitManage" class="btn btn-primary"></input>
    </form>

</div>

<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="..." class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="..." class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="..." class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-target="#carouselExampleControls" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-target="#carouselExampleControls" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </button>
</div>
</body>
</html>
<script>
    $(function () {
        $("#submitManage").click(function () {
            let jQuery = $("#manageLogin").serialize();
            let value = $("#imgs").value;
            $.ajax({
                url: "manageLogin",
                data: jQuery,
                type: "post",
                dataType: "json",
                success:function (res) {
                    console.log(res);
                if (res.code==="200"){
                    alert(res.msg);
                    window.location = "/museum/manageHome";
                }else {
                    alert(res.msg),
                    window.location.reload();
                }
                }
            })
        })

    })
</script>
