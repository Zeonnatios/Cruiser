<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TADES - DIÁRIO</title>

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
                                        <li><a href="<%= request.getContextPath()%>/protegido/vendaPeriodo"><i class="fas fa-circle"></i> Pesquisa venda período</a></li>
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
                                        <li><a href="#"><i class="fas fa-circle"></i> Diário</a></li>
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
                    <h2><i class="fab fa-sellsy"></i> DIÁRIO</h2>
                </header>

                <!-- MAIN conteÃºdo -->
                <div class="main-content">

                    <!-- container-->
                    <div class="container">

                        <!-- Form Data-->
                        <form action="" method="POST">

                            <!-- DATA DA VENDA  -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">DATA: </label>
                                <div class="col-lg-10">
                                    <input type="date" class="form-control" id="inputDateVenda" placeholder="00/00/0000">
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

                        <!-- TABELA PRODUTOS MAIS VENDIDOS DIARIO -->
                        <div class="tableScrow">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Nome</th>
                                        <th scope="col">Quantidade</th>
                                        <th scope="col">Preço Unit.</th>
                                        <th scope="col">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">01</th>
                                        <td>Skate Cruiser</td>
                                        <td>50</td>
                                        <td>540,00</td>
                                        <td>$$$</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">02</th>
                                        <td>Rolamento T5</td>
                                        <td>150</td>
                                        <td>29,90</td>
                                        <td>$$$</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">03</th>
                                        <td>Skate Street</td>
                                        <td>300</td>
                                        <td>450,00</td>
                                        <td>$$$</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">03</th>
                                        <td>Tábua</td>
                                        <td>20</td>
                                        <td>250,00</td>
                                        <td>$$$</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <!-- TITULO TABELA -->
                        <label class="titulotabelas">VENDAS POR FILIAL</label>

                        <!-- TABELA VENDAS POR FILIAL DIARIO -->
                        <div class="tableScrow">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Cidade</th>
                                        <th scope="col">Total de Produtos</th>
                                        <th scope="col">Total Diário</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">01</th>
                                        <td>São Paulo</td>
                                        <td>500</td>
                                        <td>1500,20</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">02</th>
                                        <td>Recife</td>
                                        <td>150</td>
                                        <td>1290,90</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">03</th>
                                        <td>Curitiba</td>
                                        <td>300</td>
                                        <td>4450,00</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <!-- fim tableScrow-->

                    </div>
                    <!-- fim container-->

                </div>
                <!-- Fim main conteÃºdo-->

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