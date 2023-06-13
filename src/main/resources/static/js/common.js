//ajax form send
function sendAjax(url, data, success, error, complete) {
    $.ajax({
        url: url,
        data: data,
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        type: "post",
        dataType: "json",
        success: success,
        error: error,
        complete: complete
    });
}


//ajax form send
function sendAjaxWithFile(url, data, success, error) {
    $.ajax({
        url: url,
        type: "POST",
        enctype: "multipart/form-data", // 파일업로드처리 시 필수
        processData: false,             // 파일업로드처리 시 필수
        contentType: false,             // 파일업로드처리 시 필수
        cache: false,
        data: data,
        dataType: "json",
        success: success,
        error: error
    });
}

