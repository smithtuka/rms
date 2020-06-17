(function () {
    'use strict';
    $(function () {
        // Project JS

        $("#pjt-btn").click(projectModule.addProject);
        $("#submit-btn").click(submitData);
        $(".del-pjt-btn").each(function () {
            $(this).click(delProject);
        })
        $(".edit-pjt-btn").each(function () {
            $(this).click(editProject);
        })


    });
// functions
    let projectModule = (function () {
        //validate data

        const pArr = [];

        function addProject(e) {
            const projectName = $("#projectName").val();
            const budget = $("#budget").val();
            const supervisor = $("#supervisor").val();
            const description = $("#description").val();
            const del = $("<button>", {"class": "del-btn", "html": "delete"}).click(function () {
                $(this).parent().remove();
            });
            let row = $("<tr>");
            row.append($("<td>").text(projectName));
            row.append($("<td>").text(budget));
            row.append($("<td>").text(supervisor));
            row.append($("<td>").text(description));
            row.append(del);
            $("table").append(row);
            pArr.unshift({projectName: projectName, budget: budget, supervisor: supervisor, description: description})
            e.preventDefault();
            console.log(pArr[0]);
            // alert("first.." + pArr[0].projectName);
        }

        function projectsArr() {
            return pArr;
        }

        return {
            addProject: addProject,
            projArr: projectsArr
        }
    })();

    function submitData(evt) {
        const url = "/project"
        if (projectModule.projArr() != null) {
            // alert(projectModule.projArr() + " projects sent...")
            $.post(url, {projects: JSON.stringify(projectModule.projArr())}, function (data) {
                alert(data + " successfully created!!")
            })
        } else alert("please add at least one project...!");
        evt.stopImmediatePropagation();
    }

    function delProject() {
        let sel2 = (($(this).parent()).parent());
        let sel3 = (($(this).parent()).siblings(".p_id"));

        const url = `/project/${sel3.text()}`;
        alert(url);
        $.ajax(url, {
            method: "DELETE", success: function (data) {
                alert(data + " removed successfully!")
                sel3.parent().remove();
            }

        });


    }

    function editProject() {
        let sel2 = (($(this).parent()).parent());
        let sel3 = (($(this).parent()).siblings(".p_id")).text();
        alert(sel3);
        let sel4 = (($(this).parent()).siblings(".p_name")).text();
        let sel5 = (($(this).parent()).siblings(".p_budget")).text();
        let sel6 = (($(this).parent()).siblings(".p_description")).text();
        let sel7 = (($(this).parent()).siblings(".p_supervisor")).text();

        let txt;
        let name = prompt("Project Name:", sel4);
        let budget = prompt("Budget:", sel5);
        let description = prompt("Description:", sel6);
        let supervisor = prompt("Supervisor:", sel7);
        if (name == null || name == "" || budget == null || budget == "" || supervisor == null || supervisor == "" || description == null || description == "") {
            alert("invalid changes..");
            // comapre with old data also..
        }
        // document.getElementById("demo").innerHTML = txt;


        const url = `/project/${sel3}`;
        alert(url);
        $.ajax(url, {
            method: "PUT",
            data: {project: JSON.stringify({
                id: parseInt(sel3),
                projectName:name,
                budget: 78,
                supervisorId: 5,
                description: "description"
            })},
            success: function (data) {
                alert(data + " edited successfully!")
                // sel3.parent().remove(); // refresh page here - do it better
                window.location.replace("http://localhost:8080/project");
                // document.location.href = "/project";
            },
            error: function (xhr, status, error) {
                $('#msg').html('<span style=\'color:red;\'>' + error + '</span>')
            }

        });


    }


})
();