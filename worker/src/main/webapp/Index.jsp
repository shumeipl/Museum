<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.workers.pojo.Workers" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.workers.pojo.Exhibits" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
    <link rel="stylesheet" type="text/css" href="/Reset.css" />
    <link rel="stylesheet" type="text/css" href="/Index.css" />
</head>
<body>
<%
    Integer id = (Integer) request.getAttribute("workerId");
    String name = (String) request.getAttribute("name");
    String sex = (String) request.getAttribute("sex");
    String avator=(String) request.getAttribute("avator");
    String phone =(String) request.getAttribute("phone");
    String password=(String) request.getAttribute("password");
// 0  展览1 排班2 预约3 参观4 个人中心5 个人信息6 修改密码7
    Integer flag = 0;
    if (request.getAttribute("flag")!=null){
        flag = (int) request.getAttribute("flag");
    }
%>
<div class="all">
    <div class="fixed-left">
        <div class="picture-div">
            <img class="picture" src=${requestScope.avator}/>
            <div class="inputa"><%=name%></div>
            <div class="inputb">工作人员</div>
        </div>
        <ul class="left-check">
            <li id="displayInfo" class="l1"><span>展览信息管理</span></li>
            <li id="TimePlan" class="l2"><span>排班信息管理</span></li>
            <li id="Booking" class="l3"><span>预约记录管理</span></li>
            <li id="Vistors" class="l4"><span>参观人数管理</span></li>
            <li id="PersonelCenter" class="l5"><span>个人中心</span></li>
            <li id="UpdateInfo"  class="l6" style="display:none;color:white;font-size: small;height: 25px;line-height: 25px;font-weight: 600;"><span>>个人信息</span></li>
            <li id="UpdatePW"  class="l7" style="display:none;  color:white;font-size: small;height: 25px;line-height: 25px;font-weight: 600;"><span>>修改密码</span></li>
        </ul>
    </div>
    <div class="fixed-right-top">
        <ul style="display: flex;" class="b">
            <li style="color: #8a8a8a; font-weight: 500;"><%=name%>,你好</li>
            <li class="login-out">
                <img class="icon" src="/博物馆images/退出.png"/>
                <div id="loginOut" >退出</div>
            </li>
        </ul>
    </div>
    <div class="fixed-right-content" id="content">
        <!-- 个人中心展示 -->
        <div id="contentPersonelCenter" style="display: none;" class="content">
            <form action="/worker/Update" method="post">
                <br/><span class="wz">工作编号<span style="color: red;">*</span></span>
                <input name="work_id"  value=<%=id%> readonly />
                <br/><span class="wz">性别<span style="color: red;">*</span></span>
                <input name="sex" value=<%=sex%> readonly />
                <br/><span class="wz">姓名<span style="color: red;">*</span></span>
                <input name="name" value=<%=name%> readonly/>
                <br/>
                <span class="wz">联系电话</span>
                <input name="phone" oninput = "value=value.replace(/[^\d]/g,'')"  maxlength="11" value=<%out.println(phone);%> />
                <br/>
                <input type="submit" value="修改"  class="submit-button"/>
            </form>
        </div>
        <div id="updatePW1" style="display: none;" class="content">
            <form action="/worker/UpdatePW" method="post">
                <br/>
                <span class="wz">新密码</span>
                <input type="password" id="newPassword" placeholder="大小写字母或数字或_" name="newPassword" onkeyup="this.value=this.value.replace(/[^\w_]/g,'');" />
                <br/>
                <span class="wz">再次输入</span>
                <input type="password" id="TwiceNewPassword" name="TwiceNewPassword" onkeyup="this.value=this.value.replace(/[^\w_]/g,'');" />
                <br/>
                <input type="submit" value="提交"  class="submit-button"/>
            </form>
        </div>
        <div id="contentdisplayInfo" style="display: none;" class="content">
            <form action="/worker/displayExhibitsByType" method="post">
                <div>
                <div class="Search">
                    <input id="searchDisplatInfo" class="searchDisplatInfo" name="type" placeholder="输入场馆类型"/>
                    <input type="submit" class="submit"  value="搜索"/>
                </div>
                </div>
            </form>
            <table >
                <thead>
                <td>索引</td>
                <td>场馆名称</td>
                <td>场馆类型</td>
                <td>场馆图片</td>
                <td>场馆位置</td>
                <td>营业时间</td>
                <td>工作编号</td>
                <td>联系电话</td>
                </thead>
