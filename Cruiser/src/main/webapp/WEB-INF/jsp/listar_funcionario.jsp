<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TADES - FUNCIONARIOS</title>

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

                    <ul>

                        <li class="foto-user">
                            <img src="imagens/AVATAR_CRUISER01.png" alt="">
                            <h4>Jorgezada</h4>
                            <p>Departamento de TI</p>
                            <p>Matriz</p>
                        </li>


                        <li>
                            <a href="<%= request.getContextPath()%>/home" class="active"> <i class="fas fa-home "></i> PRINCIPAL</a>
                        </li>

                        <li class="drop-list">
                            <a href="#"><i class="fas fa-user-friends "></i> FUNCIONARIOS <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="#"><i class="fas fa-circle"></i> Listar Funcionários</a></li>
                                <li><a href="<%= request.getContextPath()%>/funcionario_novo"><i class="fas fa-circle"></i> Gerenciar Funcionários</a></li>
                            </ul>
                        </li>

                        <li class="drop-list">
                            <a href="#"><i class="fas fa-cart-arrow-down"></i> ORDEM DE VENDA  <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="<%= request.getContextPath()%>/carrinho"><i class="fas fa-circle"></i> Carrinho</a></li>
                                <li><a href="<%= request.getContextPath()%>/vendaPeriodo"><i class="fas fa-circle"></i> Pesquisa venda período</a></li>
                                <li><a href="<%= request.getContextPath()%>/vendaDetalhada"><i class="fas fa-circle"></i> Pesquisa venda detalhada</a></li>
                            </ul>
                        </li>

                        <li class ="drop-list">
                            <a href="#"><i class="fas fa-suitcase "></i> PRODUTOS <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="<%= request.getContextPath()%>/listar_produtos"><i class="fas fa-circle"></i> Listar Produtos</a></li>
                                <li><a href="<%= request.getContextPath()%>/produto_novo"><i class="fas fa-circle"></i> Gerenciar Produtos</a></li>
                            </ul>
                        </li>

                        <li class ="drop-list">
                            <a href="#"><i class="fas fa-user "></i> CLIENTES <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="<%= request.getContextPath()%>/listar_clientes"><i class="fas fa-circle"></i> Listar Clientes</a></li>
                                <li><a href="<%= request.getContextPath()%>/cliente_novo"><i class="fas fa-circle"></i> Gerenciar Clientes</a></li>
                            </ul>
                        </li>


                        <li class="drop-list">
                            <a href="# "><i class="fas fa-poll "></i> RELATÓRIOS  <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="<%= request.getContextPath()%>/diario"><i class="fas fa-circle"></i> Diário</a></li>
                                <li><a href="<%= request.getContextPath()%>/mensal"><i class="fas fa-circle"></i> Mensal</a></li>
                            </ul>
                        </li>

                        <li class ="drop-list">
                            <a href="# "><i class="fas fa-globe-americas  "></i> FILIAIS  <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="<%= request.getContextPath()%>/listar_filiais"><i class="fas fa-circle"></i> Listar Filiais</a></li>
                                <li><a href="<%= request.getContextPath()%>/filial_novo"><i class="fas fa-circle"></i> Gerenciar Filiais</a></li>
                            </ul>
                        </li>

                    </ul>

                </div>

            </sidebar>
            <!-- Fim sidebar-->


            <!-- MAIN-->
            <main id="mainContent">

                <!-- HEADER -->
                <header>
                    <h2><i id="iconMenu" onclick="responsiveSidebar()" class="fas fa-bars"></i></h2>
                    <h2><i class="fas fa-users"></i> FUNCIONARIOS</h2>
                </header>

                <!-- MAIN conteÃºdo -->
                <div class="main-content">

                    <!-- container-->
                    <div class="container">

                        <c:if test="${sessionScope.msgSucesso != null}">
                            <div class="alert alert-success" role="alert">
                                <c:out value="${sessionScope.msgSucesso}" />
                            </div>
                            <c:remove scope="session" var="msgSucesso" />
                        </c:if>
                        <c:if test="${sessionScope.msgErro != null}">
                            <div class="alert alert-danger" role="alert">
                                <c:out value="${sessionScope.msgErro}" />
                            </div>
                            <c:remove scope="session" var="msgErro" />
                        </c:if>

                        <!-- TITULO TABELA -->
                        <label class="titulotabelas">TABELA DE FILIAIS</label>


                        <!-- TABELA -->
                        <div class="tableScrow">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Nome</th>
                                        <th scope="col">Cidade</th>
                                        <th scope="col">Departamento</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listarFuncionarios}" var="fun">
                                        <tr>
                                            <th scope="row"><c:out value="${fun.getIdFuncionario()}" /></th>
                                            <td><c:out value="${fun.getNome()}" /></td>
                                            <td><c:out value="${fun.getCidade()}" /></td>
                                            <td><c:out value="${fun.getDepartamento()}" /></td>
                                            <td><c:out value="${fun.getStatus()}" /></td>
                                            <td>
                                                <div class="botoesTabela">
                                                    <a href="${pageContext.request.contextPath}/funcionario_editar?id=${fun.getIdFuncionario()}" class="botaoEditar"><i class="fas fa-edit"></i></a>

                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <a href="${pageContext.request.contextPath}/funcionario_novo" class="botao">Incluir novo</a>
                        </div>
                        <!-- Fim tableScrow-->

                    </div>
                    <!-- Fim Container-->

                </div>
                <!-- Fim main conteÃºdo-->

            </main>
            <!-- Fim main-->

        </div>
    </body>

    <script src="libs/jquery/jquery.min.js "></script>
    <script src="libs/jquery/jquery.js "></script>
    <script src="libs/fontawesome-free-5.13.0-web/js/all.min.js "></script>
    <script src="libs/bootstrap/js/bootstrap.bundle.min.js "></script>
    <script src="js/menu.js"></script>

</html>