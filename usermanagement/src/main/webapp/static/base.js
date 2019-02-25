src='https://www.google.com/recaptcha/api.js'
src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"

const WS_URL = "http://localhost:8080";


/*
 * http://localhost:8080/person/?id={id}
 * Find any user with identifier
 * Request Type : GET
 *
 * */
function findUser(index) {

    return $.ajax({
        type: "GET",
        url: "" + WS_URL + "/person/?id=" + index + "",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        async: false,
        success: function (result) {
        },
        error: function (response) {
            alert('eror: ' + response.responseJSON.errors[0].defaultMessage);
        }
    });
}

/*
* http://localhost:8080/person/list
* Find All User
* Request Type : GET
*
* */
function getUsers() {

    return $.ajax({
        type: "GET",
        url: "" + WS_URL + "/person/list",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        async: false,
        success: function (result) {
        },
        error: function (response) {
            alert('eror');
        }
    });
}

/*
* http://localhost:8080/person/save
* Save user
* Request Type : POST
*
* */
function saveUser() {

    var userForm = $("#saveuserform").serializeArray().reduce(function(a, x) {
        a[x.name] = x.value;
        return a;
    }, {});

    var jsonObject = JSON.stringify(userForm);

    $.ajax({
        type: "POST",
        url: "" + WS_URL + "/person/save",
        dataType: "json",
        contentType : "application/json",
        data: jsonObject,
        success: function(){
            loadUserTable();
            alert('succes')
        },
        error: function (response) {
            alert('eror: ' + response.responseJSON.errors[0].defaultMessage);
        }
    });

}

/*
* http://localhost:8080/person/user
* Delete any user with id
* Request Type : GET
*
* */
function deleteUser(index) {

    $.ajax({
        type: "GET",
        url: "" + WS_URL + "/person/delete?id=" + index +"",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        async: false,
        success: function (result) {
            loadUserTable();
            document.getElementById('deleteusermodal').style.display = "none";
            alert('succes')
        },
        error: function (response) {
            alert('eror :' + response.responseJSON.errors[0].defaultMessage);
        }
    });

}

/*
* http://localhost:8080/person/update
* Update any user
* Request Type : POST
*
* */
function updateUser() {

    if (getCaptcha() == true ) {

        var userForm = $("#updateuserform").serializeArray().reduce(function (a, x) {
            a[x.name] = x.value;
            return a;
        }, {});

        var jsonObject = JSON.stringify(userForm);

        $.ajax({
            type: "POST",
            url: "" + WS_URL + "/person/update",
            dataType: "json",
            contentType: "application/json",
            data: jsonObject,
            success: function () {
                loadUserTable();
                document.getElementById('userupdatemodal').style.display = "none";
                alert('succes');
            },
            error: function (response) {
                alert('eror: ' + response.responseJSON.errors[0].defaultMessage);
            }
        });

    }

}

function loadUserTable() {

    document.getElementById("usertablebody").innerHTML = '<tbody></tbody>';

    var mydata = getUsers().responseJSON;
    var tableRef = document.getElementById('usertable').getElementsByTagName('tbody')[0];

    for(var i in mydata)
    {
        var newRow = tableRef.insertRow(tableRef.rows.length);
        var newCell;
        var newText;

        appendNewCell(newRow, newCell, newText, 0, mydata[i].identifier);
        appendNewCell(newRow, newCell, newText, 1, mydata[i].firstname);
        appendNewCell(newRow, newCell, newText, 2, mydata[i].lastname);
        appendNewCell(newRow, newCell, newText, 3, mydata[i].msisdn);
        appendNewCell(newRow, newCell, newText, 4, mydata[i].email);
        appendButtons(newRow, newCell, 5, mydata[i].identifier);

    }
}

function showUpdateModal(id) {
    document.getElementById('userupdatemodal').style.display='block';

    var updateUser = findUser(id).responseJSON;
    var updateUserForm = document.getElementById('updateuserform');

    document.getElementById("firstname").value = updateUser.firstname;
    document.getElementById("lastname").value = updateUser.lastname;
    document.getElementById("msisdn").value = updateUser.msisdn;
    document.getElementById("email").value = updateUser.email;
    document.getElementById("identifier").value = updateUser.identifier;

}

function showDeleteModal(id) {
    document.getElementById('deleteusermodal').style.display='block';

    document.getElementById("deleteidentifier").value = id;

}

function showSaveUserDiv() {
    document.getElementById("saveuserdiv").style.visibility = "visible";
}

function appendNewCell(newRow, newCell, newText, column, value) {
    newCell = newRow.insertCell(column);
    newText = document.createTextNode(value);
    newCell.appendChild(newText);
}

function appendButtons(newRow, newCell, columnindex, id) {
    newCell = newRow.insertCell(columnindex);
    newCell.innerHTML =
        "<i onclick='showUpdateModal(" +'"'+ id + '"' +")' class=\"fas fa-edit\" style=\"color:darkblue\"></i>" +
        "<i onclick='showDeleteModal("+'"'+  id + '"' +")' class=\"fas fa-trash-alt\" style=\"color:darkred\"></i>";
}

function getCaptcha()
{
    if(grecaptcha.getResponse().length == 0) {
        alert('Captcha should be valid!');
        return false;
    }
    return true;
}

function redirectToSwagger() {

    var win = window.open("" + WS_URL + "/swagger-ui.html#/person-controller", '_blank');
    win.focus();
}