<%--                ----------------------------------------------------展览记录--%>
               <c:forEach items="${requestScope.exhibits}" var="f">
                   <tr>
                   <td>${f.exhibitId}</td>
                   <td>${f.venueName}</td>
                   <td>${f.type}</td>
                   <td><img style="height: 50px" width="50px" src=${f.photo}></td>
                   <td>${f.location}</td>
                   <td>${f.openTime}</td>
                   <td>${f.workId}</td>
                   <td>${f.phone}</td>
                </tr>
               </c:forEach>
            </table>
            <div class="bottom">
                <div class="Page-bottom">
                    <div id="pageDecf1" class="pageDec"><</div>
                    <input oninput="value=value.replace(/[^\d]/g,'')"  value=${requestScope.currentPagef1} id="pageNumsf1" class="pageNums"  />
                    <div id="pageIncf1" class="pageInc">></div>
                    <div style="font-size: smaller;display: block;margin-top: 8px" id="a1" >共${requestScope.MaxPageExhibit}页</div>
                </div>
            </div>
        </div>
<%--        --------------------------------------------------------------排班--%>
        <div id="contentTimePlan" style="display: none;" class="content">
            <form action="/worker/displayTimesPlanById" method="post">
                <div>
                <div class="Search">
                    <input id="searchTimePlan" class="searchDisplatInfo" name="id" placeholder="输入员工编号"/>
                    <input type="submit" class="submit"  value="搜索"/>
                </div>
                </div>
            </form>
            <table >
                <thead>
                <td>索引</td>
                <td>工作编号</td>
                <td>姓名</td>
                <td>排班图片</td>
                <td>发布日期</td>
                </thead>
            <c:forEach items="${requestScope.timesPlan}" var="f">
                <tr>
                    <td>${f.timeId}</td>
                <td>${f.workId}</td>
                 <td>${f.name}</td>
                    <td><img style="height: 40px; width: 40px;" src=${f.photo}></td>
                    <td>${f.createTime}</td>
                 </tr>
            </c:forEach>
            </table>
            <div class="bottom">
                <div class="Page-bottom">
                    <div id="pageDecf3" class="pageDec"><</div>
                    <input oninput="value=value.replace(/[^\d]/g,'')"  value=${requestScope.currentPagef3} id="pageNumsf3" class="pageNums"  />
                    <div id="pageIncf3" class="pageInc">></div>
                    <div style="font-size: smaller;display: block;margin-top: 8px" id="a3">共${requestScope.MaxPageTimesPlan}页</div>
                </div>
            </div>
        </div>
<%--        --------------------------------------------------------------预约--%>
        <div id="contentBooking" style="display: none;" class="content">
            <form action="/worker/displayBookingsByVenueName" method="post">
                <div>
                <div class="Search">
                    <input id="searchBooking" class="searchDisplatInfo" name="venueName" placeholder="输入场馆名"/>
                    <input type="submit" class="submit"  value="搜索"/>
                </div>
                </div>
            </form>
            <table >
                <thead>
                <td>预约单号</td>
                <td>场馆名称</td>
                <td>场馆类型</td>
                <td>预约时间</td>
                <td>预约内容</td>
                <td>工作编号</td>
                <td>用户ID</td>
                </thead>
                <c:forEach items="${requestScope.bookings}" var="f">
                    <tr>
                        <td>${f.bookingId}</td>
                        <td>${f.venueName}</td>
                        <td>${f.venueType}</td>
                        <td>${f.bookingTime}</td>
                        <td>${f.bookingContest}</td>
                        <td>${f.workerId}</td>
                        <td>${f.userId}</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="bottom">
                <div class="Page-bottom">
                    <div id="pageDecf2" class="pageDec"><</div>
                    <input oninput="value=value.replace(/[^\d]/g,'')"  value=${requestScope.currentPagef2}  id="pageNumsf2" class="pageNums"  />
                    <div id="pageIncf2" class="pageInc">></div>
                    <div style="font-size: smaller;display: block;margin-top: 8px" id="a2">共${requestScope.MaxPageBooking}页</div>
                </div>
            </div>
        </div>
