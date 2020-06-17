$(function () {
    $('#err-message').hide();
    $("#login-btn").click(validateData);
    $("#login-btn").click(submitData);
    $("#update_prof").click(handleUpdate);
    $("#logout_btn").click(handleLogout);
})
function handleLogout() {
    const url="/logout"

    $.post(url,{}, function(data, status, xhr){
        document.location.href= '/login'
    })
}

function validateData(evt) {
    evt.preventDefault();
    if ($("#email").val() == "" || $("#password").val() == "") {
        $('#err-message').show();
        setTimeout(function () {
            $('#err-message').fadeOut("slow");
        }, 2000)
        $('#err-message').text("Error: Input all required fields")
        evt.stopImmediatePropagation();
    }
}

function submitData() {
    const url="/login"

    $.post(url, {email: $("#email").val(), username: $("#username").val(), password:$("#password").val(), edit: JSON.stringify(false)}, function(data, status, xhr){
        document.location.href= '/requisition'
    })
}

function handleUpdate() {
    console.log("reached")
    const url = "/login";
    const user = {email: $("#update_email").val(), username: $("#update_name").val(), userId: $("#update_id").val(), password: $("#update_password").val()}

    $.post(url, {user: JSON.stringify(user), edit: JSON.stringify(true)}, function () {
        document.location.href = '/requisition'
    })
}

