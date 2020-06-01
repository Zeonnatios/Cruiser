<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TADES - CARRINHO</title>

        <!-- Icon Logo-->
        <link rel="icon" href="imagens/LOGO_CRUISER.png">

        <!-- Bootstrap -->
        <link rel="stylesheet" href="libs/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome-->
        <link rel="stylesheet" href="libs/fontawesome-free-5.13.0-web/css/all.min.css">
        <!-- CSS -->
        <link rel="stylesheet" href="css/all.css">

    </head>

    <body>

        <div class="flex-dashboard">

            <!-- SIDEBAR -->
            <sidebar id="sidebar">

                <div class="sidebar-tittle">
                    <img src="imagens/LOGO_CRUISER_02.png" alt="TADES_logo">
                </div>

                <!-- MENU -->
                <div class="menu">

                    <c:if test="${sessionScope.f != null}">

                        <ul>

                            <li class="foto-user">
                                <img src="imagens/AVATAR_CRUISER01.png" alt="">
                                <h4>${sessionScope.f.getNome()}</h4>
                                <p>${sessionScope.f.getDepartamento()}</p>
                                <p>${sessionScope.f.getCidade()}</p>
                            </li>

                            <li>
                                <a href="<%= request.getContextPath()%>/home" class="active"> <i class="fas fa-home "></i> PRINCIPAL</a>
                            </li>


                            <c:if test="${sessionScope.f.getDepartamento() == 'Tecnologia'}">

                                <li class="drop-list">
                                    <a href="#"><i class="fas fa-user-friends "></i> FUNCIONARIOS <i class="fas fa-caret-down"></i></a>
                                    <ul>
                                        <li><a href="<%= request.getContextPath()%>/protegido_listar_funcionarios"><i class="fas fa-circle"></i> Listar Funcionários</a></li>
                                        <li><a href="<%= request.getContextPath()%>/protegido_funcionario_novo"><i class="fas fa-circle"></i> Gerenciar Funcionários</a></li>
                                    </ul>
                                </li>

                            </c:if>
                            <c:if test="${sessionScope.f.getDepartamento() == 'Tecnologia' or sessionScope.f.getDepartamento() == 'Vendas' or sessionScope.f.getDepartamento() == 'Gerencia' or sessionScope.f.getDepartamento() == 'Diretoria'}" >

                                <li class="drop-list">
                                    <a href="#"><i class="fas fa-cart-arrow-down"></i> ORDEM DE VENDA  <i class="fas fa-caret-down"></i></a>
                                    <ul>
                                        <li><a href="#"><i class="fas fa-circle"></i> Carrinho</a></li>
                                        <li><a href="<%= request.getContextPath()%>/protegido_vendaPeriodo"><i class="fas fa-circle"></i> Pesquisa venda período</a></li>
                                        <li><a href="<%= request.getContextPath()%>/protegido_vendaDetalhada"><i class="fas fa-circle"></i> Pesquisa venda detalhada</a></li>
                                    </ul>
                                </li>

                            </c:if>
                            <c:if test="${sessionScope.f.getDepartamento() == 'Tecnologia' or sessionScope.f.getDepartamento() == 'Marketing/Produtos'}">

                                <li class ="drop-list">
                                    <a href="#"><i class="fas fa-suitcase "></i> PRODUTOS <i class="fas fa-caret-down"></i></a>
                                    <ul>
                                        <li><a href="<%= request.getContextPath()%>/protegido_listar_produtos"><i class="fas fa-circle"></i> Listar Produtos</a></li>
                                        <li><a href="<%= request.getContextPath()%>/protegido_produto_novo"><i class="fas fa-circle"></i> Gerenciar Produtos</a></li>
                                    </ul>
                                </li>

                            </c:if>
                            <c:if test="${sessionScope.f.getDepartamento() == 'Tecnologia' or sessionScope.f.getDepartamento() == 'Vendas'}" >

                                <li class ="drop-list">
                                    <a href="#"><i class="fas fa-user "></i> CLIENTES <i class="fas fa-caret-down"></i></a>
                                    <ul>
                                        <li><a href="<%= request.getContextPath()%>/protegido_listar_clientes"><i class="fas fa-circle"></i> Listar Clientes</a></li>
                                        <li><a href="<%= request.getContextPath()%>/protegido_cliente_novo"><i class="fas fa-circle"></i> Gerenciar Clientes</a></li>
                                    </ul>
                                </li>

                            </c:if>
                            <c:if test="${sessionScope.f.getDepartamento() == 'Tecnologia' or sessionScope.f.getDepartamento() == 'Gerencia' or sessionScope.f.getDepartamento() == 'Diretoria'}" >

                                <li class="drop-list">
                                    <a href="# "><i class="fas fa-poll "></i> RELATÓRIOS  <i class="fas fa-caret-down"></i></a>
                                    <ul>
                                        <li><a href="<%= request.getContextPath()%>/protegido_diario"><i class="fas fa-circle"></i> Diário</a></li>
                                        <li><a href="<%= request.getContextPath()%>/protegido_mensal"><i class="fas fa-circle"></i> Mensal</a></li>
                                    </ul>
                                </li>

                            </c:if>
                            <c:if test="${sessionScope.f.getDepartamento() == 'Tecnologia'}" >

                                <li class ="drop-list">
                                    <a href="# "><i class="fas fa-globe-americas  "></i> FILIAIS  <i class="fas fa-caret-down"></i></a>
                                    <ul>
                                        <li><a href="<%= request.getContextPath()%>/protegido_listar_filiais"><i class="fas fa-circle"></i> Listar Filiais</a></li>
                                        <li><a href="<%= request.getContextPath()%>/protegido_filial_novo"><i class="fas fa-circle"></i> Gerenciar Filiais</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </c:if>

                    </c:if>

                </div>

            </sidebar>
            <!-- Fim sidebar-->


            <!-- MAIN-->
            <main id="mainContent">


                <!-- HEADER -->
                <header>
                    <h2><i id="iconMenu" onclick="responsiveSidebar()" class="fas fa-bars"></i></h2>
                    <h2><i class="fas fa-cart-arrow-down"></i> CARRINHO</h2>
                </header>

                <!-- MAIN conteÃºdo -->
                <div class="main-content">
                    <!-- container-->
                    <div class="container">

                        <!-- FORM PARA INSERIR PRODUTOS NO CARRINHO -->
                        <form action="CarrinhoServlet" method="post">

                            <!-- row-->
                            <div class="row">

                                <!-- Coluna esquerda-->
                                <div class="col">

                                    <!-- ID PRODUTO  -->
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">ID PRODUTO: </label>
                                        <div class="col-lg-8">
                                            <input type="number" class="form-control" id="codigoProduto" name="codigo" placeholder="ID AUTOMÁTICO" disabled>
                                            <input type="hidden"  class="form-control" id="inputIDProd" name="idProduto">
                                        </div>
                                    </div>

                                    <!-- NOME PRODUTO -->
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">NOME: </label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" id="inputNomeProd"name="nome" placeholder="Nome" autofocus>
                                        </div>
                                    </div>

                                    <!-- QUANTIDADE PRODUTO -->
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">QUANTIDADE: </label>
                                        <div class="col-lg-8">
                                            <input type="hidden"  class="form-control" min="0.01" name="preco" id="inputPrecoProd" maxlength="7" step="0.01">
                                            <input type="number" class="form-control" id="inputQuantProd"name="quantidade" placeholder="Quantidade">
                                        </div>
                                    </div>


                                    <div class="campoBotoes">

                                        <!-- Botao Pesquisar-->
                                        <button class="botao" data-toggle="modal" data-target="#modalProduto" type="button">Pesquisar</button>

                                        <!-- Botao limpar-->
                                        <button class="botao" type="reset" value="Reset">Limpar</button>

                                        <!-- Botao Adicionar-->
                                        <button class="botao" type="button" onclick="addHtmlTableRow()">Adicionar</button>
                                    </div>
                                </div>



                                <!-- Coluna direita-->
                                <div class="col">

                                    <!-- ID CLIENTE  -->
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">ID CLIENTE: </label>
                                        <div class="col-lg-8">
                                            <input type="number" class="form-control" id="codigoCliente" name="codigo" placeholder="ID AUTOMÁTICO" disabled>
                                            <input type="hidden"  class="form-control" id="inputIDCli" name="idCliente">
                                        </div>
                                    </div>

                                    <!-- NOME CLIENTE -->
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">NOME: </label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" id="inputNomeCli"name="nomeCli" placeholder="Nome" autofocus>
                                        </div>
                                    </div>

                                    <!-- CPF CLIENTE -->
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">CPF: </label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" id="inputCPFCli" maxlength="11" name="cpfCli" placeholder="CPF" disabled>
                                        </div>
                                    </div>

                                    <div class="campoBotoes">

                                        <!-- Botao Pesquisar-->
                                        <button class="botao" data-toggle="modal" data-target="#modalCliente" type="button">Pesquisar</button>

                                        <!-- Botao limpar-->
                                        <button class="botao" type="reset" value="Reset">Limpar</button>
                                    </div>
                                </div>
                                <!-- Fim coluna direita-->

                            </div>
                            <!-- fim row-->



                            <!-- TITULO TABELA -->
                            <label class="titulotabelas">Carrinho de Compras</label>


                            <!-- TABELA -->
                            <div class="tableScrow">
                                <table class="table" id="tb_carrinho">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">ID</th>
                                            <th scope="col">Produto</th>
                                            <th scope="col">Quantidade</th>
                                            <th scope="col">Preço Uni.</th>
                                            <th scope="col">Total</th>
                                            <th scope="col">Ações</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">01</th>
                                            <td>Skate Cruiser</td>
                                            <td>1</td>
                                            <td>540,00</td>
                                            <td>540,0</td>
                                            <td>
                                                <div class="botoesTabela">
                                                    <button class="botaoBloquear" type="button"><i class="far fa-trash-alt"></i></button>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!-- Fim tableScrow-->
                            <button class="botao" type="submit">Fechar Compra</button>
                        </form>
                        <!-- Fim form -->
                    </div>
                    <!-- fim container-->

                </div>
                <!-- Fim main conteÃºdo-->

            </main>
            <!-- Fim main-->

        </div>


        <!-- Modal: modalProduto -->
        <div class="modal fade" id="modalProduto" tabindex="-1" role="dialog" aria-labelledby="modalProdutos"
             aria-hidden="true">
            <div class="modal-dialog modal-xl" role="document">
                <div class="modal-content">
                    <!--Header-->
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Tabela de Produtos</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <!--Body-->
                    <div class="modal-body">

                        <!-- TABELA -->
                        <div class="tableScrow">
                            <table class="table" id="tb_produto">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Nome</th>
                                        <th scope="col">Quantidade</th>
                                        <th scope="col">Preço Final</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Ações</th>
                                    </tr>

                                </thead>
                                <tbody>
                                    <c:forEach items="${listarProdutos}" var="produto">
                                        <tr>
                                            <th scope="row"><c:out value="${produto.getIdProduto()}" /></th>
                                            <td>${produto.nome}</td>
                                            <td>${produto.quantidade}</td>
                                            <td>${produto.preco}</td>
                                            <td><c:out value="${produto.getDisponivel()}" /></td>
                                            <td>
                                                <div class="botoesTabela">
                                                    <a href="#" class="botaoEditar"><i class="fas fa-plus"></i></a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>

                        </div>
                        <!-- Fim TableScroll -->
                    </div>
                    <!--Footer-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal: modalProduto -->

        <!-- Modal: modalCliente -->
        <div class="modal fade" id="modalCliente" tabindex="-1" role="dialog" aria-labelledby="modalClientes"
             aria-hidden="true">
            <div class="modal-dialog modal-xl" role="document">
                <div class="modal-content">
                    <!--Header-->
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Tabela de Clientes</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <!--Body-->
                    <div class="modal-body">

                        <!-- TABELA -->
                        <div class="tableScrow">
                            <table class="table" id="tb_cliente">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Nome</th>
                                        <th scope="col">CPF</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Ações</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${listarClientes}" var="cli">
                                        <tr>
                                            <th scope="row">${cli.getIdCliente()}</th>
                                            <td>${cli.nome}</td>
                                            <td>${cli.cpf}</td>
                                            <td>${cli.email}</td>
                                            <td>
                                                <div class="botoesTabela">
                                                    <a href="#" class="botaoEditar"><i class="fas fa-plus"></i></a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                        <!-- fim tableScrow-->

                    </div>
                    <!--Footer-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal: modalCliente -->



    </body>

    <script src="libs/jquery/jquery.min.js "></script>
    <script src="libs/jquery/jquery.js "></script>
    <script src="libs/fontawesome-free-5.13.0-web/js/all.min.js "></script>
    <script src="libs/bootstrap/js/bootstrap.bundle.min.js "></script>
    <script src="js/menu.js"></script>
    <script>selectedRowProdutoToInput();selectedRowClienteToInput();</script>

</html>