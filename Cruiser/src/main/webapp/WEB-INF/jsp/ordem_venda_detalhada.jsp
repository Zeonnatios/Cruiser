<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TADES - ORDEM DE VENDAS DETALHADAS</title>

        <!-- Icon Logo-->
        <link rel="icon" href="${pageContext.request.contextPath}/imagens/LOGO_CRUISER.png">

        <!-- Bootstrap -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/libs/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/libs/fontawesome-free-5.13.0-web/css/all.min.css">
        <!-- CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">

    </head>

    <body>

        <div class="flex-dashboard">

            <!-- SIDEBAR -->
            <sidebar id="sidebar">

                <div class="sidebar-tittle">
                    <img src="${pageContext.request.contextPath}/imagens/LOGO_CRUISER_02.png" alt="TADES_logo">
                </div>

                <!-- MENU -->
                <div class="menu">


                    <c:if test="${sessionScope.f != null}">

                        <ul>

                            <li class="foto-user">
                                <img src="${pageContext.request.contextPath}/imagens/AVATAR_CRUISER01.png" alt="">
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
                                        <li><a href="<%= request.getContextPath()%>/protegido/listar_funcionarios"><i class="fas fa-circle"></i> Listar Funcionários</a></li>
                                        <li><a href="<%= request.getContextPath()%>/protegido/funcionario_novo"><i class="fas fa-circle"></i> Gerenciar Funcionários</a></li>
                                    </ul>
                                </li>

                            </c:if>
                            <c:if test="${sessionScope.f.getDepartamento() == 'Tecnologia' or sessionScope.f.getDepartamento() == 'Vendas' or sessionScope.f.getDepartamento() == 'Gerencia' or sessionScope.f.getDepartamento() == 'Diretoria'}" >

                                <li class="drop-list">
                                    <a href="#"><i class="fas fa-cart-arrow-down"></i> ORDEM DE VENDA  <i class="fas fa-caret-down"></i></a>
                                    <ul>
                                        <li><a href="<%= request.getContextPath()%>/protegido/carrinho"><i class="fas fa-circle"></i> Carrinho</a></li>
                                        <li><a href="#"><i class="fas fa-circle"></i> Pesquisa venda período</a></li>
                                        <li><a href="<%= request.getContextPath()%>/protegido/vendaDetalhada"><i class="fas fa-circle"></i> Pesquisa venda detalhada</a></li>
                                    </ul>
                                </li>

                            </c:if>
                            <c:if test="${sessionScope.f.getDepartamento() == 'Tecnologia' or sessionScope.f.getDepartamento() == 'Marketing/Produtos'}">

                                <li class ="drop-list">
                                    <a href="#"><i class="fas fa-suitcase "></i> PRODUTOS <i class="fas fa-caret-down"></i></a>
                                    <ul>
                                        <li><a href="<%= request.getContextPath()%>/protegido/listar_produtos"><i class="fas fa-circle"></i> Listar Produtos</a></li>
                                        <li><a href="<%= request.getContextPath()%>/protegido/produto_novo"><i class="fas fa-circle"></i> Gerenciar Produtos</a></li>
                                    </ul>
                                </li>

                            </c:if>
                            <c:if test="${sessionScope.f.getDepartamento() == 'Tecnologia' or sessionScope.f.getDepartamento() == 'Vendas'}" >

                                <li class ="drop-list">
                                    <a href="#"><i class="fas fa-user "></i> CLIENTES <i class="fas fa-caret-down"></i></a>
                                    <ul>
                                        <li><a href="<%= request.getContextPath()%>/protegido/listar_clientes"><i class="fas fa-circle"></i> Listar Clientes</a></li>
                                        <li><a href="<%= request.getContextPath()%>/protegido/cliente_novo"><i class="fas fa-circle"></i> Gerenciar Clientes</a></li>
                                    </ul>
                                </li>

                            </c:if>
                            <c:if test="${sessionScope.f.getDepartamento() == 'Tecnologia' or sessionScope.f.getDepartamento() == 'Gerencia' or sessionScope.f.getDepartamento() == 'Diretoria'}" >

                                <li class="drop-list">
                                    <a href="# "><i class="fas fa-poll "></i> RELATÓRIOS  <i class="fas fa-caret-down"></i></a>
                                    <ul>
                                        <li><a href="<%= request.getContextPath()%>/protegido/diario"><i class="fas fa-circle"></i> Diário</a></li>
                                        <li><a href="<%= request.getContextPath()%>/protegido/mensal"><i class="fas fa-circle"></i> Mensal</a></li>
                                    </ul>
                                </li>

                            </c:if>
                            <c:if test="${sessionScope.f.getDepartamento() == 'Tecnologia'}" >

                                <li class ="drop-list">
                                    <a href="# "><i class="fas fa-globe-americas  "></i> FILIAIS  <i class="fas fa-caret-down"></i></a>
                                    <ul>
                                        <li><a href="<%= request.getContextPath()%>/protegido/listar_filiais"><i class="fas fa-circle"></i> Listar Filiais</a></li>
                                        <li><a href="<%= request.getContextPath()%>/protegido/filial_novo"><i class="fas fa-circle"></i> Gerenciar Filiais</a></li>
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
                    <div class="menu-Cima">
                        <h2><i id="iconMenu" onclick="responsiveSidebar()" class="fas fa-bars"></i></h2>
                        <a href="${pageContext.request.contextPath}/logout"><h2><i class="fas fa-sign-out-alt" alt="logout"></i></h2></a>
                    </div>
                    <h2><i class="fas fa-cart-arrow-down"></i> Detalhes de Vendas</h2>
                </header>

                <!-- MAIN conteÃºdo -->
                <div class="main-content">
                    <!-- container-->
                    <div class="container">

                        <!-- Formulario pesquisar por data-->
                        <form action="" method="POST">

                            <!-- Data Inicial -->
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">DIGITE O CÓDIGO DE VENDA: </label>
                                <div class="col-sm-3">
                                    <input type="number" class="form-control" id="inputCodigoPesquisa" placeholder="DIGITE O CÓDIGO">
                                </div>
                            </div>

                            <!-- Botao limpar-->
                            <div class="campoBotoes">
                                <button class="botao" type="button">Limpar</button>

                                <!-- Botao Salvar-->
                                <button class="botao" type="button">Pesquisar</button>
                            </div>
                        </form>
                        <!-- Fim form -->



                        <!-- TITULO TABELA -->
                        <label class="titulotabelas">PRODUTOS MAIS VENDIDOS</label>


                        <!-- TABELA -->
                        <div class="tableScrow_vendas">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">VENDEDOR</th>
                                        <th scope="col">CLIENTE</th>
                                        <th scope="col">PRODUTO</th>
                                        <th scope="col">QUANTIDADE</th>
                                        <th scope="col">VALOR UNITÁRIO</th>
                                        <th scope="col">DATA</th>
                                        <th scope="col">FILIAL</th>
                                        <th scope="col">TOTAL</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>

                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>

                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>
                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>
                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>
                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>
                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>
                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>
                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>
                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>
                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>
                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>
                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>
                                    <tr>
                                        <td>JORGE RIBEIRO</td>
                                        <td>FLÁVIA MAGALHAES</td>
                                        <td>EIXO T86</td>
                                        <td>03</td>
                                        <td>42.16</td>
                                        <td>24/01/2020</td>
                                        <td>RECIFE</td>
                                        <td>126.50</td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        <!-- Fim tableScrow-->


                    </div>
                    <!-- Fim Container-->

                </div>
                <!-- Fim main conteúdo-->

            </main>
            <!-- Fim main-->

        </div>
    </body>

    <script src="${pageContext.request.contextPath}/libs/jquery/jquery.min.js "></script>
    <script src="${pageContext.request.contextPath}/libs/jquery/jquery.js "></script>
    <script src="${pageContext.request.contextPath}/libs/fontawesome-free-5.13.0-web/js/all.min.js "></script>
    <script src="${pageContext.request.contextPath}/libs/bootstrap/js/bootstrap.bundle.min.js "></script>
    <script src="${pageContext.request.contextPath}/js/menu.js"></script>

</html>