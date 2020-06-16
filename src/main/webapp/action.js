(function () {
    $(function () {

        let submit_btn = $("#submit-btn");
        submit_btn.attr("disabled", true);
        submit_btn.click(submitData);

        let pdt_btn = $("#pdt-btn");
        pdt_btn.click(validateData);
        pdt_btn.click(saveData);
        pdt_btn.click(displayData);
    })

    let productList = [];

    function validateData(evt) {
        evt.preventDefault();
        if ($("#name").val() === "" || $("#price").val() === ""
            || $("#quantity").val() === "" || $("#req-date").val() === "") {
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
        $("#pdt-form").get(0).reset();

        let product = {
            name: name,
            price: price,
            quantity: quantity
        };
        productList.push(product);
    }

    function displayData() {
        let total = 0;
        productList.forEach(product => {
            total += (product.price * product.quantity);
        })

        $("#total").text(total);
    }

    function submitData() {

        let requisition = {
            creationDate: new Date(),
            requiredDate: new Date($("#req-date").val()),
            productLine: productList,
        }

        $.post("requisition", {requisition: JSON.stringify(requisition)}, function () {
            document.location.href= '/requisition';
        });

    }
})();

