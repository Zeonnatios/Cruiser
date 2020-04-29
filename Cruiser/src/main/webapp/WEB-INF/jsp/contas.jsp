<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                        <li>
                            <a href="#"><i class="fas fa-user-friends "></i> FUNCIONARIOS</a>
                        </li>

                        <li class="drop-list">
                            <a href="#"><i class="fas fa-cart-arrow-down"></i> ORDEM DE VENDA  <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="<%= request.getContextPath()%>/carrinho"><i class="fas fa-circle"></i> Carrinho</a></li>
                                <li><a href="<%= request.getContextPath()%>/vendaPeriodo"><i class="fas fa-circle"></i> Pesquisa venda período</a></li>
                                <li><a href="<%= request.getContextPath()%>/vendaDetalhada"><i class="fas fa-circle"></i> Pesquisa venda detalhada</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="<%= request.getContextPath()%>/produtos"><i class="fas fa-suitcase "></i> PRODUTOS</a>
                        </li>

                        <li>
                            <a href="<%= request.getContextPath()%>/clientes"><i class="fas fa-user "></i> CLIENTES</a>
                        </li>


                        <li class="drop-list">
                            <a href="# "><i class="fas fa-poll "></i> RELATÓRIOS  <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="<%= request.getContextPath()%>/diario"><i class="fas fa-circle"></i> Diário</a></li>
                                <li><a href="<%= request.getContextPath()%>/mensal"><i class="fas fa-circle"></i> Mensal</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="<%= request.getContextPath()%>/filiais"><i class="fas fa-globe-americas "></i> FILIAIS</a>
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

                        <!-- FORM CADASTRAR USUÃRIO-->
                        <form action="<%= request.getContextPath()%>/registrar>" method="post">
                            <!-- ID USUÃRIO  -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">ID USUÁRIO: </label>
                                <div class="col-lg-10">
                                    <input type="number" class="form-control" id="inputIDUser" name="idFuncionario" placeholder="ID AUTOMÁTICO" disabled>
                                </div>
                            </div>

                            <!-- NOME COMPLETO -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">NOME: </label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputNameUser" name="nome" placeholder="Nome" autofocus>
                                </div>
                            </div>

                            <!-- EMAIL DE ACESSO -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">EMAIL: </label>
                                <div class="col-lg-10">
                                    <input type="email" class="form-control" name="email"  id="inputEmailUser" placeholder="Email para acesso ao sistema">
                                </div>
                            </div>

                            <!-- SENHA -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">SENHA: </label>
                                <div class="col-lg-10">
                                    <input type="password" class="form-control" name="senha" id="inputPassword" placeholder="Senha">
                                </div>
                            </div>

                            <!-- LOJA -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">CIDADE: </label>
                                <div class="col-lg-10">
                                    <select class="form-control" name="cidade">
                                        <option>Selecione:</option>
                                        <option value="São Paulo">São Paulo</option>
                                        <option value="Campina Grande">Campina Grande</option>
                                        <option value="Joinville">Joinville</option>
                                        <option value="Brasília">Brasília</option>
                                    </select>
                                </div>
                            </div>

                            <!-- DEPARTAMENTO -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">DEPARTAMENTO: </label>
                                <div class="col-lg-10">
                                    <select class="form-control" name="departamento">
                                        <option>Selecione:</option>
                                        <option value="Marketing/Produtos">Marketing/Produtos</option>
                                        <option value="Vendas">Vendas</option>
                                        <option value="Tecnologia">Tecnologia</option>
                                        <option value="Gerência">Gerência</option>
                                        <option value="Diretoria">Diretoria</option>
                                    </select>
                                </div>
                            </div>

                            <!-- STATUS -->
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">STATUS: </label>
                                <div class="col-lg-10">
                                    <select class="form-control" name="status">
                                        <option>Selecione:</option>
                                        <option value="1">Ativo</option>
                                        <option value="2">Inativo</option>
                                    </select>
                                </div>
                            </div>

                            <!-- Botao limpar-->
                            <div class="campoBotoes">
                                <button class="botao" type="button">Limpar</button>

                                <!-- Botao Salvar-->
                                <button class="botao" type="button">Salvar</button>
                            </div>

                        </form>
                        <!-- Fim form-->


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
                                    <tr>
                                        <th scope="row">001</th>
                                        <td>Hanz Zimmerman</td>
                                        <td>Recife</td>
                                        <td>Marketing</td>
                                        <td>Ativo</td>
                                        <td>
                                            <div class="botoesTabela">
                                                <button class="botaoEditar" type="button"><i class="fas fa-edit"></i></button>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">002</th>
                                        <td>Jacob Malman</td>
                                        <td>São Paulo</td>
                                        <td>TI</td>
                                        <td>Ativo</td>
                                        <td>
                                            <div class="botoesTabela">
                                                <button class="botaoEditar" type="button"><i class="fas fa-edit"></i></button>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">003</th>
                                        <td>Larry Sullivan</td>
                                        <td>Curitiba</td>
                                        <td>Vendas</td>
                                        <td>Ativo</td>
                                        <td>
                                            <div class="botoesTabela">
                                                <button class="botaoEditar" type="button"><i class="fas fa-edit"></i></button>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">003</th>
                                        <td>Larry Sullivan</td>
                                        <td>Curitiba</td>
                                        <td>Vendas</td>
                                        <td>Ativo</td>
                                        <td>
                                            <div class="botoesTabela">
                                                <button class="botaoEditar" type="button"><i class="fas fa-edit"></i></button>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">003</th>
                                        <td>Larry Sullivan</td>
                                        <td>Curitiba</td>
                                        <td>Vendas</td>
                                        <td>Ativo</td>
                                        <td>
                                            <div class="botoesTabela">
                                                <button class="botaoEditar" type="button"><i class="fas fa-edit"></i></button>
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