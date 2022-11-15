$(document).ready(function () {
    let passwordResult = false;
    // let ajaxResult = false;
    const regExp = /^[a-z0-9_-]{5,15}$/;

    $("#withdrawalBtn").click(function () {
        $("#staticBackdrop").modal();
    });

    $("#withdrawalPw").blur(function () {
        if ($("#withdrawalPw").val() === null || $("#withdrawalPw").val() === "") {
            $("#pwError").text("비밀번호를 입력해주세요");
            passwordResult = false;
        } else if (!regExp.test($("#withdrawalPw").val())) {
            $('#pwError').text('5~15자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.');
            passwordResult = false;
        } else {
            $.ajax({
                url: '/pwCheck',
                type: 'post',
                data: {password: $('#withdrawalPw').val()},
                dataType: 'json',
                success: function (check) {
                    if (check === true) {
                        $("#pwError").text('');
                        passwordResult = true;
                    } else {
                        $('#pwError').text('비밀번호가 일치하지 않습니다.');
                        passwordResult = false;
                    }
                },
                error: function () {
                    alert("통신 오류");
                    window.location = "/myInfo"
                }
            });
        }
    });

    $("#resultBtn").click(function () {
        if ($("#withdrawalPw").val() === null || $("#withdrawalPw").val() === "") {
            $("#pwError").text("비밀번호를 입력해주세요");
            $("#withdrawalPw").focus();
        }
        if (passwordResult) {
            alert("탈퇴가 완료되었습니다.");
            window.location="/withdrawal"
        }
    });
});