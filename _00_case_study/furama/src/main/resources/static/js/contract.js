$(document).ready(function () {
    $("#contractTable").on("click", ".displayAttachService", function (event) {
        let a = $(this);
        let id = a.attr("href");
        debugger;
        $.ajax({
            type: "GET",
            url: `/api/contracts/${id}/contract-details/`,
            success: function (data) {
                debugger;
                let content = '<thead class="">\n' +
                    '<tr>\n' +
                    '<th scope="col">#</th>\n' +
                    '<th scope="col">Name</th>\n' +
                    '<th scope="col">Unit</th>\n' +
                    '<th scope="col">Quantity</th>\n' +
                    '<th scope="col">Delete</th>\n' +
                    '</tr>\n' +
                    '</thead>\n' +
                    '<tbody>';
                for (let i = 0; i < data.length; i++) {
                    content += `<tr><td>${i + 1}</td>` + getContractDetail(data[i]);
                }
                content += '</tbody>';
                document.getElementById('contractDetailTable').innerHTML = content;
                $('#attachServiceModal').modal('show');
            }
        })
        event.preventDefault();
    });

    $("#contractTable").on("click", ".pickAttachService", function (event) {
        let a = $(this);
        let contractId = a.attr("href");
        $.ajax({
            type: "GET",
            url: `/api/attach-services/contract/${contractId}`,
            success: function (data) {
                let content = '<thead class="">\n' +
                    '<tr>\n' +
                    '<th scope="col">#</th>\n' +
                    '<th scope="col">Name</th>\n' +
                    '<th scope="col">Cost</th>\n' +
                    '<th scope="col">Status</th>\n' +
                    '<th scope="col">Unit</th>\n' +
                    '<th scope="col">Quantity</th>\n' +
                    '<th scope="col">Pick</th>\n' +
                    '</tr>\n' +
                    '</thead>\n' +
                    '<tbody>';
                for (let i = 0; i < data.length; i++) {
                    content += `<tr><td>${i + 1}</td>` + getAttachService(data[i]);
                }
                content += '</tbody>';
                document.getElementById('attachServicePickingTable').innerHTML = content;
                $('#newAttachServicePicking').modal('show');
            }
        })
        event.preventDefault();
    })
})

function getContractDetail(contractDetail) {
    return `<td>${contractDetail.attachService.attachServiceName}</td>
            <td>${contractDetail.attachService.attachServiceUnit}</td>
            <td>${contractDetail.quantity}</td>           
            <td>
            <a class="deleteContractDetail text-decoration-none" href="${contractDetail.contractDetailId}">Delete</a>
            </td>
            </tr>`;
}

function getAttachService(attachService) {
    return `<td>${attachService.attachServiceName}</td>
            <td>${attachService.attachServiceCost}</td>
            <td>${attachService.attachServiceStatus}</td>   
            <td>${attachService.attachServiceUnit}</td>     
            <td><input type="text" id="attachServiceQuantity" class="form-control" placeholder="1"></td>        
            <td>
            <button class="btn btn-dark"
             onclick="createContractDetail(\'' + ${attachService.attachServiceId} +'\',\''+ ${attachService.contractId} + '\')">Pick</button>
            </td>
            </tr>`;
}

function createContractDetail(attachServiceId, contractId) {
    debugger
    let contract = {
        contractId: contractId
    }
    let attachService = {
        attachServiceId: attachServiceId
    }
    let quantity = $('#attachServiceQuantity').val();
    let newContractDetail = {
        contract: contract,
        attachService: attachService,
        quantity: quantity
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newContractDetail),
        url: "/api/contract-details",
        success: function () {
            $('#newAttachServicePicking').modal('hide');
        }
    })
}