<%--        -----------------------------------------------------------参与--%>
        <div id="contentVistors" style="display: none;" class="content">
            <table >
                <thead>
                <td>场馆名称</td>
                <td>场馆类型</td>
                <td>图片</td>
                <td>场馆位置</td>
                <td>工作编号</td>
                <td>展览人数</td>
                <td>登记日期</td>
                </thead>
                <c:forEach items="${requestScope.Attendences}" var="f">
                    <tr>
                        <td>${f.venue_name}</td>
                        <td>${f.venue_type}</td>
                        <td><img style="height: 50px; width: 50px;" src=${f.photo}></td>
                        <td>${f.location}</td>
                        <td>${f.workerId}</td>
                        <td>${f.number}</td>
                        <td>${f.open_time}</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="bottom">
                <div class="Page-bottom">
                    <div id="pageDecf4" class="pageDec"><</div>
                    <input oninput="value=value.replace(/[^\d]/g,'')" value=${requestScope.currentPagef4} id="pageNumsf4" class="pageNums"  />
                    <div id="pageIncf4" class="pageInc">></div>
                    <div style="font-size: smaller;margin-top: 8px">共${requestScope.MaxPageVistors}页</div>
                </div>
            </div>
        </div>

    </div>
</div>
<script>
    var PersonelCenter =  document.getElementById("PersonelCenter");
    var content = document.getElementById("content");
    var displyInfo = document.getElementById("displayInfo");
    var TimePlan = document.getElementById("TimePlan");
    var Booking = document.getElementById("Booking");
    var Vistors = document.getElementById("Vistors");
    var contentPersonelCenter = document.getElementById("contentPersonelCenter");
    var contentdisplayInfo = document.getElementById("contentdisplayInfo");
    var contentTimePlan=document.getElementById("contentTimePlan");
    var contentBooking = document.getElementById("contentBooking");
    var contentVistors = document.getElementById("contentVistors");
    var UpdateInfo = document.getElementById("UpdateInfo");
    var UpdatePW = document.getElementById("UpdatePW");
    var updatePw=document.getElementById("updatePW1");
    var loginOut = document.getElementById("loginOut");
    var newPassword = document.getElementById("newPassword");
    var TwiceNewPassword = document.getElementById("TwiceNewPassword");
    var a1= document.getElementById("a1");
    var a2 = document.getElementById("a1");
    var a3 = document.getElementById("a3");


    loginOut.onclick=function (){
        window.location.href="/Login.jsp";
    }
    if (<%=(flag==1)%>){
        f1();
    }
    else if (<%=(flag==2)%>){
        f2();
    }
    else if (<%=(flag==3)%>){
        f3();
    }
    else if (<%=(flag==4)%>){
        f4();
    }
    else if (<%=(flag==5)%>){
        f5();
    }
    else if (<%=(flag==6)%>){
        f6();
    }
    else if (<%=(flag==7)%>){
        f7();
        alert("两次密码输入不一致");
    }
    else if(<%=(flag==8)%>){
        f8();
    }
    function f1(){
        UpdatePW.className="l6";
        PersonelCenter.className="l5";
        displyInfo.className="slected";
        a1.style.display="block";
        contentPersonelCenter.style.display="none";
        UpdatePW.style.display="none";
        UpdateInfo.style.display="none";
        contentdisplayInfo.style.display="block";
        contentTimePlan.style.display="none";
        contentBooking.style.display="none";
        contentVistors.style.display="none";
        TimePlan.className="l2";
        Booking.className="l3";
        Vistors.className="l4";
        updatePw.style.display="none";
    }
    function f2(){
        UpdatePW.className="l6";
        PersonelCenter.className="l5";
        displyInfo.className="l1";
        a3.style.display="block";
        TimePlan.className="slected";
        contentPersonelCenter.style.display="none";
        contentdisplayInfo.style.display="none";
        contentTimePlan.style.display="block";
        contentBooking.style.display="none";
        UpdatePW.style.display="none";
        UpdateInfo.style.display="none";
        contentVistors.style.display="none";
        Booking.className="l3";
        Vistors.className="l4";
        contentPersonelCenter.style.display="none";
        updatePw.style.display="none";
    }
    function f3(){
        UpdatePW.className="l6";
        PersonelCenter.className="l5";
        displyInfo.className="l1";
        TimePlan.className="l2";
        a2.style.display="block";
        Booking.className="slected";
        contentPersonelCenter.style.display="none";
        UpdatePW.style.display="none";
        UpdateInfo.style.display="none";
        contentdisplayInfo.style.display="none";
        contentTimePlan.style.display="none";
        contentBooking.style.display="block";
        contentVistors.style.display="none";
        Vistors.className="l4";
        contentPersonelCenter.style.display="none";
        updatePw.style.display="none";
    }
    function f4(){
        PersonelCenter.className="slected";
        UpdateInfo.className="l7";
        UpdatePW.className="l6";
        contentPersonelCenter.style.display="none";
        UpdatePW.style.display="block";
        UpdateInfo.style.display="block";
        contentdisplayInfo.style.display="none";
        contentTimePlan.style.display="none";
        contentBooking.style.display="none";
        contentVistors.style.display="none";
        displyInfo.className="l1";
        TimePlan.className="l2";
        Booking.className="l3";
        Vistors.className="l4";
        updatePw.style.display="none";
    }
    function f5(){
        UpdatePW.className="l7";
        PersonelCenter.className="l5";
        contentPersonelCenter.style.display="block";
        UpdatePW.style.display="block";
        UpdateInfo.style.display="block";
        UpdateInfo.className="slected";
        contentdisplayInfo.style.display="none";
        contentTimePlan.style.display="none";
        contentBooking.style.display="none";
        contentVistors.style.display="none";
        displyInfo.className="l1";
        TimePlan.className="l2";
        Booking.className="l3";
        Vistors.className="l4";
        updatePw.style.display="none";
    }
    function f7(){
        UpdateInfo.className="l6";
        UpdatePW.className="slected";
        PersonelCenter.className="l5";
        contentPersonelCenter.style.display="none";
        UpdatePW.style.display="block";
        UpdateInfo.style.display="block";
        contentdisplayInfo.style.display="none";
        contentTimePlan.style.display="none";
        contentBooking.style.display="none";
        contentVistors.style.display="none";
        displyInfo.className="l1";
        TimePlan.className="l2";
        Booking.className="l3";
        Vistors.className="l4";
        updatePw.style.display="block";
    }
    //按钮触发
    UpdatePW.onclick=function(){
        UpdateInfo.className="l6";
        UpdatePW.className="slected";
        PersonelCenter.className="l5";
        contentPersonelCenter.style.display="none";
        UpdatePW.style.display="block";
        UpdateInfo.style.display="block";
        contentdisplayInfo.style.display="none";
        contentTimePlan.style.display="none";
        contentBooking.style.display="none";
        contentVistors.style.display="none";
        displyInfo.className="l1";
        TimePlan.className="l2";
        Booking.className="l3";
        Vistors.className="l4";
        updatePw.style.display="block";
    }
    UpdateInfo.onclick=function(){
        UpdatePW.className="l7";
        PersonelCenter.className="l5";
        contentPersonelCenter.style.display="block";
        UpdatePW.style.display="block";
        UpdateInfo.style.display="block";
        UpdateInfo.className="slected";
        contentdisplayInfo.style.display="none";
        contentTimePlan.style.display="none";
        contentBooking.style.display="none";
        contentVistors.style.display="none";
        displyInfo.className="l1";
        TimePlan.className="l2";
        Booking.className="l3";
        Vistors.className="l4";
        updatePw.style.display="none";
    }
    function f6(){
            UpdatePW.className="l7";
            PersonelCenter.className="l5";
            contentPersonelCenter.style.display="block";
            UpdatePW.style.display="block";
            UpdateInfo.style.display="block";
            UpdateInfo.className="slected";
            contentdisplayInfo.style.display="none";
            contentTimePlan.style.display="none";
            contentBooking.style.display="none";
            contentVistors.style.display="none";
            displyInfo.className="l1";
            TimePlan.className="l2";
            Booking.className="l3";
            Vistors.className="l4";
            updatePw.style.display="none";
    }
    // 点击了个人中心
    PersonelCenter.onclick=function(){
        PersonelCenter.className="slected";
        UpdateInfo.className="l7";
        UpdatePW.className="l6";
        contentPersonelCenter.style.display="none";
        UpdatePW.style.display="block";
        UpdateInfo.style.display="block";
        contentdisplayInfo.style.display="none";
        contentTimePlan.style.display="none";
        contentBooking.style.display="none";
        contentVistors.style.display="none";
        displyInfo.className="l1";
        TimePlan.className="l2";
        Booking.className="l3";
        Vistors.className="l4";
        updatePw.style.display="none";
    }
    // 点击展览信息
    displyInfo.onclick =function(){
        if (!<%=request.getAttribute("exhibits")!=null%>) {
            window.location.href = "/worker/displayExihibts/"+pageNumsf1.value;
        };
        UpdatePW.className="l6";
        PersonelCenter.className="l5";
        displyInfo.className="slected";
        a1.style.display="block";
        contentPersonelCenter.style.display="none";
        UpdatePW.style.display="none";
        UpdateInfo.style.display="none";
        contentdisplayInfo.style.display="block";
        contentTimePlan.style.display="none";
        contentBooking.style.display="none";
        contentVistors.style.display="none";
        TimePlan.className="l2";
        Booking.className="l3";
        Vistors.className="l4";
        updatePw.style.display="none";
    }
    // 点击排班信息
    TimePlan.onclick=function(){
        if (!<%=request.getAttribute("timesPlan")!=null%>) {
            window.location.href = "/worker/displayTimesPlan/"+pageNumsf3.value;
        };
        UpdatePW.className="l6";
        PersonelCenter.className="l5";
        displyInfo.className="l1";
        a3.style.display="block";
        TimePlan.className="slected";
        contentPersonelCenter.style.display="none";
        contentdisplayInfo.style.display="none";
        contentTimePlan.style.display="block";
        contentBooking.style.display="none";
        UpdatePW.style.display="none";
        UpdateInfo.style.display="none";
        contentVistors.style.display="none";
        Booking.className="l3";
        Vistors.className="l4";
        contentPersonelCenter.style.display="none";
        updatePw.style.display="none";
        // window.location.href("PersonnelCenter.jsp");
    }
    // 预约记录
    Booking.onclick=function(){
        if (!<%=request.getAttribute("bookings")!=null%>) {
            window.location.href = "/worker/displayBookings/"+pageNumsf2.value;
        };
        UpdatePW.className="l6";
        PersonelCenter.className="l5";
        displyInfo.className="l1";
        a2.style.display="block";
        TimePlan.className="l2";
        Booking.className="slected";
        contentPersonelCenter.style.display="none";
        UpdatePW.style.display="none";
        UpdateInfo.style.display="none";
        contentdisplayInfo.style.display="none";
        contentTimePlan.style.display="none";
        contentBooking.style.display="block";
        contentVistors.style.display="none";
        Vistors.className="l4";
        contentPersonelCenter.style.display="none";
        updatePw.style.display="none";
    }
    // 参观人数
    Vistors.onclick=function(){
        if (!<%=request.getAttribute("Attendences")!=null%>) {
            window.location.href = "/worker/displayAttendencePlan/"+pageNumsf4.value;
        };
        UpdatePW.className="l6";
        PersonelCenter.className="l5";
        displyInfo.className="l1";
        TimePlan.className="l3";
        contentPersonelCenter.style.display="none";
        contentPersonelCenter.style.display="none";
        contentdisplayInfo.style.display="none";
        UpdatePW.style.display="none";
        UpdateInfo.style.display="none";
        contentTimePlan.style.display="none";
        contentBooking.style.display="none";
        contentVistors.style.display="block";
        Booking.className="l3";
        Vistors.className="slected";
        updatePw.style.display="none";
        // window.location.href("PersonnelCenter.jsp");
    }
    function f8(){
        UpdatePW.className="l6";
        PersonelCenter.className="l5";
        displyInfo.className="l1";
        TimePlan.className="l3";
        contentPersonelCenter.style.display="none";
        contentPersonelCenter.style.display="none";
        contentdisplayInfo.style.display="none";
        UpdatePW.style.display="none";
        UpdateInfo.style.display="none";
        contentTimePlan.style.display="none";
        contentBooking.style.display="none";
        contentVistors.style.display="block";
        Booking.className="l3";
        Vistors.className="slected";
        updatePw.style.display="none";
    }
