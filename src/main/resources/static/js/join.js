$(document).ready(function () {

    let regExp = /^[a-z0-9_-]{5,15}$/;
    let phoneNumberRegExp = /^([01]{2})([0|1|6|7|8|9]{1})([0-9]{3,4})([0-9]{4})$/;

    let memberIdResult = false;
    let passwordResult = false;
    let passwordResult2 = false;
    let emailResult = false;
    let emailResult2 = false;
    let phoneNumberResult = false;

    $("#memberId").blur(function () {
        $('#idError').css('color', '#ea3838');
        if ($("#memberId").val() === null || $("#memberId").val() === "") {
            $("#idError").text("필수 정보입니다.");
            memberIdResult = false;
        } else if (!regExp.test($("#memberId").val())) {
            $("#idError").text("5~15자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
            memberIdResult = false;
        } else {
            sendAjax("/idCheck", { memberId : $('#memberId').val()}, function () {
                    if (check === true) {
                        $("#idError").text('중복 아이디 입니다.');
                        return memberIdResult = false;
                    } else {
                        $('#idError').text('아이디 입력 성공!');
                        $('#idError').css('color', '#304b98');
                        return memberIdResult = true;
                    }
                },
                function (xhr) {
                    console.log(xhr.responseText);
                });
        }
    });

    $("#password").blur(function () {
        $('#pwError').css('color', '#ea3838');
        if ($("#password").val() === null || $("#password").val() === "") {
            $("#pwError").text("필수 정보입니다.");
            passwordResult = false;
        } else if (!regExp.test($("#password").val())) {
            $('#pwError').text('5~15자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.');
            passwordResult = false;
        } else {
            $("#pwError").text('비밀번호 입력 성공!');
            $('#pwError').css('color', '#304b98');
            passwordResult = true;
        }
    });

    $("#password2").blur(function () {
        $('#pwError2').css('color', '#ea3838');
        if ($("#password2").val() === null || $("#password2").val() === "") {
            $("#pwError2").text("필수 정보입니다.");
            passwordResult2 = false;
        } else if (!($("#password").val() === $("#password2").val())){
            $('#pwError2').text('비밀번호가 일치하지 않습니다.');
            passwordResult2 = false;
        } else {
            $("#pwError2").text('비밀번호 일치 성공!');
            $('#pwError2').css('color', '#304b98');
            passwordResult2 = true;
        }
    });

    $("#email").blur(function () {
        $('#emailError').css('color', '#ea3838');
        if ($("#email").val() === null || $("#email").val() === "") {
            $("#emailError").text("필수 정보입니다.");
            emailResult = false;
        } else if (!regExp.test($("#email").val())){
            $('#emailError').text('5~15자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.');
            emailResult = false;
        } else if ($("#email2").val() === null || $("#email2").val() === ""){
            $('#emailError').text('이메일 주소 선택은 필수입니다.');
            emailResult = true;
            emailResult2 = false;
        } else{
            $("#emailError").text('이메일 입력 성공');
            $('#emailError').css('color', '#304b98');
            emailResult = true;
            emailResult2 = true;
        }
    });

    $("#email2").blur(function () {
        $('#emailError').css('color', '#ea3838');
        if ($("#email2").val() === null || $("#email2").val() === "") {
            $('#emailError').text('필수 정보입니다.');
            emailResult2 = false;
        } else if ($("#email").val() === null || $("#email").val() === "") {
            $('#emailError').text('이메일 아이디를 입력해주세요.');
            emailResult = false;
            emailResult2 = true;
        }else{
            $("#emailError").text('이메일 입력 성공');
            $('#emailError').css('color', '#304b98');
            emailResult = true;
            emailResult2 = true;
        }
    });

    $("#phoneNumber").blur(function () {
        $('#phoneNumberError').css('color', '#ea3838');
        if ($("#phoneNumber").val() === null || $("#phoneNumber").val() === "") {
            $("#phoneNumberError").text("필수 정보입니다.");
            phoneNumberResult = false;
        } else if (!phoneNumberRegExp.test($("#phoneNumber").val())) {
            $('#phoneNumberError').text('형식에 맞지 않는 번호입니다. (-)제외하여 숫자만 정확히 입력해주세요.');
            phoneNumberResult = false;
        } else {
            $("#phoneNumberError").text('휴대전화 입력 성공!');
            $('#phoneNumberError').css('color', '#304b98');
            phoneNumberResult = true;
        }
    });


    $("#joinBtn").click(function () {
        if ($("#memberId").val() === null || $("#memberId").val() === "") {
            $("#idError").text("필수 정보입니다.");
        }
        if ($("#password").val() === null || $("#password").val() === "") {
            $("#pwError").text("필수 정보입니다.");
        }
        if ($("#password2").val() === null || $("#password2").val() === "") {
            $("#pwError2").text("필수 정보입니다.");
        }
        if ($("#email2").val() === null || $("#email2").val() === "") {
            $("#emailError").text("이메일 주소는 필수 정보입니다.");
        }
        if ($("#email").val() === null || $("#email").val() === "") {
            $("#emailError").text("필수 정보입니다.");
        }
        if ($("#phoneNumber").val() === null || $("#phoneNumber").val() === "") {
            $("#phoneNumberError").text("필수 정보입니다.");
        }

        if(memberIdResult && passwordResult && passwordResult2 && emailResult && emailResult2 && phoneNumberResult) {
            alert("회원가입을 축하합니다.");
            $("#joinBtn").attr('type',"submit");
        }
    });

    $("#cancelBtn").click(function () {
        window.location = "/"
    })
});