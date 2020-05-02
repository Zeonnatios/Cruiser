<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TADES - PRODUTOS</title>

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
                            <h4>Joca</h4>
                            <p>Departamento de vendas</p>
                            <p>Matriz</p>
                        </li>


                        <li>
                            <a href="<%= request.getContextPath()%>/home" class="active"> <i class="fas fa-home "></i> PRINCIPAL</a>
                        </li>

                        <li class="drop-list">
                            <a href="#"><i class="fas fa-user-friends "></i> FUNCIONARIOS <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="<%= request.getContextPath()%>/listar_funcionarios"><i class="fas fa-circle"></i> Listar Funcionários</a></li>
                                <li><a href="<%= request.getContextPath()%>/funcionarios"><i class="fas fa-circle"></i> Gerenciar Funcionários</a></li>
                            </ul>
                        </li>

                        <li class="drop-list">
                            <a href="#"><i class="fas fa-cart-arrow-down"></i> ORDEM DE VENDA  <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="<%= request.getContextPath()%>/carrinho"><i class="fas fa-circle"></i> Carrinho</a></li>
                                <li><a href="<%= request.getContextPath()%>/vendaDetalhada"><i class="fas fa-circle"></i> Pesquisa venda período</a></li>
                                <li><a href="<%= request.getContextPath()%>/vendaDetalhada"><i class="fas fa-circle"></i> Pesquisa venda detalhada</a></li>
                            </ul>
                        </li>

                        <li class ="drop-list">
                            <a href="#"><i class="fas fa-suitcase "></i> PRODUTOS <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="<%= request.getContextPath()%>/listar_produtos"><i class="fas fa-circle"></i> Listar Produtos</a></li>
                                <li><a href="<%= request.getContextPath()%>/produtos"><i class="fas fa-circle"></i> Gerenciar Produtos</a></li>
                            </ul>
                        </li>

                        <li class ="drop-list">
                            <a href="#"><i class="fas fa-user "></i> CLIENTES <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="<%= request.getContextPath()%>/listar_clientes"><i class="fas fa-circle"></i> Listar Clientes</a></li>
                                <li><a href="<%= request.getContextPath()%>/clientes"><i class="fas fa-circle"></i> Gerenciar Clientes</a></li>
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
                            <ul>
                                <li><a href="<%= request.getContextPath()%>/listar_filiais"><i class="fas fa-circle"></i> Listar Filiais</a></li>
                                <li><a href="<%= request.getContextPath()%>/filiais"><i class="fas fa-circle"></i> Gerenciar Filiais</a></li>
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
                    <h2><i class="fas fa-suitcase"></i> PRODUTOS</h2>
                </header>

                <!-- MAIN conteÃºdo -->
                <div class="main-content">

                    <!-- Container-->
                    <div class="container">

                        <form action="" method="POST">
                            <!-- ID PRODUTO  -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">ID PRODUTO: </label>
                                <div class="col-lg-10">
                                    <input type="number" class="form-control" id="inputIDProd" placeholder="ID AUTOMÁTICO" disabled>
                                </div>
                            </div>

                            <!-- NOME PRODUTO -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">NOME: </label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputNomeProd" placeholder="Nome" autofocus>
                                </div>
                            </div>

                            <!-- QUANTIDADE PRODUTO -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">QUANTIDADE: </label>
                                <div class="col-lg-10">
                                    <input type="number" class="form-control" id="inputQuantProd" placeholder="Quantidade">
                                </div>
                            </div>

                            <!-- PREÃO FINAL PRODUTO -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">PREÇO FINAL: </label>
                                <div class="col-lg-10">
                                    <input type="number" step="0.01" class="form-control" min="0.01" id="inputPrecoProd" placeholder="Preço Final">
                                </div>
                            </div>

                            <!-- CATEGORIA PRODUTO -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">CATEGORIA: </label>
                                <div class="col-lg-10">
                                    <select class="form-control" name="Loja">
                                        <option>Selecione:</option>
                                        <option>Pranchas</option>
                                        <option>Skate Completo</option>
                                        <option>Acessórios</option>
                                        <option>Customização</option>
                                    </select>
                                </div>
                            </div>

                            <!-- Botao limpar-->
                            <div class="campoBotoes">
                                <button class="botao" type="reset" value="Reset">Limpar</button>

                                <!-- Botao Salvar-->
                                <button class="botao" type="button">Salvar</button>
                            </div>

                        </form>
                        <!-- Fim form -->

                        <!-- TITULO TABELA -->
                        <label class="titulotabelas">VENDAS POR FILIAL</label>

                        <!-- TABELA -->
                        <div class="tableScrow">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Nome</th>
                                        <th scope="col">Quantidade</th>
                                        <th scope="col">Preço Final</th>
                                        <th scope="col">Categoria</th>
                                        <th scope="col">Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">01</th>
                                        <td>Skate Cruiser</td>
                                        <td>50</td>
                                        <td>540,00</td>
                                        <td>Skate Completo</td>
                                        <td>
                                            <div class="botoesTabela">
                                                <button class="botaoEditar" type="button"><i class="fas fa-edit"></i></button>
                                                <button class="botaoBloquear" type="button"><i class="fas fa-lock"></i></button>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">02</th>
                                        <td>Rolamento T5</td>
                                        <td>150</td>
                                        <td>29,90</td>
                                        <td>Acessórios</td>
                                        <td>
                                            <div class="botoesTabela">
                                                <button class="botaoEditar" type="button"><i class="fas fa-edit"></i></button>
                                                <button class="botaoBloquear" type="button"><i class="fas fa-lock"></i></button>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">03</th>
                                        <td>Skate Street</td>
                                        <td>300</td>
                                        <td>450,00</td>
                                        <td>Skate Completo</td>
                                        <td>
                                            <div class="botoesTabela">
                                                <button class="botaoEditar" type="button"><i class="fas fa-edit"></i></button>
                                                <button class="botaoBloquear" type="button"><i class="fas fa-lock"></i></button>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
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