(function () {
    'use strict';
    $(function () {
        // Project JS

        $("#pjt-btn").click(projectModule.addProject);
        $("#submit-btn").click(submitData);





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
            const del = $("<button>", {"class": "del-btn", "html": "delete"}).click(function(){
                $(this).parent().remove();});
            let row = $("<tr>");
            row.append($("<td>").text(projectName));
            row.append($("<td>").text(budget));
            row.append($("<td>").text(supervisor));
            row.append($("<td>").text(description));
            row.append(del);
            $("table").append(row);
            pArr.unshift({projectName:projectName,budget:budget,supervisor:supervisor,description:description})
            e.preventDefault();
            console.log(pArr[0]);
            alert("first.."+ pArr[0].projectName);
        }
        function projectsArr(){
            return pArr;
        }

        return {
            addProject: addProject,
            projArr: projectsArr
        }
    })();

    function submitData(evt) {
        const url ="/project"
        if(projectModule.projArr()!= null) {
            alert(projectModule.projArr() + " projects sent...")
            $.post(url, {projects: JSON.stringify(projectModule.projArr())}, function (data) {
                alert(data + " successfully created!!")
            })
        }
        else alert("please add at least one project...!");
        evt.stopImmediatePropagation();
    }


})();