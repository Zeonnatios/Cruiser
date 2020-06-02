<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TADES - PRODUTOS</title>

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
                                        <li><a href="#"><i class="fas fa-circle"></i> Gerenciar Produtos</a></li>
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
                    <c:choose>
                        <c:when test="${acao == 'incluir'}">
                            <h2><i class="fas fa-suitcase"></i> CADASTRAR NOVO PRODUTO</h2>
                        </c:when>
                        <c:when test="${acao == 'alterar'}">
                            <h2><i class="fas fa-users"></i>EDITAR PRODUTO</h2>
                        </c:when>
                    </c:choose>

                </header>

                <!-- MAIN conteÃºdo -->
                <div class="main-content">

                    <!-- Container-->
                    <div class="container">
                        <c:choose>
                            <c:when test="${acao == 'incluir'}">
                                <form method="post" action="${pageContext.request.contextPath}/protegido/produto_salvar" >
                                    <!-- ID PRODUTO  -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">ID PRODUTO: </label>
                                        <div class="col-lg-10">
                                            <input type="number" class="form-control" id="inputIDProd" name="id" placeholder="ID AUTOMÁTICO" disabled>
                                        </div>
                                    </div>

                                    <!-- NOME PRODUTO -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">NOME: </label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control" name="nome" id="inputNomeProd" maxlength="50" placeholder="Nome" autofocus>
                                        </div>
                                    </div>

                                    <!-- QUANTIDADE PRODUTO -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">QUANTIDADE: </label>
                                        <div class="col-lg-10">
                                            <input type="number" class="form-control"name="quantidade" id="inputQuantProd" placeholder="Quantidade">
                                        </div>
                                    </div>

                                    <!-- PREÇO PRODUTO -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">PREÇO FINAL: </label>
                                        <div class="col-lg-10">
                                            <input type="number"  class="form-control" min="0.01" name="preco" id="inputPrecoProd" maxlength="7" step="0.01"  placeholder="Preço Final">
                                        </div>
                                    </div>

                                    <!-- CATEGORIA PRODUTO -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">CATEGORIA: </label>
                                        <div class="col-lg-10">
                                            <select class="form-control" name="categoria">
                                                <option value="">Selecione:</option>
                                                <option value="Pranchas">Pranchas</option>
                                                <option value="Skate Completo">Skate Completo</option>
                                                <option value="Acessorios">Acessórios</option>
                                                <option value="Customizacao">Customização</option>
                                            </select>
                                        </div>
                                    </div>

                                    <!-- Botao limpar-->
                                    <div class="campoBotoes">
                                        <button class="botao" type="reset" value="Reset">Limpar</button>

                                        <!-- Botao Salvar-->
                                        <button class="botao" type="submit">Salvar</button>
                                    </div>

                                </form>
                                <!-- Fim form -->
                            </c:when>

                            <c:when test="${acao == 'alterar'}">
                                <c:if test="${sessionScope.msgErro != null}">
                                    <div class="alert alert-danger" role="alert">

                                        <c:out value="${sessionScope.msgErro}"/>
                                    </div>
                                    <c:remove scope="session" var="msgErro"/>
                                </c:if>
                                <!-- FORM EDITAR PRODUTO-->
                                <form method="post" action="${pageContext.request.contextPath}/protegido/produto_update" >
                                    <!-- ID PRODUTO  -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">ID PRODUTO: </label>
                                        <div class="col-lg-10">
                                            <input type="number" class="form-control" id="inputIDProd" name="codigo" placeholder="ID AUTOMÁTICO" value="${produto.getIdProduto()}" disabled>
                                            <input type="hidden"  class="form-control" id="inputIDProd" name="id" value="${produto.getIdProduto()}">
                                        </div>
                                    </div>

                                    <!-- NOME PRODUTO -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">NOME: </label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control" name="nome" id="inputNomeProd" maxlength="50" placeholder="Nome" autofocus required value="${produto.getNome()}">
                                        </div>
                                    </div>

                                    <!-- QUANTIDADE PRODUTO -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">QUANTIDADE: </label>
                                        <div class="col-lg-10">
                                            <input type="number" class="form-control "name="quantidade" id="inputQuantProd" placeholder="Quantidade" value="${produto.getQuantidade()}">
                                        </div>
                                    </div>

                                    <!-- PREÇO PRODUTO -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">PREÇO FINAL: </label>
                                        <div class="col-lg-10">
                                            <input type="number" class="form-control" min="0.01" name="preco" id="inputPrecoProd" maxlength="7" step="0.01" placeholder="Preço Final" value="${produto.getPreco()}">
                                        </div>
                                    </div>

                                    <!-- CATEGORIA PRODUTO -->
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">CATEGORIA: </label>
                                        <div class="col-lg-10">
                                            <select class="form-control" name="categoria">
                                                <option value="">Selecione:</option>
                                                <option value="Pranchas">Pranchas</option>
                                                <option value="Skate Completo">Skate Completo</option>
                                                <option value="Acessorios">Acessórios</option>
                                                <option value="Customizacao">Customização</option>
                                            </select>
                                        </div>
                                    </div>

                                    <!-- Botao limpar-->
                                    <div class="campoBotoes">
                                        <button class="botao" type="reset" value="Reset">Limpar</button>

                                        <!-- Botao Salvar-->
                                        <button class="botao" type="submit">Salvar</button>
                                    </div>

                                </form>
                                <!-- Fim form -->
                            </c:when>
                        </c:choose>

                    </div>
                    <!-- Fim Container-->

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