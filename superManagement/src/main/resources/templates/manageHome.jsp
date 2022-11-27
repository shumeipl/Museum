<html>
<head>
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
    <style>
        #principal {
            width: auto;
            /*border: 1px black solid;*/
            height: 890px;
            background-color: antiquewhite;
        }

        #top {
            width: auto;
            height: 100px;
            border-bottom: 1px black solid;
            text-align: center;
            padding-top: 10px;
        }

        #left {
            height: 890px;
            width: 200px;
            border-right: 1px black solid;
            float: left;
        }

        #right {
            float: right;
            height: 890px;
            width: 1000px;
            border-right: 1px black solid;
        }

        a {
            text-decoration: none;
        }

        .left_1 {
            text-align: center;
            color: black;
            font-size: x-large;
            margin-top: 10px;
        }

        .close {
            float: none;
        }

        .left {
            float: left;
            width: 60px;
            text-align: right;
        }

        .right {
            float: left;
        }
    </style>
    <script type="application/javascript">
        function deletes() {
            confirm("真的要删除账号吗？")
        }
    </script>
</head>
<body>
<div id="principal">
    <div id="top">
        <h1>博物馆管理系统</h1>
    </div>
    <div id="left">
            <div class="left_1">
                <a href="toAnnouncementManager" target="hu">公告管理</a>
            </div>
        <div class="left_1">
            <a href="toManagerManage" target="hu">修改资料</a>
        </div>
            <div class="left_1">
                <a href="toCollectionManage" target="hu">藏品管理</a>
            </div>
            <div class="left_1">
                <a href="toTimePlan" target="hu">安排员工工作表</a>
            </div>
            <div class="left_1">
                <a href="toExhibitManage" target="hu">展览管理</a>
            </div>
            <div class="left_1">
                <a href="toWorkerManage" target="hu">员工管理</a>
            </div>
    </div>
    <div id="right">
        <iframe name="hu" width="1100px" height="890px" style="margin-left: -100px"></iframe>
    </div>
</div>
</body>
</html>
