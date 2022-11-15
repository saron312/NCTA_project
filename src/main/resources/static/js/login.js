$(document).ready(function (){
    $("#loginBtn").click(function (){
        if($("#memberId").val() === null || $("#memberId").val() === ""){
            $("#idError").text("아이디를 입력해주세요.");
            $("#memberId").focus();
        }else if($("#password").val() === null || $("#password").val() === ""){
            $("#pwError").text("비밀번호를 입력해주세요.");
            $("#password").focus();
        }else{
            $("#loginBtn").attr('type',"submit");
        }
    });

    $("#cancelBtn").click(function (){
        window.location="/"
    })
});