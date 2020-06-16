$(function () {
    $("#login-btn").click(validateData);
    $("#login-btn").click(submitData);
})

function validateData(evt) {
    evt.preventDefault();
    if ($("#username").val() == "" || $("#password").val() == "") {
        console.log("Error msg");
        evt.stopImmediatePropagation();
    }
}

function submitData() {
    console.log("thank you");
    const url="/login"
    $.post(url, {username: $("#username").val(), password:$("#password").val()}, function(data, status, xhr){
        alert(data);
        document.location.href= '/requisition'
    })
}