//    ----------------展览-------------------------------------------
    var pageNumsf1 = document.getElementById("pageNumsf1");
    var pageDecf1= document.getElementById("pageDecf1");
    var pageIncf1 = document.getElementById("pageIncf1");
    pageDecf1.onclick=function(){
        if(parseInt(pageNumsf1.value)>1){
            pageNumsf1.value=pageNumsf1.value-1;
            window.location.href = "/worker/displayExihibts/"+pageNumsf1.value;
        }
    }
    pageIncf1.onclick=function(){
        // 5模拟最大页数
        if(parseInt(pageNumsf1.value)<<%=(request.getAttribute("MaxPageExhibit"))%>){
            pageNumsf1.value=parseInt(pageNumsf1.value)+1;
            window.location.href = "/worker/displayExihibts/"+pageNumsf1.value;
        }
    }

//    -----------------------------预约-----------------------
    var pageNumsf2 = document.getElementById("pageNumsf2");
    var pageDecf2= document.getElementById("pageDecf2");
    var pageIncf2 = document.getElementById("pageIncf2");
    pageDecf2.onclick=function(){
        if(parseInt(pageNumsf2.value)>1){
            pageNumsf2.value=pageNumsf2.value-1;
            window.location.href = "/worker/displayBookings/"+pageNumsf2.value;
        }
    }
    pageIncf2.onclick=function(){
        // 5模拟最大页数
        if(parseInt(pageNumsf2.value)<<%=(request.getAttribute("MaxPageBooking"))%>){
            pageNumsf2.value=parseInt(pageNumsf2.value)+1;
            window.location.href = "/worker/displayBookings/"+pageNumsf2.value;
        }
    }
