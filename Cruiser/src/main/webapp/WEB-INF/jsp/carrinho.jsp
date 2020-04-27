<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                    <ul>

                        <li class="foto-user">
                            <img src="imagens/AVATAR_CRUISER02.png" alt="">
                            <h4>Joca</h4>
                            <p>Departamento de vendas</p>
                            <p>Matriz</p>
                        </li>


                        <li>
                            <a href="home.jsp " class="active"> <i class="fas fa-home "></i> PRINCIPAL</a>
                        </li>

                        <li>
                            <a href="contas.jsp"><i class="fas fa-user-friends "></i> FUNCIONARIOS</a>
                        </li>

                        <li class="drop-list">
                            <a href="#"><i class="fas fa-cart-arrow-down"></i> ORDEM DE VENDA  <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="#"><i class="fas fa-circle"></i> Carrinho</a></li>
                                <li><a href="ordem_venda_periodo.jsp"><i class="fas fa-circle"></i> Pesquisa venda período</a></li>
                                <li><a href="ordem_venda_detalhada.jsp"><i class="fas fa-circle"></i> Pesquisa venda detalhada</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="produtos.jsp"><i class="fas fa-suitcase "></i> PRODUTOS</a>
                        </li>

                        <li>
                            <a href="clientes.jsp"><i class="fas fa-user "></i> CLIENTES</a>
                        </li>


                        <li class="drop-list">
                            <a href="# "><i class="fas fa-poll "></i> RELATÓRIOS  <i class="fas fa-caret-down"></i></a>
                            <ul>
                                <li><a href="diario.jsp"><i class="fas fa-circle"></i> Diário</a></li>
                                <li><a href="mensal.jsp"><i class="fas fa-circle"></i> Mensal</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="filiais.jsp"><i class="fas fa-globe-americas "></i> FILIAIS</a>
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
                    <h2><i class="fas fa-cart-arrow-down"></i> CARRINHO</h2>
                </header>

                <!-- MAIN conteÃºdo -->
                <div class="main-content">
                    <!-- container-->
                    <div class="container">

                        <!-- row-->
                        <div class="row">

                            <!-- Coluna esquerda-->
                            <div class="col">
                                <!-- FORM PARA INSERIR PRODUTOS NO CARRINHO -->
                                <form action="" method="POST">

                                    <!-- ID PRODUTO  -->
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">ID PRODUTO: </label>
                                        <div class="col-lg-8">
                                            <input type="number" class="form-control" id="inputIDProd" placeholder="ID AUTOMÁTICO" disabled>
                                        </div>
                                    </div>

                                    <!-- NOME PRODUTO -->
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">NOME: </label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" id="inputNomeProd" placeholder="Nome" autofocus>
                                        </div>
                                    </div>

                                    <!-- QUANTIDADE PRODUTO -->
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">QUANTIDADE: </label>
                                        <div class="col-lg-8">
                                            <input type="number" class="form-control" id="inputQuantProd" placeholder="Quantidade">
                                        </div>
                                    </div>

                                    <!-- Botao limpar-->
                                    <div class="campoBotoes">
                                        <button class="botao" type="button">Limpar</button>

                                        <!-- Botao Adicionar-->
                                        <button class="botao" type="button">Adicionar</button>
                                    </div>
                                </form>
                                <!-- Fim form -->
                            </div>



                            <!-- Coluna direita-->
                            <div class="col">

                                <!-- FORM PARA SELECIONAR CLIENTE NA COMPRA -->
                                <form action="" method="POST">

                                    <!-- ID CLIENTE  -->
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">ID CLIENTE: </label>
                                        <div class="col-lg-8">
                                            <input type="number" class="form-control" id="inputIDCli" placeholder="ID AUTOMÁTICO" disabled>
                                        </div>
                                    </div>

                                    <!-- NOME CLIENTE -->
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">NOME: </label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" id="inputNomeCli" placeholder="Nome" autofocus>
                                        </div>
                                    </div>

                                    <!-- CPF CLIENTE -->
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">CPF: </label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" id="inputCPFCli" placeholder="CPF">
                                        </div>
                                    </div>

                                    <!-- Botao limpar-->
                                    <div class="campoBotoes">
                                        <button class="botao" type="button">Limpar</button>

                                        <!-- Botao Pesquisar-->
                                        <button class="botao" type="button">Pesquisar</button>
                                    </div>
                                </form>
                                <!-- Fim form -->
                            </div>
                            <!-- Fim coluna direita-->

                        </div>
                        <!-- fim row-->



                        <!-- TITULO TABELA -->
                        <label class="titulotabelas">TABELA DE FILIAIS</label>


                        <!-- TABELA -->
                        <div class="tableScrow">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Nome</th>
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
                                    <tr>
                                        <th scope="row">02</th>
                                        <td>Rolamento T5</td>
                                        <td>2</td>
                                        <td>29,90</td>
                                        <td>59,80</td>
                                        <td>
                                            <div class="botoesTabela">
                                                <button class="botaoBloquear" type="button"><i class="far fa-trash-alt"></i></button>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">03</th>
                                        <td>Skate Street</td>
                                        <td>1</td>
                                        <td>450,00</td>
                                        <td>450,00</td>
                                        <td>
                                            <div class="botoesTabela">
                                                <button class="botaoBloquear" type="button"><i class="far fa-trash-alt"></i></button>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">03</th>
                                        <td>Skate Roller</td>
                                        <td>1</td>
                                        <td>420,00</td>
                                        <td>420,00</td>
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