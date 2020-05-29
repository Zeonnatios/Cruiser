let iconMenu = document.getElementById('iconMenu');
let sidebar = document.getElementById('sidebar');
let mainContent = document.getElementById('mainContent');
let tb_produto = document.getElementById('tb_produto');
let tb_cliente = document.getElementById('tb_cliente');
let tb_carrinho = document.getElementById('tb_carrinho');
//let droplist = document.getElementById('drop-list');

function responsiveSidebar() {

    if (sidebar.style.display == 'none') {

        sidebar.style.display = 'block';
        mainContent.style.width = 'calc(100% - 300px);';
    } else {
        sidebar.style.display = 'none';
        mainContent.style.width = '100%';
    }

}


/* Lista ul li ao clicar*/

$(document).ready(function (e) {
    $('.drop-list').click(function () {
        $(this).toggleClass('tap');
    });
});

//verifica se os inputs estão vazios
function checkProdutoEmpty()
{
    let isEmpty = false,
            inputIDProd = document.getElementById('inputIDProd').value,
            inputNomeProd = document.getElementById('inputNomeProd').value,
            inputQuantProd = document.getElementById('inputQuantProd').value,
            inputPrecoProd = document.getElementById('inputPrecoProd').value;

    if (inputIDProd === '') {
        alert('Produto não selecionado!');
        isEmpty = true;
    } else if (inputNomeProd === '') {
        alert('po Produto não pode estar vazio!');
        isEmpty = true;
    } else if (inputQuantProd === '') {
        alert('Campo quantidade não pode estar vazio!');
        isEmpty = true;
    } else if (inputPrecoProd === '') {
        alert('Produto não selecionado!');
        isEmpty = true;
    }
    return isEmpty;
}

function checkClienteEmpty() {
    let isEmpty = false,
            inputIDCli = document.getElementById('inputIDCli').value,
            inputNomeCli = document.getElementById('inputNomeCli').value,
            inputCPFCli = document.getElementById('inputCPFCli').value;

    if (inputIDCli === '') {
        alert('Cliente não selecionado!');
        isEmpty = true;
    } else if (inputNomeCli === '') {
        alert('Cliente não selecionado!');
        isEmpty = true;
    } else if (inputCPFCli === '') {
        alert('Cliente não selecionado!');
        isEmpty = true;
    }
    return isEmpty;

}

function selectedRowProdutoToInput() {

    for (var i = 1; i < tb_produto.rows.length; i++)
    {
        tb_produto.rows[i].onclick = function ()
        {
            // get the selected row index
            rIndex = this.rowIndex;

            document.getElementById("codigoProduto").value = this.cells[0].innerHTML;
            document.getElementById("inputIDProd").value = this.cells[0].innerHTML;
            document.getElementById("inputNomeProd").value = this.cells[1].innerHTML;
            /*ocument.getElementById("inputQuantProd").value = this.cells[2].innerHTML;*/
            document.getElementById("inputPrecoProd").value = this.cells[3].innerHTML;
            /* alert('Digite a quantidade a ser vendida!');*/
        };
    }

}


function selectedRowClienteToInput() {

    for (var i = 1; i < tb_cliente.rows.length; i++)
    {
        tb_cliente.rows[i].onclick = function ()
        {
            // get the selected row index
            rIndex = this.rowIndex;
            document.getElementById("codigoCliente").value = this.cells[0].innerHTML;
            document.getElementById("inputIDCli").value = this.cells[0].innerHTML;
            document.getElementById("inputNomeCli").value = this.cells[1].innerHTML;
            document.getElementById("inputCPFCli").value = this.cells[2].innerHTML;

        };
    }

}



/* Adicionar linhas na tabela de carrinho de compras */

function addHtmlTableRow() {
    // get the table by id
    // create a new row and cells
    // get value from input text
    // set the values into row cell's

    let newRow = tb_carrinho.insertRow(tb_carrinho.length),
            cell1 = newRow.insertCell(0),
            cell2 = newRow.insertCell(1),
            cell3 = newRow.insertCell(2),
            cell4 = newRow.insertCell(3),
            inputIDProd = document.getElementById('inputIDProd').value,
            inputNomeProd = document.getElementById('inputNomeProd').value,
            inputPrecoProd = document.getElementById('inputPrecoProd').value;



    cell1.innerHTML = inputIDProd;
    cell2.innerHTML = inputNomeProd;
    cell4.innerHTML = inputPrecoProd;
    // call the function to set the event to the new row
    selectedRowToInput();
    alert("Hello! I am an alert box!!");

}
