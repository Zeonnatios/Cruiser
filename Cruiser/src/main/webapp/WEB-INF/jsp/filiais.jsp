<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TADES - FILIAIS</title>

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
                            <img src="imagens/AVATAR_CRUISER02.png" alt="">
                            <h4>Juca</h4>
                            <p>Departamento de TI</p>
                            <p>Matriz</p>
                        </li>


                        <li>
                            <a href="<%= request.getContextPath()%>/home" class="active"> <i class="fas fa-home "></i> PRINCIPAL</a>
                        </li>

                        <li class="drop-list">
                            <a href="#"><i class="fas fa-user-friends "></i> FUNCIONARIOS <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="<%= request.getContextPath()%>/listar_funcionarios"><i class="fas fa-circle"></i> Listar Funcionários</a></li>
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
                                <li><a href="#"><i class="fas fa-circle"></i> Gerenciar Filiais</a></li>
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

                    <c:choose>
                        <c:when test="${acao == 'incluir'}">
                            <h2><i class="fas fa-cogs"></i>CADASTRAR NOVA FILIAL</h2>
                        </c:when>
                        <c:when test="${acao == 'alterar'}">
                            <h2><i class="fas fa-cogs"></i>EDITAR DADOS DA FILIAL</h2>
                        </c:when>
                    </c:choose>
                </header>

                <!-- MAIN conteÃºdo -->
                <div class="main-content">

                    <!-- container-->
                    <div class="container">

                        <c:choose>
                            <c:when test="${acao == 'incluir'}">
                                <form method="post" action="${pageContext.request.contextPath}/filial_salvar">
                                    <!-- ID FILIAL  -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">ID FILIAL: </label>
                                        <div class="col-lg-10">
                                            <input type="number" class="form-control" id="inputIDFilial" name="txtID"  placeholder="ID AUTOMÁTICO" disabled>
                                        </div>
                                    </div>

                                    <!-- CIDADE FILIAL-->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">CIDADE: </label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control" id="inputCidadeFilial" name="txtCidade" maxlength="50" placeholder="Cidade" required autofocus>
                                        </div>
                                    </div>

                                    <!-- TELEFONE FILIAL -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">TELEFONE: </label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control" id="inputTelFilial" name="txtTelefone" maxlength="11" placeholder="Telefone" required>
                                        </div>
                                    </div>

                                    <!-- TIPO -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">TIPO: </label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control"  id="inputEnderecoFilial" name="txtTipo" maxlength="6" placeholder="Tipo" required>
                                        </div>
                                    </div>

                                    <!-- Botao limpar-->
                                    <div class="campoBotoes">
                                        <button class="botao" type="reset" value="Reset">Limpar</button>

                                        <!-- Botao Salvar-->
                                        <button class="botao" type="submit">Salvar</button>
                                    </div>

                                </form>
                                <!-- Fim form-->
                            </c:when>

                            <c:when test="${acao == 'alterar'}">
                                <form method="post" action="${pageContext.request.contextPath}/filial_update">
                                    <!-- ID FILIAL  -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">ID FILIAL: </label>
                                        <div class="col-lg-10">
                                            <input type="number" class="form-control" id="inputIDFilial" name="codigo" value="${filial.getIdFilial()}"  placeholder="ID AUTOMÁTICO" disabled>
                                            <input type="hidden"  class="form-control" id="inputIDUser" name="txtID" value="${filial.getIdFilial()}">
                                        </div>
                                    </div>

                                    <!-- CIDADE FILIAL-->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">CIDADE: </label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control" id="inputCidadeFilial" name="txtCidade" value="${filial.getCidade()}" maxlength="50" placeholder="Cidade"  required autofocus>
                                        </div>
                                    </div>

                                    <!-- TELEFONE FILIAL -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">TELEFONE: </label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control" id="inputTelFilial" name="txtTelefone" value="${filial.getTelefone()}" maxlength="11" placeholder="Telefone" required>
                                        </div>
                                    </div>

                                    <!-- TIPO -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">TIPO: </label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control"  id="inputEnderecoFilial" name="txtTipo" value="${filial.getTipo()}" maxlength="6" placeholder="Tipo" required>
                                        </div>
                                    </div>

                                    <!-- Botao limpar-->
                                    <div class="campoBotoes">
                                        <button class="botao" type="reset" value="Reset">Limpar</button>

                                        <!-- Botao Salvar-->
                                        <button class="botao" type="submit">Salvar</button>
                                    </div>

                                </form>
                                <!-- Fim form-->
                            </c:when>
                        </c:choose>

                    </div>
                    <!-- fim container-->
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