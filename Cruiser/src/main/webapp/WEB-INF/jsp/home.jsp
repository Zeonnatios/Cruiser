<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TADES - HOME</title>

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
                                <a href="#" class="active"> <i class="fas fa-home "></i> PRINCIPAL</a>
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
                                        <li><a href="<%= request.getContextPath()%>/protegido_carrinho"><i class="fas fa-circle"></i> Carrinho</a></li>
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
            <!-- Fim Sidebar-->


            <!-- Inicio Main-->
            <main id="mainContent">

                <!-- HEADER -->
                <header>
                    <div class="menu-Cima">
                        <h2><i id="iconMenu" onclick="responsiveSidebar()" class="fas fa-bars"></i></h2>
                        <h2><i class="fas fa-sign-out-alt" alt="logout"></i></h2>
                    </div>


                    <h2><i class="fas fa-home "></i>PRINCIPAL</h2>
                </header>
                <!-- Fim Header-->

                <!-- DIV MAIN (conteudo aqui)-->
                <div class="main-content">

                    <!-- Container(bootstrap) -->
                    <div class="container">

                        <!-- Linha 1 de cards-->
                        <div class="row">

                            <!-- card 1-->
                            <div id="card1" class="col-lg-4 mb-5">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-tittle text-uppercase">Contas Ativas</h5>
                                        <hr>
                                        <p class="card-text py-1">${sessionScope.funcionariosAtivos}/${sessionScope.funcionariosTotal}</p>
                                        <p class="card-text py-1 text-uppercase">Usuários Ativos</p>
                                    </div>
                                </div>
                            </div>

                            <!-- card 2-->
                            <div id="card2" class="col-lg-4 mb-5">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-tittle text-uppercase">Total Venda Mês</h5>
                                        <hr>
                                        <p class="card-text py-1">25.350,87 </p>
                                        <p class="card-text py-1 text-uppercase">Reais R$</p>
                                    </div>
                                </div>
                            </div>

                            <!-- card 3-->
                            <div id="card3" class="col-lg-4 mb-5">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-tittle text-uppercase">Produtos</h5>
                                        <hr>
                                        <p class="card-text py-1">${sessionScope.produtoTotal} tipos disponíveis</p>
                                        <p class="card-text py-1 text-uppercase">Tipos disponivel a compra</p>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- Fim linha 1 de cards-->

                        <!-- Linha 2 de cards-->
                        <div class="row">

                            <!-- card 4-->
                            <div id="card4" class="col-lg-4 mb-5">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-tittle text-uppercase">Clientes ativos</h5>
                                        <hr>
                                        <p class="card-text py-1 text-uppercase">${sessionScope.listarClientes}/${sessionScope.listarClientes}</p>
                                        <p class="card-text py-1 text-uppercase">Total clientes</p>
                                    </div>
                                </div>
                            </div>

                            <!-- card 5-->
                            <div id="card5" class="col-lg-4 mb-5">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-tittle text-uppercase">Total Vendas Diarias</h5>
                                        <hr>
                                        <p class="card-text py-1 text-uppercase">10.576,21</p>
                                        <p class="card-text py-1 text-uppercase">reais r$</p>
                                    </div>
                                </div>
                            </div>


                            <!-- card 6-->
                            <div id="card6" class="col-lg-4 mb-5">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-tittle text-uppercase">Estoque disponível</h5>
                                        <hr>
                                        <p class="card-text py-1 text-uppercase">${sessionScope.totalEstoque} itens disponíveis</p>
                                        <p class="card-text py-1 text-uppercase">Quantidade em estoque</p>
                                    </div>
                                </div>
                            </div>


                        </div>
                        <!-- Fim linha 2 de cards-->


                    </div>
                    <!-- Fim Container-->


                </div>
                <!-- Fim div main conteÃºdo-->

            </main>
            <!-- Fim main-->


        </div>
        <!-- Fim flex dashboard-->


    </body>

    <script src="libs/jquery/jquery.min.js "></script>
    <script src="libs/jquery/jquery.js "></script>
    <script src="libs/fontawesome-free-5.13.0-web/js/all.min.js "></script>
    <script src="libs/bootstrap/js/bootstrap.bundle.min.js "></script>
    <script src="js/menu.js"></script>

</html>