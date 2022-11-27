var PersonelCenter =  document.getElementById("PersonelCenter");
// 内容
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
loginOut.onclick = function (){
    window.location.href="/Login.jsp";
}

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
    // window.location.href("PersonnelCenter.jsp");
}
// 点击展览信息
displyInfo.onclick=function(){
    UpdatePW.className="l6";
    PersonelCenter.className="l5";
    displyInfo.className="slected";
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
    // window.location.href("PersonnelCenter.jsp");
}
// 点击排班信息
TimePlan.onclick=function(){
    UpdatePW.className="l6";
    PersonelCenter.className="l5";
    displyInfo.className="l1";
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
    UpdatePW.className="l6";
    PersonelCenter.className="l5";
    displyInfo.className="l1";
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
    // window.location.href("PersonnelCenter.jsp");
}
// 参观人数
Vistors.onclick=function(){
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