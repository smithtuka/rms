(function () {
    let projectId = "";
    let total;
    let productList = [];

    $(function () {

        let submit_btn = $("#submit-btn");
        submit_btn.attr("disabled", true);
        submit_btn.click(submitData);

        let pdt_btn = $("#pdt-btn");
        pdt_btn.click(validateData);
        pdt_btn.click(saveData);
        pdt_btn.click(displayData);

        $(".del-btn").each(function () {
            $(this).click(deleteRequisition);
        });

        $("#project").change(function(){
            projectId = $(this).children("option:selected").val();
            console.log(projectId);
        });
    })

    function deleteRequisition() {
        let element = $(this);
        let str = element.attr("id").replace("btn_", "");
        let url = `/requisition/${str}`;
        $.ajax(url, {
            method: 'DELETE',
            success: function (data) {
                console.log(data);
                element.parents("tr").remove();
            }
        })
    }

    function validateData(evt) {
        evt.preventDefault();
        if ($("#name").val() === "" || $("#price").val() === ""
            || $("#quantity").val() === "" || $("#req-date").val() === "" || projectId === "") {
            console.log("Empty");
            evt.stopImmediatePropagation();
        }
    }

    function saveData(evt) {
        evt.preventDefault();
        $("#submit-btn").attr("disabled", false);
        let name = $("#name").val();
        let price = $("#price").val();
        let quantity = $("#quantity").val();

        let product = {
            name: name,
            price: price,
            quantity: quantity,
        };
        productList.push(product);
    }

    function calculateTotal() {
        total = 0;
        productList.forEach(product => {
            total += (product.price * product.quantity);
        })
    }

    function displayData() {
        calculateTotal();
        let name = $("#name").val();
        let price = $("#price").val();
        let quantity = $("#quantity").val();
        $("#total").text(total);
        let row = $("<tr>");
        row.append($("<td>").text(name));
        row.append($("<td>").text(price));
        row.append($("<td>").text(quantity));
        row.append($("<td>").text(quantity * price));
        row.append($("<td>")
            .append("<button>").addClass("del-btn").text("Delete").click(deleteAddedItem));
        $("#req_table").append(row);
        $("#pdt-form").get(0).reset();
    }

    function deleteAddedItem() {
        let productName = $(this).parents("tr")
            .children(":first-child").text();

        productList = productList.filter(e => e.name !== productName);
        calculateTotal();
        $("#total").text(total);
        $(this).parents("tr").remove();
        $("#pdt-form").get(0).reset();
    }

    function submitData() {

        let requisition = {
            creationDate: new Date(),
            requiredDate: new Date($("#req-date").val()),
            productLine: productList,
            projectId: parseInt(projectId)
        }

        $.post("requisition", {requisition: JSON.stringify(requisition)}, function () {
            document.location.href = '/requisition';
        });

    }
})();