//    --------------------------排班时间------------------------
    var pageNumsf3 = document.getElementById("pageNumsf3");
    var pageDecf3= document.getElementById("pageDecf3");
    var pageIncf3 = document.getElementById("pageIncf3");
    pageDecf3.onclick=function(){
        if(parseInt(pageNumsf3.value)>1){
            pageNumsf1.value=pageNumsf3.value-1;
            window.location.href = "/worker/displayTimesPlan/"+pageNumsf3.value;
        }
    }
    pageIncf3.onclick=function(){
        // 5模拟最大页数
        if(parseInt(pageNumsf3.value)<<%=(request.getAttribute("MaxPageTimesPlan"))%>){
            pageNumsf3.value=parseInt(pageNumsf3.value)+1;
            window.location.href = "/worker/displayTimesPlan/"+pageNumsf3.value;
        }
    }
//    ---------------------------参观人数-----------------------
    var pageNumsf4 = document.getElementById("pageNumsf4");
    var pageDecf4= document.getElementById("pageDecf4");
    var pageIncf4 = document.getElementById("pageIncf4");
    pageDecf4.onclick=function(){
        if(parseInt(pageNumsf4.value)>1){
            pageNumsf4.value=pageNumsf4.value-1;
            window.location.href = "/worker/displayAttendencePlan/"+pageNumsf4.value;
        }
    }
    pageIncf4.onclick=function(){
        // 5模拟最大页数
        if(parseInt(pageNumsf4.value)<<%=request.getAttribute("MaxPageVistors")%>){
            pageNumsf4.value=parseInt(pageNumsf4.value)+1;
            window.location.href = "/worker/displayAttendencePlan/"+pageNumsf4.value;
        }
    }
</script>
</body>
</html>